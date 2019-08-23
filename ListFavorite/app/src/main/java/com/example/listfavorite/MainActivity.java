package com.example.listfavorite;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.listfavorite.adapter.FavoriteAdapter;
import com.example.listfavorite.databinding.ActivityMainBinding;

import static com.example.listfavorite.EntityMovie.TABLE_NAME;


public class MainActivity extends AppCompatActivity {

    public static final String AUTHORITY = "com.example.mymoviebi";

    public static final Uri CONTENT_URI = Uri.parse(
            "content://" + AUTHORITY + "/" + TABLE_NAME);

    private static final int LOADER_MOVIE = 1;

    private FavoriteAdapter favoriteAdapter;
    private Cursor cursor;
    private LoaderManager.LoaderCallbacks<Cursor> mLoaderCallbacks =
            new LoaderManager.LoaderCallbacks<Cursor>() {
                @NonNull
                @Override
                public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
                    if (id == LOADER_MOVIE) {
                        return new CursorLoader(
                                getApplicationContext(),
                                CONTENT_URI,
                                null,
                                null,
                                null,
                                null);
                    }
                    throw new IllegalArgumentException();
                }

                @Override
                public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
                    if (loader.getId() == LOADER_MOVIE) {
                        favoriteAdapter.setListFavourite(data);
                    }
                }

                @Override
                public void onLoaderReset(@NonNull Loader<Cursor> loader) {
                    if (loader.getId() == LOADER_MOVIE) {
                        favoriteAdapter.setListFavourite(null);
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        list.setLayoutManager(new GridLayoutManager(list.getContext(),2));
        activityMainBinding.recyclerViewMovie.setLayoutManager(linearLayoutManager);
        favoriteAdapter = new FavoriteAdapter(cursor, getApplicationContext());
        activityMainBinding.recyclerViewMovie.setAdapter(favoriteAdapter);

        getSupportLoaderManager().initLoader(LOADER_MOVIE, null, mLoaderCallbacks);
    }

}
