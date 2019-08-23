package com.example.listfavorite;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static com.example.listfavorite.EntityMovie.TABLE_NAME;

@Entity(tableName = TABLE_NAME)
public class EntityMovie implements Parcelable {

    public static final String TABLE_NAME = "movie";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_VOTE_AVERAGE = "vote_average";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_POPULARITY = "popularity";
    public static final String COLUMN_POSTER_PATH = "poster_path";
    public static final String COLUMN_ORIGINAL_LANGUAGE = "original_language";
    public static final String COLUMN_ORIGINAL_TITLE = "original_title";
    public static final String COLUMN_BACKDROP_PATH = "backdrop_path";
    public static final String COLUMN_OVERVIEW = "overview";
    public static final String COLUMN_RELEASE_DATE = "release_date";
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
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    private int id;
    @ColumnInfo(name = COLUMN_VOTE_AVERAGE)
    private double voteAverage;
    @ColumnInfo(name = COLUMN_TITLE)
    private String title;
    @ColumnInfo(name = COLUMN_POPULARITY)
    private double popularity;
    @ColumnInfo(name = COLUMN_POSTER_PATH)
    private String posterPath;
    @ColumnInfo(name = COLUMN_ORIGINAL_LANGUAGE)
    private String originalLanguage;
    @ColumnInfo(name = COLUMN_ORIGINAL_TITLE)
    private String originalTitle;
    @ColumnInfo(name = COLUMN_BACKDROP_PATH)
    private String backdropPath;
    @ColumnInfo(name = COLUMN_OVERVIEW)
    private String overview;
    @ColumnInfo(name = COLUMN_RELEASE_DATE)
    private String releaseDate;

    public EntityMovie() {

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
    }

    public static EntityMovie fromContentValues(ContentValues values) {
        final EntityMovie entityMovie = new EntityMovie();

        if (values.containsKey(COLUMN_ID)) {
            entityMovie.id = values.getAsInteger(COLUMN_ID);
        } else if (values.containsKey(COLUMN_VOTE_AVERAGE)) {
            entityMovie.voteAverage = values.getAsDouble(COLUMN_VOTE_AVERAGE);
        } else if (values.containsKey(COLUMN_TITLE)) {
            entityMovie.title = values.getAsString(COLUMN_TITLE);
        } else if (values.containsKey(COLUMN_POPULARITY)) {
            entityMovie.popularity = values.getAsDouble(COLUMN_POPULARITY);
        } else if (values.containsKey(COLUMN_POSTER_PATH)) {
            entityMovie.posterPath = values.getAsString(COLUMN_POSTER_PATH);
        } else if (values.containsKey(COLUMN_ORIGINAL_LANGUAGE)) {
            entityMovie.originalLanguage = values.getAsString(COLUMN_ORIGINAL_LANGUAGE);
        } else if (values.containsKey(COLUMN_ORIGINAL_TITLE)) {
            entityMovie.originalTitle = values.getAsString(COLUMN_ORIGINAL_TITLE);
        } else if (values.containsKey(COLUMN_BACKDROP_PATH)) {
            entityMovie.backdropPath = values.getAsString(COLUMN_BACKDROP_PATH);
        } else if (values.containsKey(COLUMN_OVERVIEW)) {
            entityMovie.overview = values.getAsString(COLUMN_OVERVIEW);
        } else if (values.containsKey(COLUMN_RELEASE_DATE)) {
            entityMovie.releaseDate = values.getAsString(COLUMN_RELEASE_DATE);
        }
        return entityMovie;
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
    }
}