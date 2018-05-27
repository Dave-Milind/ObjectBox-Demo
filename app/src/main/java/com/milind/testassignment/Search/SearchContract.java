package com.milind.testassignment.Search;

import android.content.Context;

import com.milind.testassignment.Base.BasePresenter;
import com.milind.testassignment.Base.BaseView;

public interface SearchContract {

  interface View extends BaseView{


      void setGridview(Context context, SearchModel searchModel);
       void onImageClick(String url);
  }

  interface Presenter extends BasePresenter {


      void onSearchButtonClick(String searchData);
      void attachView(View view);
      void attachController(SearchComponent searchComponent);
  }

}
