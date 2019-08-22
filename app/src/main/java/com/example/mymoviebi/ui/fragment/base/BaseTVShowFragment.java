package com.example.mymoviebi.ui.fragment.base;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.mymoviebi.R;
import com.example.mymoviebi.databinding.FragmentMovieBinding;
import com.example.mymoviebi.modul.TVShowResponse;
import com.example.mymoviebi.ui.adapter.TVShowAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseTVShowFragment extends Fragment {

    private static final String KEY_TVSHOWS = "tvShows";
    private FragmentMovieBinding fragmentMovieBinding;
    private TVShowAdapter tvShowAdapter;
    private List<TVShowResponse.ResultsBean> tvShows = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMovieBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);

        initRecyleView();

        fragmentMovieBinding.swipeMovie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fragmentMovieBinding.swipeMovie.setRefreshing(false);
                        getTVShows();
                    }
                }, 3000);
            }
        });

        return fragmentMovieBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState != null) {
            List<TVShowResponse.ResultsBean> tvShows = savedInstanceState.getParcelableArrayList(KEY_TVSHOWS);
            displayTVShows(tvShows);
        } else {
            getTVShows();
        }
    }

    private void initRecyleView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        fragmentMovieBinding.rvMovie.setLayoutManager(layoutManager);
        tvShowAdapter = new TVShowAdapter(tvShows, getContext());
        fragmentMovieBinding.rvMovie.setAdapter(tvShowAdapter);
    }

    protected abstract void getTVShows();

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY_TVSHOWS, new ArrayList<>(tvShowAdapter.getTVShow()));
    }

    protected void displayTVShowFromRemote(Call<TVShowResponse> call) {
        fragmentMovieBinding.progressMovie.setVisibility(View.VISIBLE);
        call.enqueue(new Callback<TVShowResponse>() {
            @Override
            public void onResponse(Call<TVShowResponse> call, Response<TVShowResponse> response) {
                fragmentMovieBinding.progressMovie.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<TVShowResponse.ResultsBean> allTVShowList = response.body().getResults();
                        displayTVShows(allTVShowList);
                    }
                }
                fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<TVShowResponse> call, Throwable t) {
                fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
                Log.d("Error gan : ", t.getMessage());
            }
        });
    }

    protected void displayTVShows(List<TVShowResponse.ResultsBean> allTVShowList) {
        fragmentMovieBinding.progressMovie.setVisibility(View.GONE);
        tvShows.clear();
        tvShows.addAll(allTVShowList);
        tvShowAdapter.notifyDataSetChanged();
        if (allTVShowList.isEmpty()) {
            fragmentMovieBinding.emptyData.setVisibility(View.VISIBLE);
        }
    }
}
