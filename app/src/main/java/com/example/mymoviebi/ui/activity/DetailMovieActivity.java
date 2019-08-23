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
import com.example.mymoviebi.local.dao.MovieDao;
import com.example.mymoviebi.local.db.MovieDatabase;
import com.example.mymoviebi.modul.MovieResponse;
import com.example.mymoviebi.modul.TrailerResponse;
import com.example.mymoviebi.rest.MovieService;
import com.example.mymoviebi.ui.adapter.TrailerAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM = "movie_intent";
    private ActivityDetailBinding activityDetailBinding;
    private TrailerAdapter adapter;
    private MovieResponse.ResultsBean resultsBean;
    private MovieDatabase movieDatabase;
    private List<TrailerResponse.ResultsBean> trailers = new ArrayList<>();
    private boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resultsBean = getIntent().getParcelableExtra(EXTRA_ITEM);

        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        movieDatabase = MovieDatabase.getDatabase(this);

        initRecyclerView();
        displayDetailMovie(resultsBean);
        isMovieFavorite(resultsBean.getId());

        if (savedInstanceState != null) {
            trailers = savedInstanceState.getParcelableArrayList("trailers");
            prepareView();
        } else {
            displayDetailTrailer(resultsBean.getId());
        }


        activityDetailBinding.toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        setSupportActionBar(activityDetailBinding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        } else if (id == R.id.favorite) {
            if (isFavorite) {
                item.setIcon(R.drawable.ic_favorite_border_black_24dp);
                deleteFromFavorite(resultsBean.getId());
                isFavorite = false;
            } else {
                item.setIcon(R.drawable.ic_favorite_black_24dp);
                addToFavorite(resultsBean);
                isFavorite = true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void addToFavorite(MovieResponse.ResultsBean movie) {
        MovieDao movieDao = movieDatabase.movieDao();
        try {
            movieDao.insertMovie(movie);
            Snackbar snackbar = Snackbar.make(activityDetailBinding.coordinator, "Add to Favorite", Snackbar.LENGTH_SHORT);
            snackbar.show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("addError", e.getMessage());
        }
    }

    private void deleteFromFavorite(int id) {
        MovieDao movieDao = movieDatabase.movieDao();

        try {
            movieDao.deleteMovie(id);
            Snackbar snackbar = Snackbar.make(activityDetailBinding.coordinator, "Delete to Favorite", Snackbar.LENGTH_SHORT);
            snackbar.show();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("deleteError", e.getMessage());
        }
    }

    private void isMovieFavorite(int movieId) {
        MovieDao movieDao = movieDatabase.movieDao();

        try {
            int count = movieDao.countMovieById(movieId);
            isFavorite = count != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void displayDetailMovie(MovieResponse.ResultsBean resultsBean) {

        Glide.with(this).asBitmap()
                .load(Links.BACKGROUND_BASE_URL + resultsBean.getBackdropPath()).into(activityDetailBinding.imageMovieBackground);
        Glide.with(this).asBitmap()
                .load(Links.IMAGE_BASE_URL + resultsBean.getPosterPath()).into(activityDetailBinding.imageMovie);
        activityDetailBinding.toolbar.setTitle(resultsBean.getTitle());
        activityDetailBinding.originalTitle.setText(resultsBean.getOriginalTitle());
        activityDetailBinding.popularity.setText(String.valueOf(resultsBean.getPopularity()));
        activityDetailBinding.rateMovie.setText(String.valueOf(resultsBean.getVoteAverage()));
        activityDetailBinding.releaseDate.setText(resultsBean.getReleaseDate());
        activityDetailBinding.originalLanguage.setText(resultsBean.getOriginalLanguage());
        activityDetailBinding.movieOverview.setText(resultsBean.getOverview());

    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(DetailMovieActivity.this, LinearLayoutManager.HORIZONTAL,
                        false);
        activityDetailBinding.rvTrailer.setLayoutManager(layoutManager);
    }


    private void displayDetailTrailer(int movieId) {
        activityDetailBinding.progressMovie.setVisibility(View.VISIBLE);
        MovieService.getAPI().getTrailersByMovieId(movieId, BuildConfig.API_KEY).enqueue(new Callback<TrailerResponse>() {
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
