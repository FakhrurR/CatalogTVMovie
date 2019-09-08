package com.example.mymoviebi.modul;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    /**
     * results : [{"vote_count":982,"id":429617,"video":false,"vote_average":7.8,"title":"Spider-Man: Far from Home","popularity":462.096,"poster_path":"/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg","original_language":"en","original_title":"Spider-Man: Far from Home","genre_ids":[28,12,878],"backdrop_path":"/dihW2yTsvQlust7mSuAqJDtqW7k.jpg","adult":false,"overview":"Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.","release_date":"2019-06-28"},{"vote_count":212,"id":521029,"video":false,"vote_average":6.2,"title":"Annabelle Comes Home","popularity":102.402,"poster_path":"/qWsHMrbg9DsBY3bCMk9jyYCRVRs.jpg","original_language":"en","original_title":"Annabelle Comes Home","genre_ids":[27],"backdrop_path":"/dBt0DoFfbhOI4ypUfRj1uTq623M.jpg","adult":false,"overview":"Determined to keep Annabelle from wreaking more havoc, demonologists Ed and Lorraine Warren bring the possessed doll to the locked artifacts room in their home, placing her \u201csafely\u201d behind sacred glass and enlisting a priest\u2019s holy blessing. But an unholy night of horror awaits as Annabelle awakens the evil spirits in the room, who all set their sights on a new target\u2014the Warrens' ten-year-old daughter, Judy, and her friends.","release_date":"2019-06-26"},{"vote_count":7,"id":420818,"video":false,"vote_average":4.2,"title":"The Lion King","popularity":94.717,"poster_path":"/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg","original_language":"en","original_title":"The Lion King","genre_ids":[12,16,10751,18],"backdrop_path":"/1TUg5pO1VZ4B0Q1amk3OlXvlpXV.jpg","adult":false,"overview":"Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother\u2014and former heir to the throne\u2014has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.","release_date":"2019-07-12"},{"vote_count":19,"id":566555,"video":false,"vote_average":5.2,"title":"Detective Conan: The Fist of Blue Sapphire","popularity":89.812,"poster_path":"/86Y6qM8zTn3PFVfCm9J98Ph7JEB.jpg","original_language":"ja","original_title":"名探偵コナン 紺青の拳（フィスト）","genre_ids":[16,28,18,9648,35],"backdrop_path":"/wf6VDSi4aFCZfuD8sX8JAKLfJ5m.jpg","adult":false,"overview":"23rd movie in the \"Detective Conan\" franchise.","release_date":"2019-04-12"},{"vote_count":61,"id":480042,"video":false,"vote_average":4.7,"title":"Escape Plan: The Extractors","popularity":72.227,"poster_path":"/r15SUgzjL8bablcdEkHk9T7TSRl.jpg","original_language":"en","original_title":"Escape Plan: The Extractors","genre_ids":[28,53],"backdrop_path":"/ygWKYTu7OnZKF9H5NsgjL9iURGV.jpg","adult":false,"overview":"After security expert Ray Breslin is hired to rescue the kidnapped daughter of a Hong Kong tech mogul from a formidable Latvian prison, Breslin's girlfriend is also captured. Now he and his team must pull off a deadly rescue mission to confront their sadistic foe and save the hostages before time runs out.","release_date":"2019-06-20"},{"vote_count":9,"id":519465,"video":false,"vote_average":7.6,"title":"Queen of Hearts","popularity":55.861,"poster_path":"/dfFVDIgovEfQZn53VRKLV2JQnRJ.jpg","original_language":"da","original_title":"Dronningen","genre_ids":[18],"backdrop_path":"/3xqkD4QaB9qYrOgcc5YdfMvof7Z.jpg","adult":false,"overview":"Anne, a brilliant and dedicated advocacy lawyer specialising in society\u2019s most vulnerable, children and young adults, lives what appears to be the picture-perfect life with her doctor-husband, Peter, and their twin daughters. When her estranged teenage stepson, Gustav, moves in with them, Anne\u2019s escalating desire leads her down a dangerous rabbit hole which, once exposed, unleashes a sequence of events destined to destroy her world.","release_date":"2019-03-27"},{"vote_count":427,"id":479455,"video":false,"vote_average":6,"title":"Men in Black: International","popularity":51.588,"poster_path":"/dPrUPFcgLfNbmDL8V69vcrTyEfb.jpg","original_language":"en","original_title":"Men in Black: International","genre_ids":[28,35,878,12],"backdrop_path":"/2FYzxgLNuNVwncilzUeCGbOQzP7.jpg","adult":false,"overview":"The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization.","release_date":"2019-06-12"},{"vote_count":158,"id":533642,"video":false,"vote_average":5.8,"title":"Child's Play","popularity":50.881,"poster_path":"/rpS7ROczWulqfaXG2klYapULXKm.jpg","original_language":"en","original_title":"Child's Play","genre_ids":[27,878],"backdrop_path":"/vHse4QK31Vc3X7BKKU5GOQhYxv6.jpg","adult":false,"overview":"Karen, a single mother, gifts her son Andy a Buddi doll for his birthday, unaware of its more sinister nature. A contemporary re-imagining of the 1988 horror classic.","release_date":"2019-06-19"},{"vote_count":937,"id":457799,"video":false,"vote_average":7,"title":"Extremely Wicked, Shockingly Evil and Vile","popularity":49.667,"poster_path":"/bP8T3WWpFTvyITSzetR3UCnG45M.jpg","original_language":"en","original_title":"Extremely Wicked, Shockingly Evil and Vile","genre_ids":[53,80,18,36],"backdrop_path":"/2l1QJBrT5nf0O6199piSGBptfZ9.jpg","adult":false,"overview":"A chronicle of the crimes of Ted Bundy, from the perspective of his longtime girlfriend, Elizabeth Kloepfer, who refused to believe the truth about him for years.","release_date":"2019-05-02"},{"vote_count":783,"id":438650,"video":false,"vote_average":5.4,"title":"Cold Pursuit","popularity":46.991,"poster_path":"/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg","original_language":"en","original_title":"Cold Pursuit","genre_ids":[28,18,53,80],"backdrop_path":"/vEf5TcMW0ZwzGz24ZJSRWYXYlpX.jpg","adult":false,"overview":"The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.","release_date":"2019-02-07"},{"vote_count":1590,"id":447404,"video":false,"vote_average":7,"title":"Pokémon Detective Pikachu","popularity":46.694,"poster_path":"/wgQ7APnFpf1TuviKHXeEe3KnsTV.jpg","original_language":"en","original_title":"Pokémon Detective Pikachu","genre_ids":[9648,10751,35,878,28,12],"backdrop_path":"/nDP33LmQwNsnPv29GQazz59HjJI.jpg","adult":false,"overview":"In a world where people collect pocket-size monsters (Pokémon) to do battle, a boy comes across an intelligent monster who seeks to be a detective.","release_date":"2019-05-03"},{"vote_count":132,"id":515195,"video":false,"vote_average":6.8,"title":"Yesterday","popularity":46.306,"poster_path":"/1rjaRIAqFPQNnMtqSMLtg0VEABi.jpg","original_language":"en","original_title":"Yesterday","genre_ids":[35,10402,10749],"backdrop_path":"/t9xAqZc37OgVkojyQwT3UCanZJk.jpg","adult":false,"overview":"Jack Malik is a struggling singer-songwriter in an English seaside town whose dreams of fame are rapidly fading, despite the fierce devotion and support of his childhood best friend, Ellie. After a freak bus accident during a mysterious global blackout, Jack wakes up to discover that he's the only person on Earth who can remember The Beatles.","release_date":"2019-06-27"},{"vote_count":54,"id":530385,"video":false,"vote_average":7,"title":"Midsommar","popularity":42.028,"poster_path":"/eycO6M2s38xO1888Gq2gSrXf0A6.jpg","original_language":"en","original_title":"Midsommar","genre_ids":[27,18,9648,35],"backdrop_path":"/reU8qaO848nkCay7WPtJcdi61p5.jpg","adult":false,"overview":"A young couple travels to Sweden to visit their friend\u2019s rural hometown and attend its mid-summer festival. What begins as an idyllic retreat quickly descends into an increasingly violent and bizarre competition at the hands of a pagan cult.","release_date":"2019-07-03"},{"vote_count":0,"id":511987,"video":false,"vote_average":0,"title":"Crawl","popularity":41.958,"poster_path":"/83Td0K2HAYUXylCyfBU5mTVCA1Y.jpg","original_language":"en","original_title":"Crawl","genre_ids":[53,28,27],"backdrop_path":"/2cAce3oD0Hh7f5XxuXmNXa1WiuZ.jpg","adult":false,"overview":"While struggling to save her father during a Category 5 hurricane, a young woman finds herself trapped inside a flooding house and fighting for her life against Florida\u2019s most savage and feared predators.","release_date":"2019-07-11"},{"vote_count":7,"id":513045,"video":false,"vote_average":7.7,"title":"Stuber","popularity":37.215,"poster_path":"/7RTaeiHvc9oPfvRMQGUra7qLOQh.jpg","original_language":"en","original_title":"Stuber","genre_ids":[28,35],"backdrop_path":"/Ad0O2lK5XHu1iBywSH039l5dGgA.jpg","adult":false,"overview":"After crashing his car, a cop who's recovering from eye surgery recruits an Uber driver to help him catch a heroin dealer. The mismatched pair soon find themselves in for a wild day of stakeouts and shootouts as they encounter the city's seedy side.","release_date":"2019-07-11"},{"vote_count":215,"id":412117,"video":false,"vote_average":6.4,"title":"The Secret Life of Pets 2","popularity":34.935,"poster_path":"/q3mKnSkzp1doIsCye6ap4KIUAbu.jpg","original_language":"en","original_title":"The Secret Life of Pets 2","genre_ids":[12,16,35,10751],"backdrop_path":"/kTQQjh53k2twvLDwLH8c0m4w6HR.jpg","adult":false,"overview":"Max the terrier must cope with some major life changes when his owner gets married and has a baby. When the family takes a trip to the countryside, nervous Max has numerous run-ins with canine-intolerant cows, hostile foxes and a scary turkey. Luckily for Max, he soon catches a break when he meets Rooster, a gruff farm dog who tries to cure the lovable pooch of his neuroses.","release_date":"2019-05-24"},{"vote_count":230,"id":502416,"video":false,"vote_average":5.6,"title":"Ma","popularity":32.526,"poster_path":"/6n7ASmQ1wY2cxTubFFGlcvPpyk7.jpg","original_language":"en","original_title":"Ma","genre_ids":[53,27],"backdrop_path":"/mBOv5YrX5QGr5CusK0PKSHuxOt9.jpg","adult":false,"overview":"Sue Ann is a loner who keeps to herself in her quiet Ohio town. One day, she is asked by Maggie, a new teenager in town, to buy some booze for her and her friends, and Sue Ann sees the chance to make some unsuspecting, if younger, friends of her own.","release_date":"2019-05-29"},{"vote_count":2235,"id":447200,"video":false,"vote_average":6.1,"title":"Skyscraper","popularity":29.518,"poster_path":"/5LYSsOPzuP13201qSzMjNxi8FxN.jpg","original_language":"en","original_title":"Skyscraper","genre_ids":[28],"backdrop_path":"/oMKFQmoVgB69fyXfSMu0lGlHJP2.jpg","adult":false,"overview":"Framed and on the run, a former FBI agent must save his family from a blazing fire in the world's tallest building.","release_date":"2018-07-11"},{"vote_count":292,"id":496243,"video":false,"vote_average":8.8,"title":"Parasite","popularity":29.072,"poster_path":"/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg","original_language":"ko","original_title":"기생충","genre_ids":[18,53],"backdrop_path":"/ny5aCtglk2kceGAuAdiyqbhBBAf.jpg","adult":false,"overview":"All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.","release_date":"2019-05-30"},{"vote_count":917,"id":527641,"video":false,"vote_average":8.2,"title":"Five Feet Apart","popularity":29.009,"poster_path":"/kreTuJBkUjVWePRfhHZuYfhNE1T.jpg","original_language":"en","original_title":"Five Feet Apart","genre_ids":[10749,18],"backdrop_path":"/d7wa3VpUpKDQ7GG9EMw8zSJCFoI.jpg","adult":false,"overview":"Seventeen-year-old Stella spends most of her time in the hospital as a cystic fibrosis patient. Her life is full of routines, boundaries and self-control -- all of which get put to the test when she meets Will, an impossibly charming teen who has the same illness. There's an instant flirtation, though restrictions dictate that they must maintain a safe distance between them. As their connection intensifies, so does the temptation to throw the rules out the window and embrace that attraction.","release_date":"2019-03-15"}]
     * page : 1
     * total_results : 336
     * dates : {"maximum":"2019-08-01","minimum":"2019-07-09"}
     * total_pages : 17
     */
    @SerializedName("results")
    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    @Entity(tableName = ResultsBean.TABLE_NAME)
    public static class ResultsBean implements Parcelable {
        public static final Creator<ResultsBean> CREATOR = new Creator<ResultsBean>() {
            @Override
            public ResultsBean createFromParcel(Parcel in) {
                return new ResultsBean(in);
            }

            @Override
            public ResultsBean[] newArray(int size) {
                return new ResultsBean[size];
            }
        };
        public static final String TABLE_NAME = "movie";
        private static final String COLUMN_ID = "id";
        private static final String COLUMN_VOTE_AVERAGE = "vote_average";
        private static final String COLUMN_TITLE = "title";
        private static final String COLUMN_POPULARITY = "popularity";
        private static final String COLUMN_POSTER_PATH = "poster_path";
        private static final String COLUMN_ORIGINAL_LANGUAGE = "original_language";
        private static final String COLUMN_ORIGINAL_TITLE = "original_title";
        private static final String COLUMN_BACKDROP_PATH = "backdrop_path";
        private static final String COLUMN_OVERVIEW = "overview";
        private static final String COLUMN_RELEASE_DATE = "release_date";


        @SerializedName("id")
        @PrimaryKey
        @ColumnInfo(name = COLUMN_ID)
        public int id;
        @SerializedName("vote_average")
        @ColumnInfo(name = COLUMN_VOTE_AVERAGE)
        private double voteAverage;
        @SerializedName("title")
        @ColumnInfo(name = COLUMN_TITLE)
        private String title;
        @SerializedName("popularity")
        @ColumnInfo(name = COLUMN_POPULARITY)
        private double popularity;
        @SerializedName("poster_path")
        @ColumnInfo(name = COLUMN_POSTER_PATH)
        private String posterPath;
        @SerializedName("original_language")
        @ColumnInfo(name = COLUMN_ORIGINAL_LANGUAGE)
        private String originalLanguage;
        @SerializedName("original_title")
        @ColumnInfo(name = COLUMN_ORIGINAL_TITLE)
        private String originalTitle;
        @SerializedName("backdrop_path")
        @ColumnInfo(name = COLUMN_BACKDROP_PATH)
        private String backdropPath;
        @SerializedName("overview")
        @ColumnInfo(name = COLUMN_OVERVIEW)
        private String overview;
        @SerializedName("release_date")
        @ColumnInfo(name = COLUMN_RELEASE_DATE)
        private String releaseDate;

        protected ResultsBean(Parcel in) {
            this.id = in.readInt();
            this.voteAverage = in.readDouble();
            this.title = in.readString();
            this.popularity = in.readDouble();
            this.posterPath = in.readString();
            this.originalLanguage = in.readString();
            this.originalTitle = in.readString();
            this.backdropPath = in.readString();
            this.overview = in.readString();
            this.releaseDate = in.readString();
        }

        public ResultsBean() {

        }

        public static MovieResponse.ResultsBean fromContentValues(ContentValues values) {
            final MovieResponse.ResultsBean entityMovie = new MovieResponse.ResultsBean();

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
            dest.writeInt(this.id);
            dest.writeDouble(this.voteAverage);
            dest.writeString(this.title);
            dest.writeDouble(this.popularity);
            dest.writeString(this.posterPath);
            dest.writeString(this.originalLanguage);
            dest.writeString(this.originalTitle);
            dest.writeString(this.backdropPath);
            dest.writeString(this.overview);
            dest.writeString(this.releaseDate);
        }

    }
}
