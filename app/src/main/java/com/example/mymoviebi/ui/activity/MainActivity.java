package com.example.mymoviebi.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.mymoviebi.R;
import com.example.mymoviebi.databinding.ActivityMainBinding;
import com.example.mymoviebi.ui.fragment.favorite.FavoriteFragment;
import com.example.mymoviebi.ui.fragment.movie.MovieFragment;
import com.example.mymoviebi.ui.fragment.search.SearchFragment;
import com.example.mymoviebi.ui.fragment.tvshow.TVShowFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String KEY_FRAGMENT = "fragment";
    private ActivityMainBinding activityMain2Binding;
    private Fragment fragment = new MovieFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(activityMain2Binding.appbarMain.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, activityMain2Binding.drawerLayout, activityMain2Binding.appbarMain.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        activityMain2Binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        activityMain2Binding.appbarMain.toolbar.setTitle(R.string.title_home);
        activityMain2Binding.navView.setNavigationItemSelectedListener(this);
        activityMain2Binding.navView.getMenu().getItem(1).setChecked(true);

        if (savedInstanceState != null) {
            fragment = getSupportFragmentManager().getFragment(savedInstanceState, KEY_FRAGMENT);
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container_movie, fragment).commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_setting) {
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.navigation_home) {
            fragment = new MovieFragment();
            activityMain2Binding.appbarMain.toolbar.setTitle(R.string.title_home);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_movie, fragment)
                    .commit();
        } else if (id == R.id.navigation_dashboard) {
            fragment = new TVShowFragment();
            activityMain2Binding.appbarMain.toolbar.setTitle(R.string.title_dashboard);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_movie, fragment)
                    .commit();
        } else if (id == R.id.favorite) {
            fragment = new FavoriteFragment();
            activityMain2Binding.appbarMain.toolbar.setTitle(R.string.favorite);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_movie, fragment)
                    .commit();
        } else if (id == R.id.action_search) {
//            Intent mIntent = new Intent(MainActivity.this , SearchableActivity.class);
//            startActivity(mIntent);
//            return true;
            fragment = new SearchFragment();
            activityMain2Binding.appbarMain.toolbar.setTitle(R.string.search);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container_movie, fragment)
                    .commit();
        }
        activityMain2Binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getSupportFragmentManager().putFragment(outState, KEY_FRAGMENT, fragment);
        super.onSaveInstanceState(outState);
    }
}
