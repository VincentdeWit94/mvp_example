package model.appsbyvincent.mvp_boilerplate.common.utils;

import android.content.SharedPreferences;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import model.common.store.PreferencesInterface;


public class SharedPreferencesWrapper implements PreferencesInterface {

    @Nonnull
    private final SharedPreferences prefs;

    public SharedPreferencesWrapper(@Nonnull SharedPreferences prefs) {
        this.prefs = prefs;
    }

    @Nullable
    @Override
    public String getString(@Nonnull String key, @Nullable String defValue) {
        return prefs.getString(key, defValue);
    }

    @Override
    public void putString(@Nonnull String key, @Nullable String value) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(key, value);
        edit.apply();
    }

    @Override
    public int getInt(@Nonnull String key, int defValue) {
        return prefs.getInt(key, defValue);
    }

    @Override
    public void putInt(@Nonnull String key, int value) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt(key, value);
        edit.apply();
    }

    @Override
    public long getLong(@Nonnull String key, long defValue) {
        return prefs.getLong(key, defValue);
    }

    @Override
    public void putLong(@Nonnull String key, long value) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putLong(key, value);
        edit.apply();
    }

    @Override
    public float getFloat(@Nonnull String key, float defValue) {
        return prefs.getFloat(key, defValue);
    }

    @Override
    public void putFloat(@Nonnull String key, float value) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putFloat(key, value);
        edit.apply();
    }

    @Override
    public boolean getBoolean(@Nonnull String key, boolean defValue) {
        return prefs.getBoolean(key, defValue);
    }

    @Override
    public void putBoolean(@Nonnull String key, boolean value) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    @Override
    public boolean contains(@Nonnull String key) {
        return prefs.contains(key);
    }

    @Override
    public void remove(@Nonnull String key) {
        SharedPreferences.Editor edit = prefs.edit();
        edit.remove(key);
        edit.apply();
    }

    @Override
    public void clear() {
        SharedPreferences.Editor edit = prefs.edit();
        edit.clear();
        edit.apply();
    }

}
