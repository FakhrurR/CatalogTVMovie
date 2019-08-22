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
import com.example.mymoviebi.modul.TVShowResponse;
import com.example.mymoviebi.ui.activity.DetailTVShowActivity;

import java.util.List;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder> {
    private List<TVShowResponse.ResultsBean> resultsBeans;
    private Context context;

    public TVShowAdapter(List<TVShowResponse.ResultsBean> resultsBeans, Context context) {
        this.resultsBeans = resultsBeans;
        this.context = context;
    }

    public List<TVShowResponse.ResultsBean> getTVShow() {
        return resultsBeans;
    }

    @NonNull
    @Override
    public TVShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_movie, parent, false);
        return new TVShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowViewHolder holder, int position) {
        final TVShowResponse.ResultsBean resultsBean = resultsBeans.get(position);
        holder.itemListMovieBinding.movieTitle.setText(resultsBean.getName());
        holder.itemListMovieBinding.movieGenre.setText(resultsBean.getOriginalName());
        holder.itemListMovieBinding.movieRate.setText(String.valueOf(resultsBean.getVoteAverage()));
        holder.itemListMovieBinding.releaseDate.setText(resultsBean.getFirstAirDate());
        holder.itemListMovieBinding.movieOverview.setText(resultsBean.getOverview());
        Glide.with(context).asBitmap().load(Links.IMAGE_BASE_URL + resultsBean.getPosterPath()).into(holder.itemListMovieBinding.moviePhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailTVShowActivity.class);
                intent.putExtra("tvShow_intent", resultsBean);
                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    public class TVShowViewHolder extends RecyclerView.ViewHolder {
        ItemListMovieBinding itemListMovieBinding;

        public TVShowViewHolder(@NonNull View itemView) {
            super(itemView);
            itemListMovieBinding = DataBindingUtil.bind(itemView);
        }
    }
}
