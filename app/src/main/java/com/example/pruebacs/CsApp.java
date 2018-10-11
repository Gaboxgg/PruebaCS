package com.example.pruebacs;

import android.app.Application;
import android.content.Context;

import io.objectbox.BoxStore;

public class CsApp extends Application{
    private static Application application;

    @Override public void onCreate() {
        super.onCreate();
        application = this;

    }

    public static Context getMainContext(){
        return application.getApplicationContext();
    }

    public static Application getApplication(){
        return application;
    }
}
