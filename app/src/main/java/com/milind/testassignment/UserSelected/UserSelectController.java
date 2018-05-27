package com.milind.testassignment.UserSelected;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.bluelinelabs.conductor.Controller;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.milind.testassignment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import com.milind.testassignment.UserSelected.UserSelectPresenter;

public class UserSelectController extends Controller implements UserSelectContract.View {


    Unbinder unbinder;
    @BindView(R.id.player_view)
    PlayerView playerView;
    @BindView(R.id.btn_upvote)
    Button btnUpvote;
    @BindView(R.id.btn_downvote)
    Button btnDownvote;

    SimpleExoPlayer player;
    boolean playWhenReady = true;
    int currentWindow;
    long playbackPosition;
    private ComponentListener componentListener;
    String videoUrl;

    UserSelectComponent userSelectComponent;

    public UserSelectController(String url) {
        this.videoUrl = url;
    }

    UserSelectPresenter presenter;

    public UserSelectController(Bundle args) {

    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View root = inflater.inflate(R.layout.userselectedlayout, container, false);

        unbinder = ButterKnife.bind(this, root);
        userSelectComponent = DaggerUserSelectComponent.builder()
                .userSelectModule(new UserSelectModule(getActivity())).build();

        componentListener = new ComponentListener();
        presenter = new UserSelectPresenter();

        presenter.attachView(this);
        presenter.attachController(userSelectComponent);
        presenter.initialize();

        return root;
    }

    @OnClick({R.id.btn_upvote, R.id.btn_downvote})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_upvote:
                presenter.onUpVoteClick();
                break;
            case R.id.btn_downvote:
                presenter.onDownVoteClick();
                break;
        }
    }

    @Override
    public void setUpExoplayer() {
        player = userSelectComponent.getSimpleExoPlayer();
        player.addListener(componentListener);

        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow, playbackPosition);
        playerView.setPlayer(player);
        Uri uri = Uri.parse(videoUrl);
        MediaSource mediaSource = new ExtractorMediaSource.Factory(
                new DefaultHttpDataSourceFactory("exoplayer-codelab")).
                createMediaSource(uri);
        player.prepare(mediaSource, true, false);

    }

    @Override
    public void ShowToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


}
