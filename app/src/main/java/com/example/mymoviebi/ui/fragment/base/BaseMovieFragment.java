package com.example.mymoviebi.ui.fragment.base;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mymoviebi.R;
import com.example.mymoviebi.databinding.FragmentMovieBinding;
import com.example.mymoviebi.modul.MovieResponse;
import com.example.mymoviebi.ui.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseMovieFragment extends Fragment {

    private static final String KEY_MOVIES = "movies";
    protected List<MovieResponse.ResultsBean> movies = new ArrayList<>();
    private FragmentMovieBinding fragmentMovieBinding;
    private MovieAdapter movieAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentMovieBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);

        initRecycleViews();

        fragmentMovieBinding.swipeMovie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentMovieBinding.swipeMovie.setRefreshing(false);
                        getMovies();
                    }
                }, 3000);
            }
        });


        return fragmentMovieBinding.getRoot();
    }

    private void initRecycleViews() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        fragmentMovieBinding.rvMovie.setLayoutManager(layoutManager);
        movieAdapter = new MovieAdapter(movies, getContext());
        fragmentMovieBinding.rvMovie.setAdapter(movieAdapter);
    }

    protected abstract void getMovies();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            List<MovieResponse.ResultsBean> movies = savedInstanceState.getParcelableArrayList(KEY_MOVIES);
            displayMovies(movies);
        } else {
            getMovies();
        }
    }


    protected void displayMovieFromRemote(Call<MovieResponse> call) {
        fragmentMovieBinding.progressMovie.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<MovieResponse.ResultsBean> allMovieList = response.body().getResults();
                        displayMovies(allMovieList);
                    }
                    fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call, Throwable t) {
                fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                Log.d("Error Gan :", t.getMessage());
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_MOVIES, new ArrayList<>(movieAdapter.getMovies()));
    }


    protected void displayMovies(List<MovieResponse.ResultsBean> allMovieList) {
        fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
        movies.clear();
        movies.addAll(allMovieList);
        movieAdapter.notifyDataSetChanged();
        if (allMovieList.isEmpty()) {
            fragmentMovieBinding.emptyData.setVisibility(View.VISIBLE);
        }
    }


}
