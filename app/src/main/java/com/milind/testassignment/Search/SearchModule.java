package com.milind.testassignment.Search;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.milind.testassignment.Network.GiphyService;
import com.milind.testassignment.Utils.Constants;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class SearchModule {

    Context context;

    SearchModule(Context context) {

        this.context = context;
    }

    @Provides
    Retrofit getRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(Constants.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    GiphyService getGiphyService(Retrofit retrofit) {

        return retrofit.create(GiphyService.class);
    }

    @Provides
    Context getContext(){

        return context;
    }

}
