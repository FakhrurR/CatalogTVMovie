package com.example.mymoviebi.ui.fragment.search;


import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mymoviebi.BuildConfig;
import com.example.mymoviebi.R;
import com.example.mymoviebi.databinding.FragmentMovieBinding;
import com.example.mymoviebi.modul.MovieResponse;
import com.example.mymoviebi.rest.MovieService;
import com.example.mymoviebi.ui.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchMovieFragment extends Fragment {


    private FragmentMovieBinding fragmentMovieBinding;
    private String querys;
    private String queryChange = null;
    private List<MovieResponse.ResultsBean> movies = new ArrayList<>();
    private MovieAdapter movieAdapter;

    public SearchMovieFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMovieBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);

        fragmentMovieBinding.searchView.setVisibility(View.VISIBLE);
        fragmentMovieBinding.progressMovie.setVisibility(View.GONE);

        fragmentMovieBinding.swipeMovie.setEnabled(false);

        initRecycleView();
        if (savedInstanceState != null) {
            List<MovieResponse.ResultsBean> movies = savedInstanceState.getParcelableArrayList("movies");
            displayMovies(movies);
        } else {
            fragmentMovieBinding.textSearch.setVisibility(View.VISIBLE);
        }

        fragmentMovieBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                queryChange = query;
                getMovieResult();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return fragmentMovieBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("movies", new ArrayList<Parcelable>(movieAdapter.getMovies()));
    }

    private void getMovieResult() {

        fragmentMovieBinding.progressMovie.setVisibility(View.VISIBLE);
        fragmentMovieBinding.textSearch.setVisibility(View.GONE);
        if (queryChange == null) {
            MovieService.getAPI().getSearchMovies(BuildConfig.API_KEY, querys).enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            movies = response.body().getResults();
                            movieAdapter = new MovieAdapter(movies, getContext());
                            fragmentMovieBinding.rvMovie.setAdapter(movieAdapter);
                            fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                        }
                    }
                    if (movies.size() == 0) {
                        Toast.makeText(getContext(), R.string.empty_data, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                    Log.d("Error", t.getMessage());
                }
            });
        } else {
            MovieService.getAPI().getSearchMovies(BuildConfig.API_KEY, queryChange).enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            movies = response.body().getResults();
                            movieAdapter = new MovieAdapter(movies, getContext());
                            fragmentMovieBinding.rvMovie.setAdapter(movieAdapter);
                            fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                        }
                    }
                    if (movies.size() == 0) {
                        Toast.makeText(getContext(), R.string.empty_data, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                    Log.d("Error", t.getMessage());
                }
            });
        }
    }

    private void initRecycleView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        fragmentMovieBinding.rvMovie.setLayoutManager(layoutManager);
        movieAdapter = new MovieAdapter(movies, getContext());
        fragmentMovieBinding.rvMovie.setAdapter(movieAdapter);
    }

    private void displayMovies(List<MovieResponse.ResultsBean> allMovieList) {
        fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
        movies.clear();
        movies.addAll(allMovieList);
        movieAdapter.notifyDataSetChanged();
    }
}
