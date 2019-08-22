package com.example.mymoviebi.ui.fragment.movie;


import com.example.mymoviebi.BuildConfig;
import com.example.mymoviebi.rest.MovieService;
import com.example.mymoviebi.ui.fragment.base.BaseMovieFragment;


public class Upcoming extends BaseMovieFragment {

    public Upcoming() {
    }

    @Override
    protected void getMovies() {
        displayMovieFromRemote(MovieService.getAPI().getUpcomingMovie(BuildConfig.API_KEY));
    }
}
