package com.example.mymoviebi.ui.fragment.tvshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mymoviebi.R;
import com.example.mymoviebi.databinding.FragmentMainBinding;
import com.example.mymoviebi.ui.adapter.TabsAdapter;

public class TVShowFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding fragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        setupViewPager(fragmentMainBinding.viewpager);
        fragmentMainBinding.tabsMovie.setupWithViewPager(fragmentMainBinding.viewpager);

        return fragmentMainBinding.getRoot();
    }

    private void setupViewPager(ViewPager viewPager) {
        TabsAdapter adapter = new TabsAdapter(getChildFragmentManager());
        adapter.addFragment(new OnTheAir(), getString(R.string.on_the_air));
        adapter.addFragment(new AiringToday(), getString(R.string.airing_today));
        viewPager.setAdapter(adapter);
    }

}
