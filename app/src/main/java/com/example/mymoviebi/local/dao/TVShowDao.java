package com.example.mymoviebi.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mymoviebi.modul.TVShowResponse;

import java.util.List;

@Dao
public interface TVShowDao {
    @Insert
    void insertTVShow(TVShowResponse.ResultsBean tvShow);

    @Query("SELECT * FROM tvShows")
    List<TVShowResponse.ResultsBean> getAllTVShow();

    @Query("SELECT COUNT(*) FROM tvShows WHERE id = :id")
    int countTVShowById(int id);

    @Query("DELETE FROM tvShows WHERE id = :id")
    void deleteTVShow(int id);
}
