package com.milind.testassignment;

import android.app.Application;

import com.milind.testassignment.Data.MyObjectBox;

import io.objectbox.BoxStore;

public class App extends Application {

public static BoxStore boxStore;

 public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
appComponent=DaggerAppComponent.builder()
        .appModule(new AppModule(this)).build();
boxStore=appComponent.getBoxStore();


    }
}
