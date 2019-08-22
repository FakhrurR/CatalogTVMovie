package com.example.mymoviebi.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mymoviebi.local.dao.MovieDao;
import com.example.mymoviebi.local.dao.TVShowDao;
import com.example.mymoviebi.modul.MovieResponse;
import com.example.mymoviebi.modul.TVShowResponse;

@Database(entities = {MovieResponse.ResultsBean.class, TVShowResponse.ResultsBean.class}, version = 1, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    private static volatile MovieDatabase instance;

    public static MovieDatabase getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MovieDatabase.class, "tmdb_movie")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

    public abstract MovieDao movieDao();

    public abstract TVShowDao tvShowDao();

}