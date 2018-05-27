package com.milind.testassignment.UserSelected;

import android.content.Context;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;

import dagger.Module;
import dagger.Provides;

@Module
public class UserSelectModule {

    Context context;

  public   UserSelectModule(Context context) {

        this.context = context;
    }

    @Provides
    SimpleExoPlayer getSimpleExoplayer(Context context) {

        return ExoPlayerFactory.newSimpleInstance(
                new DefaultRenderersFactory(context),
                new DefaultTrackSelector(), new DefaultLoadControl());
    }

    @Provides
    Context getContext() {

        return context;
    }
}
