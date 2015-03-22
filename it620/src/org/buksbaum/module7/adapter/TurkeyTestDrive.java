package org.buksbaum.module7.adapter;

/**
 * Created by david on 3/21/2015.
 */
public class TurkeyTestDrive {
  public static void main(String[] args) {
    MallardDuck duck = new MallardDuck();
    Turkey duckAdapter = new DuckAdapter(duck);

    for(int i=0;i<10;i++) {
      System.out.println("The DuckAdapter says...");
      duckAdapter.gobble();
      duckAdapter.fly();
    }
  }
}

