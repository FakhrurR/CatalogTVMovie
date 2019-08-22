package com.example.mymoviebi.ui.fragment.favorite;

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

public class FavoriteFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainBinding fragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        setupViewPager(fragmentMainBinding.viewpager);
        fragmentMainBinding.tabsMovie.setupWithViewPager(fragmentMainBinding.viewpager);

        return fragmentMainBinding.getRoot();

    }

    private void setupViewPager(ViewPager viewPager) {
        TabsAdapter adapter = new TabsAdapter(getChildFragmentManager());
        adapter.addFragment(new FavoriteMovie(), getString(R.string.title_home));
        adapter.addFragment(new FavoriteTVShow(), getString(R.string.title_dashboard));
        viewPager.setAdapter(adapter);
    }
}
