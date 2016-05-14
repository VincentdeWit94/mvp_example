package model.appsbyvincent.mvp_boilerplate.router;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import model.appsbyvincent.mvp_boilerplate.MainActivity;

public class Router implements RouterInterface {

    private static final String TAG = "Router";

    private final Activity activity;

    public Router(@NonNull Activity activity) {
        this.activity = activity;
    }

    @Override
    public void openUri(@Nullable Uri uri) {
        Log.i(TAG, "Open URL: " + uri);

        if (uri != null) {
            if (RouterConstants.INTERNAL_URL_SCHEME.equals(uri.getScheme())) {
                openInternalUri(uri);
            }
            else {
                openExternalUri(uri);
            }
        }
        else {
            openDefault();
        }
    }

    private void openInternalUri(Uri uri) {
        String action = uri.getHost();
        List<String> segments = uri.getPathSegments();

        switch (action) {
            // Add default Activities to open

            default:
                openDefault(uri);
                break;
        }
    }

    private void openExternalUri(Uri uri) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            activity.startActivity(intent);
        }
        catch (ActivityNotFoundException e) {
            Log.w(TAG, e);
        }
    }

    private void openDefault() {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
    }

    private void openDefault(Uri uri) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.setData(uri);
        activity.startActivity(intent);
    }

}
