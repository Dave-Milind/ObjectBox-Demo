package com.milind.testassignment;

import com.milind.testassignment.Data.VoteCounter;
import com.milind.testassignment.Search.SearchModule;

import dagger.Component;
import io.objectbox.Box;
import io.objectbox.BoxStore;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {

BoxStore getBoxStore();
Box<VoteCounter>getVotesBox();
VoteCounter getVotecounter();
}
