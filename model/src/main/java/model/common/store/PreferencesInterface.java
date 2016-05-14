package model.common.store;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by joris on 19/04/16.
 */
public interface PreferencesInterface {

    @Nullable
    String getString(@Nonnull String key, @Nullable String defValue);

    void putString(@Nonnull String key, @Nullable String value);

    int getInt(@Nonnull String key, int defValue);

    void putInt(@Nonnull String key, int value);

    long getLong(@Nonnull String key, long defValue);

    void putLong(@Nonnull String key, long value);

    float getFloat(@Nonnull String key, float defValue);

    void putFloat(@Nonnull String key, float value);

    boolean getBoolean(@Nonnull String key, boolean defValue);

    void putBoolean(@Nonnull String key, boolean value);

    boolean contains(@Nonnull String key);

    void remove(@Nonnull String key);

    void clear();

}
