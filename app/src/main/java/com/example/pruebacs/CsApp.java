package com.example.pruebacs;

import android.app.Application;
import android.content.Context;

import io.objectbox.BoxStore;

public class CsApp extends Application{
    private static BoxStore boxStoreInstance;
    private static Application application;

    @Override public void onCreate() {
        super.onCreate();
        application = this;
//        boxStoreInstance = MyObjectBox.builder().androidContext(CsApp.this).build();

    }

    public static BoxStore getBoxStore(){
        return boxStoreInstance;
    }

    public static void cleanBoxStore(){

    }

    public static Context getMainContext(){
        return application.getApplicationContext();
    }

    public static Application getApplication(){
        return application;
    }
}
