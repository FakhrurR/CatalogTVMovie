package com.example.mymoviebi.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mymoviebi.R;
import com.example.mymoviebi.databinding.ActivitySettingBinding;
import com.example.mymoviebi.ui.fragment.setting.SettingFragment;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySettingBinding activitySettingBinding = DataBindingUtil.setContentView(this, R.layout.activity_setting);

        setSupportActionBar(activitySettingBinding.settingToolbar);
        activitySettingBinding.settingToolbar.setTitle(getString(R.string.action_settings));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SettingFragment()).commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
