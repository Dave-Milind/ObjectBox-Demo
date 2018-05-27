package com.milind.testassignment.UserSelected;

import android.util.Log;

import com.milind.testassignment.App;
import com.milind.testassignment.Data.VoteCounter;

import io.objectbox.Box;

public class UserSelectPresenter implements UserSelectContract.Presenter {

final String TAG="USPTAG";
    UserSelectContract.View view;
    UserSelectComponent userSelectComponent;
    Box<VoteCounter> box= App.appComponent.getVotesBox();
    VoteCounter voteCounter=App.appComponent.getVotecounter();
    @Override
    public void onUpVoteClick() {

        Log.e(TAG,box.hashCode()+" box hashcode");
        if( voteCounter.id==100){
            voteCounter.upVotes++;
            long id=box.put(voteCounter);
            Log.i(TAG,"votecounter object id: "+id);
            view.ShowToast("You made an upvote");

        }
        }

    @Override
    public void onDownVoteClick() {

       if( voteCounter.id==100){
           voteCounter.downVotes++;
           long id=box.put(voteCounter);
           Log.i(TAG,"votecounter object id: "+id);
           Log.e(TAG,box.hashCode()+" box hashcode");
           view.ShowToast("You made a DownVote");
       }

    }

    @Override
    public void initialize() {
        view.setUpExoplayer();
    }

    @Override
    public void attachView(UserSelectContract.View view) {
        this.view = view;
    }

    public void attachController(UserSelectComponent userSelectComponent) {
        this.userSelectComponent = userSelectComponent;
    }


}
