package com.example.mymoviebi.local.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mymoviebi.local.dao.MovieDao;
import com.example.mymoviebi.local.db.MovieDatabase;
import com.example.mymoviebi.modul.MovieResponse;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Callable;

public class FavoriteProvider extends ContentProvider {

    public static final String AUTHORITY = "com.example.mymoviebi";

    public static final Uri CONTENT_URI = Uri.parse(
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

            MovieDao movies = MovieDatabase.getDatabase(context).movieDao();
            final Cursor cursor;

            if (code == CODE_MOVIE_DIR) {
                cursor = movies.getAll();
            } else {
                cursor = movies.selectById(ContentUris.parseId(uri));
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
        switch (MATCHER.match(uri)) {
            case CODE_MOVIE_DIR:
                final Context context = getContext();
                if (context == null) {
                    return null;
                }
                final long id = MovieDatabase.getDatabase(context).movieDao()
                        .insertId(MovieResponse.ResultsBean.fromContentValues(Objects.requireNonNull(values)));
                context.getContentResolver().notifyChange(uri, null);
                return ContentUris.withAppendedId(uri, id);
            case CODE_MOVIE_ITEM:
                throw new IllegalArgumentException("Invalid URI, cannot insert with ID: " + uri);
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
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
        switch (MATCHER.match(uri)) {
            case CODE_MOVIE_DIR:
                throw new IllegalArgumentException("Invalid URI, cannot update without ID" + uri);
            case CODE_MOVIE_ITEM:
                final Context context = getContext();
                if (context == null) {
                    return 0;
                }
                final MovieResponse.ResultsBean movies = MovieResponse.ResultsBean.fromContentValues(values);
                movies.id = (int) ContentUris.parseId(uri);
                final int count = MovieDatabase.getDatabase(context).movieDao()
                        .updateMovie(movies);
                context.getContentResolver().notifyChange(uri, null);
                return count;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    @SuppressWarnings("RedundantThrows")
    @NonNull
    @Override
    public ContentProviderResult[] applyBatch(
            @NonNull final ArrayList<ContentProviderOperation> operations)
            throws OperationApplicationException {
        final Context context = getContext();
        if (context == null) {
            return new ContentProviderResult[0];
        }
        final MovieDatabase database = MovieDatabase.getDatabase(context);
        return database.runInTransaction(new Callable<ContentProviderResult[]>() {
            @Override
            public ContentProviderResult[] call() throws OperationApplicationException {
                return FavoriteProvider.super.applyBatch(operations);
            }
        });
    }
}
