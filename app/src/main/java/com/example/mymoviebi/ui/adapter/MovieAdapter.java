package com.example.mymoviebi.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymoviebi.Links;
import com.example.mymoviebi.R;
import com.example.mymoviebi.databinding.ItemListMovieBinding;
import com.example.mymoviebi.modul.MovieResponse;
import com.example.mymoviebi.ui.activity.DetailMovieActivity;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<MovieResponse.ResultsBean> movies;
    private Context context;


    public MovieAdapter(List<MovieResponse.ResultsBean> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    public List<MovieResponse.ResultsBean> getMovies() {
        return movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_movie, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        final MovieResponse.ResultsBean movie = movies.get(position);
        holder.itemListMovieBinding.movieTitle.setText(movie.getTitle());
        holder.itemListMovieBinding.movieGenre.setText(movie.getOriginalTitle());
        holder.itemListMovieBinding.movieRate.setText(String.valueOf(movie.getVoteAverage()));
        holder.itemListMovieBinding.releaseDate.setText(movie.getReleaseDate());
        holder.itemListMovieBinding.movieOverview.setText(movie.getOverview());
        Glide.with(context).asBitmap().load(Links.IMAGE_BASE_URL + movie.getPosterPath())
                .into(holder.itemListMovieBinding.moviePhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_ITEM, movie);
                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ItemListMovieBinding itemListMovieBinding;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            itemListMovieBinding = DataBindingUtil.bind(itemView);
        }
    }
}
