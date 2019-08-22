package com.example.mymoviebi.rest;

import com.example.mymoviebi.modul.MovieResponse;
import com.example.mymoviebi.modul.TVShowResponse;
import com.example.mymoviebi.modul.TrailerResponse;

import java.text.DateFormat;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("movie/upcoming")
    Call<MovieResponse> getUpcomingMovie(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<MovieResponse> getNowPlayingMovie(@Query("api_key") String apiKey);

    @GET("tv/on_the_air")
    Call<TVShowResponse> getTVOnTheAir(@Query("api_key") String apiKey);

    @GET("tv/airing_today")
    Call<TVShowResponse> getTVAiringToday(@Query("api_key") String apiKey);

    @GET("movie/{movie_id}/videos")
    Call<TrailerResponse> getTrailersByMovieId(
            @Path("movie_id") int movieId,
            @Query("api_key") String apiKey

    );

    @GET("tv/{tv_id}/videos")
    Call<TrailerResponse> getTrailersByTVShowId(
            @Path("tv_id") int tvId,
            @Query("api_key") String apiKey

    );

    @GET("search/movie")
    Call<MovieResponse> getSearchMovies(
            @Query("api_key") String apiKey,
            @Query("query") String querySearch
    );

    @GET("search/tv")
    Call<TVShowResponse> getSearchTVShow(
            @Query("api_key") String apiKey,
            @Query("query") String querySearch
    );

//     https://api.themoviedb.org/3/discover/movie?
//     api_key={API KEY}&primary_release_date.gte={TODAY DATE}
//     &primary_release_date.lte={TODAY DATE}

    @GET("discover/movie")
    Call<MovieResponse> getReleaseTodayReminder(
            @Query("api_key") String apiKey,
            @Query("primary_release_date.gte") String datePrimary,
            @Query("primary_release_date.lte") String dateSecond
            );
}
