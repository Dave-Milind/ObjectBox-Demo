package com.milind.testassignment.UserSelected;

import com.milind.testassignment.Base.BasePresenter;
import com.milind.testassignment.Base.BaseView;

public interface UserSelectContract {

    interface View extends BaseView{

       void setUpExoplayer();
void ShowToast(String message);
    }


    interface Presenter extends BasePresenter{


        void onUpVoteClick();
        void onDownVoteClick();
        void initialize();
        void attachView(View view);
        public void attachController(UserSelectComponent userSelectComponent);
    }
}
