package com.milind.testassignment.Votes;

import android.util.Log;

import com.milind.testassignment.App;
import com.milind.testassignment.Data.VoteCounter;

import io.objectbox.Box;

public class VotesPresenter implements VotesContract.Presenter {

    VotesContract.View view;

    Box<VoteCounter>box= App.appComponent.getVotesBox();

    VoteCounter voteCounter=  box.get(100);
    @Override
    public void initialize() {


       view.setUpvotes(voteCounter.upVotes);
       view.setDownvotes(voteCounter.downVotes);
    }

    @Override
    public void attach(VotesContract.View view) {
        this.view=view;
    }
}
