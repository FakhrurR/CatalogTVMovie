package com.example.mymoviebi.ui.fragment.movie;


import com.example.mymoviebi.BuildConfig;
import com.example.mymoviebi.rest.MovieService;
import com.example.mymoviebi.ui.fragment.base.BaseMovieFragment;

public class NowPlaying extends BaseMovieFragment {

    public NowPlaying() {
    }

    @Override
    protected void getMovies() {
        displayMovieFromRemote(MovieService.getAPI().getNowPlayingMovie(BuildConfig.API_KEY));
    }

}

