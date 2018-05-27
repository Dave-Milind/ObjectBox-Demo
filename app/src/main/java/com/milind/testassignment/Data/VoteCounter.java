package com.milind.testassignment.Data;

import javax.inject.Inject;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity

public class VoteCounter {

    @Id(assignable = true)
   public   long id=100;
   public   int upVotes=0;
   public int downVotes=0;

  @Inject
  public VoteCounter(){}

}
