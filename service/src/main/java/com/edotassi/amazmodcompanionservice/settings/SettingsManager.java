package com.edotassi.amazmodcompanionservice.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.edotassi.amazmodcompanionservice.Constants;

import amazmod.com.transport.data.SettingsData;

public class SettingsManager {

    private Context context;

    public SettingsManager(Context context) {
        this.context = context;
    }

    public void sync(SettingsData settingsData) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(Constants.PREF_NOTIFICATION_SCREEN_TIMEOUT, settingsData.getScreenTimeout());
        editor.putInt(Constants.PREF_NOTIFICATION_VIBRATION, settingsData.getVibration());
        editor.putString(Constants.PREF_NOTIFICATION_CUSTOM_REPLIES, settingsData.getReplies());
        editor.putBoolean(Constants.PREF_NOTIFICATIONS_ENABLE_CUSTOM_UI, settingsData.isNotificationsCustomUi());

        editor.apply();
    }

    public int getInt(String key, int defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(key, defaultValue);
    }

    public long getLong(String key, long defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong(key, defaultValue);
    }

    public String getString(String key, String defaultValue) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, defaultValue);
    }
}
