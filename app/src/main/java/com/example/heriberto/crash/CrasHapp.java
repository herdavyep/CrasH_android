package com.example.heriberto.crash;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by heriberto on 17/05/17.
 */

public class CrasHapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

    }
}
