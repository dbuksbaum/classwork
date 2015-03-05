package org.buksbaum.module4.strategy;

/**
 * Created by david on 3/2/2015.
 */
public class MiniDuckSimulator {

  public static void main(String[] args) {

    MallardDuck	mallard = new MallardDuck();
    RubberDuck	rubberDuckie = new RubberDuck();
    DecoyDuck	decoy = new DecoyDuck();

    ModelDuck	model = new ModelDuck();

    mallard.performQuack();
    rubberDuckie.performQuack();
    decoy.performQuack();

    model.performFly();
    model.setFlyBehavior(new FlyRocketPowered());
    model.performFly();
  }
}
