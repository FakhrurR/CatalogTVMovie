package com.example.listfavorite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.listfavorite.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static String MOVIE_ID = "id";

    private Uri uri;

    private ActivityDetailBinding activityDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail);

    }


    private void displayMovie(EntityMovie movie){
        Glide.with(this).asBitmap()
                .load(Links.BACKDROP_BASE_URL + movie.getBackdropPath()).into(activityDetailBinding.imageMovieBackground);
        Glide.with(this).asBitmap()
                .load(Links.POSTER_BASE_URL + movie.getPosterPath()).into(activityDetailBinding.imageMovie);
        activityDetailBinding.toolbar.setTitle(movie.getTitle());
        activityDetailBinding.originalTitle.setText(movie.getOriginalTitle());
        activityDetailBinding.popularity.setText(String.valueOf(movie.getPopularity()));
        activityDetailBinding.rateMovie.setText(String.valueOf(movie.getVoteAverage()));
        activityDetailBinding.releaseDate.setText(movie.getReleaseDate());
        activityDetailBinding.originalLanguage.setText(movie.getOriginalLanguage());
        activityDetailBinding.movieOverview.setText(movie.getOverview());
    }

}
