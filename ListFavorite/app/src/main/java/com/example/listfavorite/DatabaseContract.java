package com.example.listfavorite;

import android.database.Cursor;
import android.net.Uri;

public class DatabaseContract {

    public static final String AUTHORITY = "com.example.mymoviebi";

    public static final String SCHEME = "content";

    public static final String MOVIE_ID = "id";

    public static final String TITLE = "title";

    public static final String RELEASE_DATE = "release_date";

    public static final String VOTE_AVERAGE = "vote_average";

    public static final String OVERVIEW = "overview";

    public static final String ORIGINAL_LANGUAGE = "original_language";

    public static final String ORIGINAL_TITLE = "original_title";

    public static final String POSTER_URL = "poster_url";

    public static final String BACKDROP_URL = "backdrop_url";

    public static final String POPULARITY = "popularity";

    public static final String GETFAVORITE = "getFavorite";

    public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
            .authority(AUTHORITY)
            .appendPath(EntityMovie.TABLE_NAME)
            .build();

    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndex(columnName));
    }

    public static int getColumnInt(Cursor cursor, String columnName) {
        return cursor.getInt(cursor.getColumnIndex(columnName));
    }

    public static long getColumnLong(Cursor cursor, String columnName) {
        return cursor.getLong(cursor.getColumnIndex(columnName));
    }

    public static double getColumnDouble(Cursor cursor, String columnName) {
        return cursor.getDouble(cursor.getColumnIndexOrThrow(columnName));
    }

}
