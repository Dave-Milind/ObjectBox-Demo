package com.milind.testassignment.Votes;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluelinelabs.conductor.Controller;
import com.milind.testassignment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VotesController extends Controller implements VotesContract.View {


    @BindView(R.id.tv_upvotes)
    TextView tvUpvotes;
    @BindView(R.id.tv_downvotes)
    TextView tvDownvotes;
  VotesPresenter presenter;
  Unbinder unbinder;

  public VotesController(Bundle args){

  }
    public VotesController(){

    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View root = inflater.inflate(R.layout.voteslayout, container, false);
        unbinder= ButterKnife.bind(this,root);
presenter=new VotesPresenter();
presenter.attach(this);
presenter.initialize();

        return root;
    }


    @Override
    public void setUpvotes(int upvotes) {
tvUpvotes.setText("The total number of Upvotes are "+upvotes);
    }

    @Override
    public void setDownvotes(int downvotes) {
        tvDownvotes.setText("The total number of Downvotes are "+downvotes);
    }
}
