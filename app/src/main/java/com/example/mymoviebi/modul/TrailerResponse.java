package com.example.mymoviebi.modul;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrailerResponse {

    /**
     * id : 71446
     * results : [{"id":"5c9655269251416b33f32459","iso_639_1":"en","iso_3166_1":"US","key":"cQYvQIrM1FY","name":"La Casa De Papel (Money Heist) TV Series Trailer","site":"YouTube","size":1080,"type":"Trailer"}]
     */

    @SerializedName("id")
    private int id;
    @SerializedName("results")
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

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
         * id : 5c9655269251416b33f32459
         * iso_639_1 : en
         * iso_3166_1 : US
         * key : cQYvQIrM1FY
         * name : La Casa De Papel (Money Heist) TV Series Trailer
         * site : YouTube
         * size : 1080
         * type : Trailer
         */

        @SerializedName("id")
        private String id;
        @SerializedName("key")
        private String key;
        @SerializedName("name")
        private String name;

        protected ResultsBean(Parcel in) {
            id = in.readString();
            key = in.readString();
            name = in.readString();
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getKey() {
            return key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(key);
            dest.writeString(name);
        }
    }
}
