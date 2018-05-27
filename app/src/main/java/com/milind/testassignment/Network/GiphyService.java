package com.milind.testassignment.Network;

import com.milind.testassignment.Search.SearchModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GiphyService {
    @GET("search")
    Observable<SearchModel> getSearchResult(@Query("q") String searchTerm, @Query("api_key") String apiKey,@Query("limit")int limit);


}
