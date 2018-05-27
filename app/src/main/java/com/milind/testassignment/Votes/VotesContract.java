package com.milind.testassignment.Votes;

import com.milind.testassignment.Base.BasePresenter;
import com.milind.testassignment.Base.BaseView;

public interface VotesContract {

    interface View extends BaseView{

        void setUpvotes(int upvotes);
        void setDownvotes(int downvotes);
    }

    interface  Presenter extends BasePresenter{

        void initialize();
        void attach(View view);
    }

}
