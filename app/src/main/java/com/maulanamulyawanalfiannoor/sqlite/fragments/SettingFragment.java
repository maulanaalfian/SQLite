package com.maulanamulyawanalfiannoor.sqlite.fragments;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.maulanamulyawanalfiannoor.sqlcoba1.R;
import com.maulanamulyawanalfiannoor.sqlite.R;

public class SettingFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference, rootKey);
    }
}
