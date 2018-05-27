package com.milind.testassignment.Search;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.milind.testassignment.Utils.Constants;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenter implements SearchContract.Presenter {

private SearchContract.View mView;

String TAG="SearchPresenterTAG";
SearchComponent searchComponent;
    @Override
    public void onSearchButtonClick(String searchData) {
        Log.e(TAG,"onSearchButtonClick called");
        Disposable searchModelObservable=searchComponent.getGiphyService().getSearchResult(searchData, Constants.APIKEY,5).
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SearchModel>() {
                    @Override
                    public void accept(SearchModel searchModel) throws Exception {

                       mView.setGridview(searchComponent.getContext(),searchModel);

                    }
                } ,new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG," error: "+throwable.getMessage());
            }
        });


    }



    @Override
    public void attachView(SearchContract.View view) {
      this.mView=view;
      }

    @Override
    public void attachController(SearchComponent searchComponent) {
      this.searchComponent=searchComponent;
    }


}
