package com.example.mymoviebi.ui.fragment.setting;


import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import com.example.mymoviebi.BuildConfig;
import com.example.mymoviebi.R;
import com.example.mymoviebi.alarm.DailyAlarmReminder;
import com.example.mymoviebi.alarm.ReleaseReminderToday;
import com.example.mymoviebi.modul.MovieResponse;
import com.example.mymoviebi.rest.MovieService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SettingFragment extends PreferenceFragmentCompat implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {

    private String LANGUAGE_LOCALE;
    private String RELEASE_REMINDER;
    private String RELEASE_TODAY;

    private Preference preLanguage;
    private SwitchPreference preReleaseReminder;
    private SwitchPreference preReleaseToday;

    private List<MovieResponse.ResultsBean> upcomingMovies = new ArrayList<>();

    private DailyAlarmReminder dailyAlarmReceiver = new DailyAlarmReminder();
    private ReleaseReminderToday releaseReminderToday = new ReleaseReminderToday();

    public SettingFragment() {
    }


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref_setting);

        init();

        preLanguage.setOnPreferenceClickListener(this);
        preReleaseReminder.setOnPreferenceChangeListener(this);
        preReleaseToday.setOnPreferenceChangeListener(this);
    }


    private void init() {
        LANGUAGE_LOCALE = getResources().getString(R.string.key_setting_locale);
        RELEASE_REMINDER = getResources().getString(R.string.key_release_reminder);
        RELEASE_TODAY = getResources().getString(R.string.key_release_daily);

        preLanguage = findPreference(LANGUAGE_LOCALE);
        preReleaseReminder = (SwitchPreference) findPreference(RELEASE_REMINDER);
        preReleaseToday = (SwitchPreference) findPreference(RELEASE_TODAY);
    }


    @Override
    public boolean onPreferenceClick(Preference preference) {

        String key = preference.getKey();

        if (key.equals(LANGUAGE_LOCALE)) {
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return true;
    }


    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        String key = preference.getKey();
        boolean isOn = (boolean) newValue;

        if (key.equals(RELEASE_REMINDER)) {
            if (isOn) {
                dailyAlarmReceiver.setRepeatingAlarm(getActivity());
                Toast.makeText(getActivity(), R.string.switchOn, Toast.LENGTH_SHORT).show();
            } else {
                dailyAlarmReceiver.cancelAlarm(getActivity());
                Toast.makeText(getActivity(), R.string.switchOff, Toast.LENGTH_SHORT).show();
            }
        } else if (key.equals(RELEASE_TODAY)) {
            if (isOn) {
                displayUpcomingMovie();
                Toast.makeText(getActivity(), R.string.switchOn, Toast.LENGTH_SHORT).show();
            } else {
                releaseReminderToday.cancelAlarm(getActivity());
                Toast.makeText(getActivity(), R.string.switchOff, Toast.LENGTH_SHORT).show();
            }
        }

        return true;
    }

    private Date dateFormatter(String movieDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = null;
        try {
            date = sdf.parse(movieDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    private void displayUpcomingMovie() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        final String currentDate = sdf.format(date);

        MovieService.getAPI().getUpcomingMovie(BuildConfig.API_KEY).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<MovieResponse.ResultsBean> movies = new ArrayList<>();
                        upcomingMovies = response.body().getResults();
                        for (int i = 0; i < upcomingMovies.size(); i++) {
                            MovieResponse.ResultsBean movie = upcomingMovies.get(i);
                            Date movieDate = dateFormatter(movie.getReleaseDate());

                            if (movieDate.equals(dateFormatter(currentDate))) {
                                movies.add(movie);
                            }
                        }
                        releaseReminderToday.setRepeatingAlarm(getActivity(), movies);
                    } else {
                        Toast.makeText(getActivity(), R.string.empty_data, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("Error Gan", t.getMessage());
            }
        });
    }

}
