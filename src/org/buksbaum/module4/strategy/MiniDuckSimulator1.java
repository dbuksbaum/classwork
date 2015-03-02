package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class MiniDuckSimulator1 {

  public static void main(String[] args) {

    Duck mallard = new MallardDuck();
    mallard.performQuack();
    mallard.performFly();

    Duck model = new ModelDuck();
    model.performFly();
    model.setFlyBehavior(new FlyRocketPowered());
    model.performFly();

  }
}

