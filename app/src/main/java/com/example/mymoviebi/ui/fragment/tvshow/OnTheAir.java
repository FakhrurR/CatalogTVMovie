package com.example.mymoviebi.ui.fragment.tvshow;


import androidx.fragment.app.Fragment;

import com.example.mymoviebi.BuildConfig;
import com.example.mymoviebi.rest.MovieService;
import com.example.mymoviebi.ui.fragment.base.BaseTVShowFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class OnTheAir extends BaseTVShowFragment {


    public OnTheAir() {
        // Required empty public constructor
    }

    @Override
    protected void getTVShows() {
        displayTVShowFromRemote(MovieService.getAPI().getTVOnTheAir(BuildConfig.API_KEY));
    }

}

