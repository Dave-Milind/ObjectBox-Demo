package com.milind.testassignment.Search;


import android.content.Context;

import com.milind.testassignment.Network.GiphyService;

import dagger.Component;
import retrofit2.Retrofit;

@Component (modules = SearchModule.class)
public interface SearchComponent {

    GiphyService getGiphyService();
    Context getContext();


}
