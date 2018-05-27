package com.milind.testassignment.UserSelected;

import com.google.android.exoplayer2.SimpleExoPlayer;

import dagger.Component;

@Component (modules = UserSelectModule.class)
public interface UserSelectComponent {

SimpleExoPlayer getSimpleExoPlayer();

}
