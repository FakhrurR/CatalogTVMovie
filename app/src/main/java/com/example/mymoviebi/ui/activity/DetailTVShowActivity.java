package com.example.mymoviebi.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.mymoviebi.BuildConfig;
import com.example.mymoviebi.Links;
import com.example.mymoviebi.R;
import com.example.mymoviebi.databinding.ActivityDetailBinding;
import com.example.mymoviebi.local.dao.TVShowDao;
import com.example.mymoviebi.local.db.MovieDatabase;
import com.example.mymoviebi.modul.TVShowResponse;
import com.example.mymoviebi.modul.TrailerResponse;
import com.example.mymoviebi.rest.MovieService;
import com.example.mymoviebi.ui.adapter.TrailerAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailTVShowActivity extends AppCompatActivity {

    private ActivityDetailBinding activityDetailBinding;
    private TrailerAdapter adapter;
    private List<TrailerResponse.ResultsBean> trailers = new ArrayList<>();
    private boolean isFavorite = false;
    private MovieDatabase movieDatabase;
    private TVShowResponse.ResultsBean resultsBean1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resultsBean1 = getIntent().getParcelableExtra("tvShow_intent");

        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        movieDatabase = MovieDatabase.getDatabase(this);

        initRecyclerView();
        displayDetailTVShow(resultsBean1);
        isTVShowFavorite(resultsBean1.getId());

        if (savedInstanceState != null) {
            trailers = savedInstanceState.getParcelableArrayList("trailers");
            prepareView();
        } else {
            displayDetailTrailer(resultsBean1.getId());
        }

        activityDetailBinding.toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        setSupportActionBar(activityDetailBinding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else if (item.getItemId() == R.id.favorite) {
            if (isFavorite) {
                item.setIcon(R.drawable.ic_favorite_border_black_24dp);
                deleteFromFavorite(resultsBean1.getId());
                isFavorite = false;
            } else {
                item.setIcon(R.drawable.ic_favorite_black_24dp);
                addToFavorite(resultsBean1);
                isFavorite = true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu_detail, menu);
        if (isFavorite) {
            menu.findItem(R.id.favorite).setIcon(getResources()
                    .getDrawable(R.drawable.ic_favorite_black_24dp));
        } else {
            menu.findItem(R.id.favorite).setIcon(getResources()
                    .getDrawable(R.drawable.ic_favorite_border_black_24dp));
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void addToFavorite(TVShowResponse.ResultsBean tvShow) {
        TVShowDao tvShowDao = movieDatabase.tvShowDao();
        try {
            tvShowDao.insertTVShow(tvShow);
            Snackbar snackbar = Snackbar.make(activityDetailBinding.coordinator, "Add to Favorite", Snackbar.LENGTH_SHORT);
            snackbar.show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("addError", e.getMessage());
        }
    }

    private void deleteFromFavorite(int id) {
        TVShowDao tvShowDao = movieDatabase.tvShowDao();

        try {
            tvShowDao.deleteTVShow(id);
            Snackbar snackbar = Snackbar.make(activityDetailBinding.coordinator, "Delete to Favorite", Snackbar.LENGTH_SHORT);
            snackbar.show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("deleteError", e.getMessage());
        }
    }

    private void isTVShowFavorite(int id) {
        TVShowDao tvShowDao = movieDatabase.tvShowDao();

        try {
            int count = tvShowDao.countTVShowById(id);
            isFavorite = count != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(DetailTVShowActivity.this, LinearLayoutManager.HORIZONTAL,
                        false);
        activityDetailBinding.rvTrailer.setLayoutManager(layoutManager);
    }


    private void displayDetailTVShow(TVShowResponse.ResultsBean resultsBean1) {
        Glide.with(this).asBitmap()
                .load(Links.BACKGROUND_BASE_URL + resultsBean1.getPosterPath()).into(activityDetailBinding.imageMovieBackground);
        Glide.with(this).asBitmap()
                .load(Links.IMAGE_BASE_URL + resultsBean1.getPosterPath()).into(activityDetailBinding.imageMovie);
        activityDetailBinding.toolbar.setTitle(resultsBean1.getName());
        activityDetailBinding.originalTitle.setText(resultsBean1.getOriginalName());
        activityDetailBinding.popularity.setText(String.valueOf(resultsBean1.getPopularity()));
        activityDetailBinding.rateMovie.setText(String.valueOf(resultsBean1.getVoteAverage()));
        activityDetailBinding.releaseDate.setText(resultsBean1.getFirstAirDate());
        activityDetailBinding.originalLanguage.setText(resultsBean1.getOriginalLanguage());
        activityDetailBinding.movieOverview.setText(resultsBean1.getOverview());
    }

    private void displayDetailTrailer(int tvId) {
        activityDetailBinding.progressMovie.setVisibility(View.VISIBLE);
        MovieService.getAPI().getTrailersByTVShowId(tvId, BuildConfig.API_KEY).enqueue(new Callback<TrailerResponse>() {
            @Override
            public void onResponse(@NonNull Call<TrailerResponse> call, @NonNull Response<TrailerResponse> response) {
                if (response.isSuccessful()) {
                    trailers = null;
                    if (response.body() != null) {
                        trailers = response.body().getResults();
                    }
                    prepareView();
                }
                if (trailers.isEmpty()) {
                    activityDetailBinding.trailerEmpty.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<TrailerResponse> call, @NonNull Throwable t) {
                activityDetailBinding.progressMovie.setVisibility(View.GONE);
                Log.d("Error", t.getMessage());
            }
        });
    }

    private void prepareView() {
        adapter = new TrailerAdapter(trailers, getApplicationContext());
        activityDetailBinding.rvTrailer.setAdapter(adapter);
        activityDetailBinding.progressMovie.setVisibility(View.GONE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("trailers", new ArrayList<>(adapter.getTrailers()));
    }
}
