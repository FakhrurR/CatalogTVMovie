package com.example.listfavorite.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listfavorite.R;
import com.example.listfavorite.databinding.ItemListMovieBinding;

import static com.example.listfavorite.EntityMovie.COLUMN_ORIGINAL_TITLE;
import static com.example.listfavorite.EntityMovie.COLUMN_OVERVIEW;
import static com.example.listfavorite.EntityMovie.COLUMN_POSTER_PATH;
import static com.example.listfavorite.EntityMovie.COLUMN_RELEASE_DATE;
import static com.example.listfavorite.EntityMovie.COLUMN_TITLE;
import static com.example.listfavorite.EntityMovie.COLUMN_VOTE_AVERAGE;


public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

    private static final String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342/";
    private Cursor listFavourite;
    private Context context;

    public FavoriteAdapter(Cursor listFavourite, Context context) {
        setListFavourite(listFavourite);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_movie, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (listFavourite.moveToPosition(position)) {
            holder.itemListMovieBinding.movieTitle.setText(listFavourite
                    .getString(listFavourite.getColumnIndexOrThrow(COLUMN_TITLE)));

            Glide.with(context).asBitmap().load(POSTER_BASE_URL + listFavourite.getString(
                    listFavourite.getColumnIndexOrThrow(COLUMN_POSTER_PATH)))
                    .into(holder.itemListMovieBinding.moviePhoto);

            holder.itemListMovieBinding.movieGenre.setText(listFavourite.getString(
                    listFavourite.getColumnIndexOrThrow(COLUMN_ORIGINAL_TITLE)));

            holder.itemListMovieBinding.movieRate.setText(listFavourite.getString(
                    listFavourite.getColumnIndexOrThrow(COLUMN_VOTE_AVERAGE)
            ));

            holder.itemListMovieBinding.releaseDate.setText(listFavourite.getString(
                    listFavourite.getColumnIndexOrThrow(COLUMN_RELEASE_DATE)));

            holder.itemListMovieBinding.movieOverview.setText(listFavourite.getString(
                    listFavourite.getColumnIndexOrThrow(COLUMN_OVERVIEW)));

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailActivity.class);
//
//                Uri uri = Uri.parse(CONTENT_URI + "/" + movie.getId());
//                intent.putExtra(DetailActivity.MOVIE_ID, movie.getId());
//                intent.setData(uri);
//                context.startActivity(intent);
//            }
//        });
        }
    }

    public void setListFavourite(Cursor items) {
        listFavourite = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listFavourite == null ? 0 : listFavourite.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListMovieBinding itemListMovieBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemListMovieBinding = DataBindingUtil.bind(itemView);
        }
    }
}
