package com.example.mymoviebi.ui.fragment.search;


import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mymoviebi.BuildConfig;
import com.example.mymoviebi.R;
import com.example.mymoviebi.databinding.FragmentMovieBinding;
import com.example.mymoviebi.modul.TVShowResponse;
import com.example.mymoviebi.rest.MovieService;
import com.example.mymoviebi.ui.adapter.TVShowAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchTVFragment extends Fragment {


    private FragmentMovieBinding fragmentMovieBinding;
    private String querys;
    private String queryChange = null;
    private List<TVShowResponse.ResultsBean> tvShows = new ArrayList<>();
    private TVShowAdapter tvShowAdapter;

    public SearchTVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMovieBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);

        fragmentMovieBinding.searchView.setVisibility(View.VISIBLE);
        fragmentMovieBinding.progressMovie.setVisibility(View.GONE);

        fragmentMovieBinding.swipeMovie.setEnabled(false);

        initRecycleView();

        if (savedInstanceState != null) {
            List<TVShowResponse.ResultsBean> tvShows = savedInstanceState.getParcelableArrayList("tvShows");
            displayTVShows(tvShows);
        } else {
            fragmentMovieBinding.textSearch.setVisibility(View.VISIBLE);
        }

        fragmentMovieBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                queryChange = query;
                getTVResult();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return fragmentMovieBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("tvShows", new ArrayList<Parcelable>(tvShowAdapter.getTVShow()));
    }

    private void getTVResult() {

        fragmentMovieBinding.progressMovie.setVisibility(View.VISIBLE);
        fragmentMovieBinding.textSearch.setVisibility(View.GONE);
        if (queryChange == null) {
            MovieService.getAPI().getSearchTVShow(BuildConfig.API_KEY, querys).enqueue(new Callback<TVShowResponse>() {
                @Override
                public void onResponse(Call<TVShowResponse> call, Response<TVShowResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            tvShows = response.body().getResults();
                            tvShowAdapter = new TVShowAdapter(tvShows, getContext());
                            fragmentMovieBinding.rvMovie.setAdapter(tvShowAdapter);
                            fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                        }
                    }
                    if (tvShows.size() == 0) {
                        Toast.makeText(getContext(), R.string.empty_data, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<TVShowResponse> call, Throwable t) {
                    fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                    Log.d("Error", t.getMessage());
                }
            });

        } else {
            MovieService.getAPI().getSearchTVShow(BuildConfig.API_KEY, queryChange).enqueue(new Callback<TVShowResponse>() {
                @Override
                public void onResponse(Call<TVShowResponse> call, Response<TVShowResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            tvShows = response.body().getResults();
                            tvShowAdapter = new TVShowAdapter(tvShows, getContext());
                            fragmentMovieBinding.rvMovie.setAdapter(tvShowAdapter);
                            fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                        }
                    }
                    if (tvShows.size() == 0) {
                        Toast.makeText(getContext(), R.string.empty_data, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<TVShowResponse> call, Throwable t) {
                    fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                    Log.d("Error", t.getMessage());
                }
            });
        }
    }


    private void displayTVShows(List<TVShowResponse.ResultsBean> allTVShowList) {
        fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
        tvShows.clear();
        tvShows.addAll(allTVShowList);
        tvShowAdapter.notifyDataSetChanged();
    }

    private void initRecycleView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        fragmentMovieBinding.rvMovie.setLayoutManager(layoutManager);
        tvShowAdapter = new TVShowAdapter(tvShows, getContext());
        fragmentMovieBinding.rvMovie.setAdapter(tvShowAdapter);
    }

}
