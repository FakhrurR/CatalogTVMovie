package com.example.mymoviebi.local.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mymoviebi.local.db.MovieDatabase;
import com.example.mymoviebi.modul.MovieResponse;

import java.util.Objects;

public class FavoriteProvider extends ContentProvider {

    public static final String AUTHORITY = "com.example.mymoviebi";

    public static final Uri URI_MOVIE = Uri.parse(
            "content://" + AUTHORITY + "/" + MovieResponse.ResultsBean.TABLE_NAME);

    private static final int CODE_MOVIE_DIR = 1;

    private static final int CODE_MOVIE_ITEM = 2;

    private static final UriMatcher MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        MATCHER.addURI(AUTHORITY, MovieResponse.ResultsBean.TABLE_NAME, CODE_MOVIE_DIR);
        MATCHER.addURI(AUTHORITY, MovieResponse.ResultsBean.TABLE_NAME + "/*", CODE_MOVIE_DIR);
    }

    private MovieDatabase movieDatabase;

    @Override
    public boolean onCreate() {
        movieDatabase = MovieDatabase.getDatabase(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final int code = MATCHER.match(uri);
        if (code == CODE_MOVIE_DIR || code == CODE_MOVIE_ITEM) {
            final Context context = getContext();

            if (context == null) {
                return null;
            }

            movieDatabase = (MovieDatabase) MovieDatabase.getDatabase(context).movieDao();
            Cursor cursor = null;

            if (code == CODE_MOVIE_DIR) {
                cursor = movieDatabase.movieDao().getAll();
            }
            Objects.requireNonNull(cursor).setNotificationUri(context.getContentResolver(), uri);
            return cursor;
        } else {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (MATCHER.match(uri)) {
            case CODE_MOVIE_DIR:
                return "vnd.android.cursor.dir/" + AUTHORITY + "." + MovieResponse.ResultsBean.TABLE_NAME;
            case CODE_MOVIE_ITEM:
                return "vnd.android.cursor.item/" + AUTHORITY + "." + MovieResponse.ResultsBean.TABLE_NAME;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {

        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        switch (MATCHER.match(uri)) {
            case CODE_MOVIE_DIR:
                throw new IllegalArgumentException("Invalid URI, cannot update without ID" + uri);
            case CODE_MOVIE_ITEM:
                final Context context = getContext();
                if (context == null) {
                    return 0;
                }
                final int count = MovieDatabase.getDatabase(context).movieDao()
                        .deleteMovieById(ContentUris.parseId(uri));
                context.getContentResolver().notifyChange(uri, null);
                return count;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
