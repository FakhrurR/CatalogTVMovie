package com.example.mymoviebi.ui.fragment.favorite;

import android.util.Log;

import com.example.mymoviebi.local.dao.TVShowDao;
import com.example.mymoviebi.local.db.MovieDatabase;
import com.example.mymoviebi.modul.TVShowResponse;
import com.example.mymoviebi.ui.fragment.base.BaseTVShowFragment;

import java.util.List;

public class FavoriteTVShow extends BaseTVShowFragment {


    @Override
    public void onResume() {
        super.onResume();
        getTVShows();
    }

    @Override
    protected void getTVShows() {
        getAllTVShow();
    }

    private void getAllTVShow() {
        MovieDatabase movieDatabase = MovieDatabase.getDatabase(getActivity());
        TVShowDao tvShowDao = movieDatabase.tvShowDao();

        try {
            List<TVShowResponse.ResultsBean> tvShows = tvShowDao.getAllTVShow();
            displayTVShows(tvShows);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Error gan : ", e.getMessage());
        }
    }
}
