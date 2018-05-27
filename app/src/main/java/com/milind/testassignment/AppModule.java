package com.milind.testassignment;

import android.app.Application;
import android.content.Context;

import com.milind.testassignment.Data.MyObjectBox;
import com.milind.testassignment.Data.VoteCounter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import io.objectbox.BoxStore;

@Module
public class AppModule {

    Context context;

   public AppModule( Context context) {
        this.context = context;

    }

    @Provides
    @AppScope
    BoxStore getBoxstore(@Named("ApplicationContext")Context context) {

        return MyObjectBox.builder()
                .androidContext(context).build();
    }

    @Provides
    @AppScope
    @Named("ApplicationContext")
    Context getApplicationContext() {

        return context;
    }

    @Provides
    @AppScope
    Box<VoteCounter>getVotesBox(BoxStore boxStore){

        return boxStore.boxFor(VoteCounter.class);
    }

    @Provides
    @AppScope
    VoteCounter getVoteCounter(){

        return new VoteCounter();
    }

}
