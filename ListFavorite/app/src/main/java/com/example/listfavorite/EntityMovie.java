package com.example.listfavorite;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.example.listfavorite.DatabaseContract.BACKDROP_URL;
import static com.example.listfavorite.DatabaseContract.GETFAVORITE;
import static com.example.listfavorite.DatabaseContract.MOVIE_ID;
import static com.example.listfavorite.DatabaseContract.ORIGINAL_LANGUAGE;
import static com.example.listfavorite.DatabaseContract.ORIGINAL_TITLE;
import static com.example.listfavorite.DatabaseContract.OVERVIEW;
import static com.example.listfavorite.DatabaseContract.POPULARITY;
import static com.example.listfavorite.DatabaseContract.POSTER_URL;
import static com.example.listfavorite.DatabaseContract.RELEASE_DATE;
import static com.example.listfavorite.DatabaseContract.TITLE;
import static com.example.listfavorite.DatabaseContract.VOTE_AVERAGE;
import static com.example.listfavorite.DatabaseContract.getColumnDouble;
import static com.example.listfavorite.DatabaseContract.getColumnInt;
import static com.example.listfavorite.DatabaseContract.getColumnString;

@Entity(tableName = EntityMovie.TABLE_NAME)
public class EntityMovie implements Parcelable{

    public static final String TABLE_NAME = "movie";

    @PrimaryKey
    @ColumnInfo(name = MOVIE_ID)
    private int id;
    @ColumnInfo(name = VOTE_AVERAGE)
    private double voteAverage;
    @ColumnInfo(name = TITLE)
    private String title;
    @ColumnInfo(name = POPULARITY)
    private double popularity;
    @ColumnInfo(name = POSTER_URL)
    private String posterPath;
    @ColumnInfo(name = ORIGINAL_LANGUAGE)
    private String originalLanguage;
    @ColumnInfo(name = ORIGINAL_TITLE)
    private String originalTitle;
    @ColumnInfo(name = BACKDROP_URL)
    private String backdropPath;
    @ColumnInfo(name = OVERVIEW)
    private String overview;
    @ColumnInfo(name = RELEASE_DATE)
    private String releaseDate;
    @ColumnInfo(name = GETFAVORITE)
    private boolean isFavorite;

    public EntityMovie() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public EntityMovie(Cursor listFavourite) {
        this.id = getColumnInt(listFavourite, MOVIE_ID);
        this.title = getColumnString(listFavourite,TITLE);
        this.releaseDate = getColumnString(listFavourite,RELEASE_DATE);
        this.originalTitle = getColumnString(listFavourite, ORIGINAL_TITLE);
        this.voteAverage = getColumnDouble(listFavourite,VOTE_AVERAGE);
        this.overview = getColumnString(listFavourite,OVERVIEW);
        this.popularity = getColumnDouble(listFavourite, POPULARITY);
        this.originalLanguage = getColumnString(listFavourite,ORIGINAL_LANGUAGE);
        this.posterPath = getColumnString(listFavourite,POSTER_URL);
    }


    protected EntityMovie(Parcel in) {
        id = in.readInt();
        voteAverage = in.readDouble();
        title = in.readString();
        popularity = in.readDouble();
        posterPath = in.readString();
        originalLanguage = in.readString();
        originalTitle = in.readString();
        backdropPath = in.readString();
        overview = in.readString();
        releaseDate = in.readString();
        isFavorite = in.readByte() != 0;
    }

    public static final Creator<EntityMovie> CREATOR = new Creator<EntityMovie>() {
        @Override
        public EntityMovie createFromParcel(Parcel in) {
            return new EntityMovie(in);
        }

        @Override
        public EntityMovie[] newArray(int size) {
            return new EntityMovie[size];
        }
    };

    public static EntityMovie fromContentValues(ContentValues values){
        final EntityMovie entityMovie = new EntityMovie();

        if(values.containsKey(MOVIE_ID)){
            entityMovie.id = values.getAsInteger(MOVIE_ID);
        }
        else if (values.containsKey(VOTE_AVERAGE)){
            entityMovie.voteAverage = values.getAsDouble(VOTE_AVERAGE);
        }
        else if (values.containsKey(TITLE)){
            entityMovie.title = values.getAsString(TITLE);
        }
        else if (values.containsKey(POPULARITY)){
            entityMovie.popularity = values.getAsDouble(POPULARITY);
        }
        else if (values.containsKey(POSTER_URL)){
            entityMovie.posterPath = values.getAsString(POSTER_URL);
        }
        else if (values.containsKey(ORIGINAL_LANGUAGE)){
            entityMovie.originalLanguage = values.getAsString(ORIGINAL_LANGUAGE);
        }
        else if (values.containsKey(ORIGINAL_TITLE)){
            entityMovie.originalLanguage = values.getAsString(ORIGINAL_TITLE);
        }
        else if (values.containsKey(BACKDROP_URL)){
            entityMovie.overview = values.getAsString(OVERVIEW);
        }
        else if (values.containsKey(RELEASE_DATE)){
            entityMovie.releaseDate = values.getAsString(RELEASE_DATE);
        }
        else if (values.containsKey(GETFAVORITE)){
            entityMovie.isFavorite = values.getAsBoolean(GETFAVORITE);
        }
        return entityMovie;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeDouble(voteAverage);
        dest.writeString(title);
        dest.writeDouble(popularity);
        dest.writeString(posterPath);
        dest.writeString(originalLanguage);
        dest.writeString(originalTitle);
        dest.writeString(backdropPath);
        dest.writeString(overview);
        dest.writeString(releaseDate);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
    }
}