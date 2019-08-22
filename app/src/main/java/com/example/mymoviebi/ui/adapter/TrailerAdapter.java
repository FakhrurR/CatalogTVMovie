package com.example.mymoviebi.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymoviebi.Links;
import com.example.mymoviebi.R;
import com.example.mymoviebi.databinding.ItemListTrailerBinding;
import com.example.mymoviebi.modul.TrailerResponse;

import java.util.List;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {
    private List<TrailerResponse.ResultsBean> resultsBeans;
    private Context context;

    public TrailerAdapter(List<TrailerResponse.ResultsBean> resultsBeans, Context context) {
        this.resultsBeans = resultsBeans;
        this.context = context;
    }

    public List<TrailerResponse.ResultsBean> getTrailers() {
        return resultsBeans;
    }

    @NonNull
    @Override
    public TrailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_trailer, parent, false);
        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerViewHolder holder, int position) {
        final TrailerResponse.ResultsBean trailer = resultsBeans.get(position);

        Glide.with(context).load(Links.TRAILER_URL + trailer.getKey() + "/0.jpg").into(holder.itemListTrailerBinding.vidMovie);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(Links.YOUTUBE_URL + trailer.getKey()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    class TrailerViewHolder extends RecyclerView.ViewHolder {
        ItemListTrailerBinding itemListTrailerBinding;

        TrailerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemListTrailerBinding = DataBindingUtil.bind(itemView);
        }
    }
}
