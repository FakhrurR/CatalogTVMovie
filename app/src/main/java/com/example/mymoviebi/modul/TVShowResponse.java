package com.example.mymoviebi.modul;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVShowResponse {

    /**
     * page : 1
     * total_results : 291
     * total_pages : 15
     * results : [{"original_name":"Legion","genre_ids":[10759,10765],"name":"Legion","popularity":213.798,"origin_country":["US"],"vote_count":570,"first_air_date":"2017-02-08","backdrop_path":"/87eP7ITTrOWvkA4EqCuoRdyjzLy.jpg","original_language":"en","id":67195,"vote_average":7.6,"overview":"David Haller, AKA Legion, is a troubled young man who may be more than human. Diagnosed as schizophrenic, David has been in and out of psychiatric hospitals for years. But after a strange encounter with a fellow patient, he\u2019s confronted with the possibility that the voices he hears and the visions he sees might be real.","poster_path":"/vT0Zsbm4GWd7llNjgWEtwY0CqOv.jpg"},{"original_name":"Fear the Walking Dead","genre_ids":[18,27],"name":"Fear the Walking Dead","popularity":185.598,"origin_country":["US"],"vote_count":957,"first_air_date":"2015-08-23","backdrop_path":"/7r4FieFH6Eh6S55hi8c9LOiFENg.jpg","original_language":"en","id":62286,"vote_average":6.3,"overview":"What did the world look like as it was transforming into the horrifying apocalypse depicted in \"The Walking Dead\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.","poster_path":"/oYXxZIiI7lVh6IUCCikImKwULHB.jpg"},{"original_name":"ワンピース","genre_ids":[16,35,10759],"name":"One Piece","popularity":157.835,"origin_country":["JP"],"vote_count":245,"first_air_date":"1999-10-20","backdrop_path":"/xgs7zAF5VSGAK0QstH1Q0ivybXz.jpg","original_language":"ja","id":37854,"vote_average":7.6,"overview":"Years ago, the fearsome pirate king Gol D. Roger was executed, leaving a huge pile of treasure and the famous \"One Piece\" behind. Whoever claims the \"One Piece\" will be named the new pirate king. Monkey D. Luffy, a boy who consumed one of the \"Devil's Fruits\", has it in his head that he'll follow in the footsteps of his idol, the pirate Shanks, and find the One Piece. It helps, of course, that his body has the properties of rubber and he's surrounded by a bevy of skilled fighters and thieves to help him along the way. Monkey D. Luffy brings a bunch of his crew followed by, Roronoa Zoro, Nami, Usopp, Sanji, Tony-Tony Chopper, Nico Robin, Franky, and Brook. They will do anything to get the One Piece and become King of the Pirates!","poster_path":"/gJI77i79KnRuc9mGPKADPZWAE8O.jpg"},{"original_name":"The 100","genre_ids":[18,10765],"name":"The 100","popularity":152.461,"origin_country":["US"],"vote_count":1574,"first_air_date":"2014-03-19","backdrop_path":"/qYTIuJJ7fIehicAt3bl0vW70Sq6.jpg","original_language":"en","id":48866,"vote_average":6.5,"overview":"100 years in the future, when the Earth has been abandoned due to radioactivity, the last surviving humans live on an ark orbiting the planet \u2014 but the ark won't last forever. So the repressive regime picks 100 expendable juvenile delinquents to send down to Earth to see if the planet is still habitable.","poster_path":"/wBzNjurA8ijJPF21Ggs9nbviIzi.jpg"},{"original_name":"ブラッククローバー","genre_ids":[16,35,10759],"name":"Black Clover","popularity":142.444,"origin_country":["JP"],"vote_count":74,"first_air_date":"2017-10-03","backdrop_path":"/tQItgCaJVrXhe6CsJZ5qOKpOoRQ.jpg","original_language":"ja","id":73223,"vote_average":5.5,"overview":"Asta and Yuno are two orphans who want the same thing: to become the Wizard King. Locked in a friendly rivalry, they work hard towards their goal. While Yuno excels at magic, Asta has a problem uncommon in this world: he has no powers! But, on the day they receive their grimoires, they surprise everyone. To reach their goal, they\u2019ll each find their own path to greatness\u2014with or without magic.","poster_path":"/kaMisKeOoTBPxPkbC3OW7Wgt6ON.jpg"},{"original_name":"Marvel's Agents of S.H.I.E.L.D.","genre_ids":[18,10759,10765],"name":"Marvel's Agents of S.H.I.E.L.D.","popularity":140.775,"origin_country":["US"],"vote_count":1315,"first_air_date":"2013-09-24","backdrop_path":"/iWopHyAvuIDjGX10Yc3nn6UEebW.jpg","original_language":"en","id":1403,"vote_average":6.8,"overview":"Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary.","poster_path":"/cXiETfFK1BTLest5fhTLfDLRdL6.jpg"},{"original_name":"フェアリーテイル","genre_ids":[16,35,10759,10765],"name":"Fairy Tail","popularity":128.503,"origin_country":["JP"],"vote_count":183,"first_air_date":"2009-10-12","backdrop_path":"/m2lugAG39sO0yCcuxEAu4fY5u1o.jpg","original_language":"ja","id":46261,"vote_average":6.4,"overview":"Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.","poster_path":"/58GKcwFV3lpVOGzybeMrrNOjHpz.jpg"},{"original_name":"American Dad!","genre_ids":[16,35],"name":"American Dad!","popularity":119.391,"origin_country":["US"],"vote_count":690,"first_air_date":"2005-02-06","backdrop_path":"/vddYkC55H3DqWK5cG5hepSnhzGP.jpg","original_language":"en","id":1433,"vote_average":6.1,"overview":"The series focuses on an eccentric motley crew that is the Smith family and their three housemates: Father, husband, and breadwinner Stan Smith; his better half housewife, Francine Smith; their college-aged daughter, Hayley Smith; and their high-school-aged son, Steve Smith. Outside of the Smith family, there are three additional main characters, including Hayley's boyfriend turned husband, Jeff Fischer; the family's man-in-a-goldfish-body pet, Klaus; and most notably the family's zany alien, Roger, who is \"full of masquerades, brazenness, and shocking antics.\"","poster_path":"/eo2Xu4UWXHE8UlBlAktNiSsAmfx.jpg"},{"original_name":"鬼滅の刃","genre_ids":[16,18,10759,10765],"name":"Demon Slayer: Kimetsu no Yaiba","popularity":118.286,"origin_country":["JP"],"vote_count":17,"first_air_date":"2019-04-06","backdrop_path":"/nTvM4mhqNlHIvUkI1gVnW6XP7GG.jpg","original_language":"ja","id":85937,"vote_average":5.9,"overview":"It is the Taisho Period in Japan. Tanjiro, a kindhearted boy who sells charcoal for a living, finds his family slaughtered by a demon. To make matters worse, his younger sister Nezuko, the sole survivor, has been transformed into a demon herself.\n\nThough devastated by this grim reality, Tanjiro resolves to become a \u201cdemon slayer\u201d so that he can turn his sister back into a human, and kill the demon that massacred his family.","poster_path":"/taT33NroOl2Fn8bUGj8bwdmNw3G.jpg"},{"original_name":"Swamp Thing","genre_ids":[18,9648,10765],"name":"Swamp Thing","popularity":101.874,"origin_country":["US"],"vote_count":37,"first_air_date":"2019-05-31","backdrop_path":"/5YEnPWmTMpPtFk3MxjlfO1U1xW5.jpg","original_language":"en","id":79240,"vote_average":6.8,"overview":"CDC researcher Abby Arcane investigates what seems to be a deadly swamp-born virus in a small town in Louisiana but she soon discovers that the swamp holds mystical and terrifying secrets. When unexplainable and chilling horrors emerge from the murky marsh, no one is safe.","poster_path":"/dD3HcMczLC9wNvfNzx4pZVyl6q8.jpg"},{"original_name":"Sesame Street","genre_ids":[16,35,10751],"name":"Sesame Street","popularity":84.844,"origin_country":["US"],"vote_count":84,"first_air_date":"1969-11-10","backdrop_path":"/6HswtHbletDHrR8B84U5KWkXheQ.jpg","original_language":"en","id":502,"vote_average":7.4,"overview":"On a special inner city street, the inhabitants\u2014human and muppet\u2014teach preschoolers basic educational and social concepts using comedy, cartoons, games, and songs.","poster_path":"/rNknh7XQUWvm4j9WeuhUJhT9NP4.jpg"},{"original_name":"炎炎ノ消防隊","genre_ids":[16,18,10759,10765],"name":"Fire Force","popularity":81.907,"origin_country":["JP"],"vote_count":1,"first_air_date":"2019-07-06","backdrop_path":"/zDXuwmqkTi2lGM4AyloAAX4v51P.jpg","original_language":"ja","id":88046,"vote_average":9,"overview":"Year 198 of the Solar Era in Tokyo, special fire brigades are fighting against a phenomenon called spontaneous human combustion where humans beings are turned into living infernos called \"Infernals\". While the Infernals are first generation cases of spontaneous human combustion, later generations possess the ability to manipulate flames while retaining human form. Shinra Kusakabe, a youth who gained the nickname Devil's Footprints for his ability to ignite his feet at will, joins the Special Fire Force Company 8 which composes of other flames users as they work to extinguish any Infernals they encounter. As a faction that is creating Infernals appears, Shira begins to uncover the truth behind a mysterious fire that caused the death of his family twelve years ago.","poster_path":"/xwKGTFXL2kKz6P0WI23Q2ecaGOO.jpg"},{"original_name":"Euphoria","genre_ids":[18],"name":"Euphoria","popularity":77.322,"origin_country":["US"],"vote_count":21,"first_air_date":"2019-06-16","backdrop_path":"/qQ9ahv5g2nDWh8jVBQsQSnbvRAC.jpg","original_language":"en","id":85552,"vote_average":6.5,"overview":"A group of high school students navigate love and friendships in a world of drugs, sex, trauma, and social media.","poster_path":"/5mi3aRl16yKmfpQJMzvqN5TXkdA.jpg"},{"original_name":"Blood & Treasure","genre_ids":[18,10759],"name":"Blood & Treasure","popularity":76.743,"origin_country":["US"],"vote_count":21,"first_air_date":"2019-05-21","backdrop_path":"/uov6mcUkg3GuqpGopSqWbhAEWLF.jpg","original_language":"en","id":88118,"vote_average":4.3,"overview":"An antiquities expert teams up with an art thief to catch a terrorist who funds his attacks using stolen artifacts.","poster_path":"/xbWqfPKBhqOZQEGq7HdDkX0Bjib.jpg"},{"original_name":"Scream: The TV Series","genre_ids":[27],"name":"Scream: The TV Series","popularity":70.834,"origin_country":["US"],"vote_count":164,"first_air_date":"2015-06-30","backdrop_path":"/d4pN1VYvA6PliVhHcCEEVasuJ1A.jpg","original_language":"en","id":62823,"vote_average":6.4,"overview":"What starts as a YouTube video going viral, soon leads to problems for the teenagers of Lakewood and serves as the catalyst for a murder that opens up a window to the town's troubled past. Everyone has secrets. Everyone tells lies. Everyone is fair game.","poster_path":"/lMzclYREKmM5foluxGGf31UZmS8.jpg"},{"original_name":"Elementary","genre_ids":[80,18,9648],"name":"Elementary","popularity":70.15,"origin_country":["US"],"vote_count":647,"first_air_date":"2012-09-27","backdrop_path":"/7sJrNKwzyJWnFPFpDL9wnZ859LZ.jpg","original_language":"en","id":1415,"vote_average":7,"overview":"A modern-day drama about a crime-solving duo that cracks the NYPD's most impossible cases. Following his fall from grace in London and a stint in rehab, eccentric Sherlock escapes to Manhattan where his wealthy father forces him to live with his worst nightmare - a sober companion, Dr. Watson.","poster_path":"/q9dObe29W4bDpgzUfOOH3ZnzDbR.jpg"},{"original_name":"Final Space","genre_ids":[16,10759],"name":"Final Space","popularity":67.837,"origin_country":["US"],"vote_count":60,"first_air_date":"2018-02-26","backdrop_path":"/5tVBWjENNERVBstTCEPBKKlViOD.jpg","original_language":"en","id":74387,"vote_average":8.3,"overview":"An astronaut named Gary and his planet-destroying sidekick Mooncake embark on serialized journeys through space in order to unlock the mystery of \u201cFinal Space,\u201d the last point in the universe, if it actually does exist.","poster_path":"/gPUW5fUKZtLkmlWqZteLBeXPymC.jpg"},{"original_name":"Big Little Lies","genre_ids":[18],"name":"Big Little Lies","popularity":67.11,"origin_country":["US"],"vote_count":360,"first_air_date":"2017-02-19","backdrop_path":"/8Wo2Pqjxn7Xmd7p2dxRMIJtyMV7.jpg","original_language":"en","id":66292,"vote_average":7.7,"overview":"The tale of three mothers of first graders whose apparently perfect lives unravel to the point of murder.","poster_path":"/zxGkno93ExrTMsJVllH6mzQ652z.jpg"},{"original_name":"Krypton","genre_ids":[18,10759,10765],"name":"Krypton","popularity":65.511,"origin_country":["US"],"vote_count":96,"first_air_date":"2018-03-21","backdrop_path":"/2ZDH1mj5OthywHyWDnVrurOitAX.jpg","original_language":"en","id":71340,"vote_average":6.7,"overview":"Set two generations before the destruction of the legendary Man of Steel\u2019s home planet, Krypton follows Superman\u2019s grandfather \u2014 whose House of El was ostracized and shamed \u2014 as he fights to redeem his family\u2019s honor and save his beloved world from chaos.","poster_path":"/uiinjmSkka6JOrk4FsZmrjlNM26.jpg"},{"original_name":"NOVA","genre_ids":[99],"name":"NOVA","popularity":62.82,"origin_country":["US"],"vote_count":49,"first_air_date":"1974-03-03","backdrop_path":"/2XAaObTzZKomc3wVU2iGgnQHGxk.jpg","original_language":"en","id":3562,"vote_average":7.1,"overview":"PBS' premier science series helps viewers of all ages explore the science behind the headlines. Along the way, NOVA demystifies science and technology, and highlights the people involved in scientific pursuits.","poster_path":"/pTdfXd5eyoXB9GUeLQ0vnE3GMwG.jpg"}]
     */

    @SerializedName("results")
    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    @Entity(tableName = "tvShows")
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
        /**
         * original_name : Legion
         * genre_ids : [10759,10765]
         * name : Legion
         * popularity : 213.798
         * origin_country : ["US"]
         * vote_count : 570
         * first_air_date : 2017-02-08
         * backdrop_path : /87eP7ITTrOWvkA4EqCuoRdyjzLy.jpg
         * original_language : en
         * id : 67195
         * vote_average : 7.6
         * overview : David Haller, AKA Legion, is a troubled young man who may be more than human. Diagnosed as schizophrenic, David has been in and out of psychiatric hospitals for years. But after a strange encounter with a fellow patient, he’s confronted with the possibility that the voices he hears and the visions he sees might be real.
         * poster_path : /vT0Zsbm4GWd7llNjgWEtwY0CqOv.jpg
         */

        @SerializedName("original_name")
        private String originalName;
        @SerializedName("name")
        private String name;
        @SerializedName("popularity")
        private double popularity;
        @SerializedName("vote_count")
        private int voteCount;
        @SerializedName("first_air_date")
        private String firstAirDate;
        @SerializedName("backdrop_path")
        private String backdropPath;
        @SerializedName("original_language")
        private String originalLanguage;
        @SerializedName("id")
        @PrimaryKey
        private int id;
        @SerializedName("vote_average")
        private double voteAverage;
        @SerializedName("overview")
        private String overview;
        @SerializedName("poster_path")
        private String posterPath;

        protected ResultsBean(Parcel in) {
            originalName = in.readString();
            name = in.readString();
            popularity = in.readDouble();
            voteCount = in.readInt();
            firstAirDate = in.readString();
            backdropPath = in.readString();
            originalLanguage = in.readString();
            id = in.readInt();
            voteAverage = in.readDouble();
            overview = in.readString();
            posterPath = in.readString();
        }

        public ResultsBean() {

        }

        public String getOriginalName() {
            return originalName;
        }

        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public String getFirstAirDate() {
            return firstAirDate;
        }

        public void setFirstAirDate(String firstAirDate) {
            this.firstAirDate = firstAirDate;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
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

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(originalName);
            dest.writeString(name);
            dest.writeDouble(popularity);
            dest.writeInt(voteCount);
            dest.writeString(firstAirDate);
            dest.writeString(backdropPath);
            dest.writeString(originalLanguage);
            dest.writeInt(id);
            dest.writeDouble(voteAverage);
            dest.writeString(overview);
            dest.writeString(posterPath);
        }
    }
}
