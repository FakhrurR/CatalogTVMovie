package com.example.mymoviebi.ui.fragment.tvshow;


import com.example.mymoviebi.BuildConfig;
import com.example.mymoviebi.rest.MovieService;
import com.example.mymoviebi.ui.fragment.base.BaseTVShowFragment;

public class AiringToday extends BaseTVShowFragment {

    public AiringToday() {
    }

    @Override
    protected void getTVShows() {
        displayTVShowFromRemote(MovieService.getAPI().getTVAiringToday(BuildConfig.API_KEY));
    }

}
