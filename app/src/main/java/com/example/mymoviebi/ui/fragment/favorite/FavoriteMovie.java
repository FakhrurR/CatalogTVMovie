package com.example.mymoviebi.ui.fragment.favorite;

import android.util.Log;

import com.example.mymoviebi.local.dao.MovieDao;
import com.example.mymoviebi.local.db.MovieDatabase;
import com.example.mymoviebi.modul.MovieResponse;
import com.example.mymoviebi.ui.fragment.base.BaseMovieFragment;

import java.util.List;

public class FavoriteMovie extends BaseMovieFragment {

    public FavoriteMovie() {
    }

    @Override
    public void onResume() {
        super.onResume();
        getMovies();
    }

    @Override
    protected void getMovies() {
        getAllMovies();
    }


    private void getAllMovies() {
        MovieDatabase movieDatabase = MovieDatabase.getDatabase(getActivity());
        MovieDao movieDao = movieDatabase.movieDao();

        try {
            List<MovieResponse.ResultsBean> movies = movieDao.getAllMovies();
            displayMovies(movies);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Error gan : ", e.getMessage());
        }


    }
}
