package org.buksbaum.module6.starbuzz;

/**
 * Created by david on 3/16/2015.
 */
public class StarbuzzCoffee {

  public static void main(String args[]) {
    Beverage beverage = new Espresso();
    System.out.println(beverage.getDescription()
                               + " $" + beverage.cost());

    Beverage beverage2 = new DarkRoast();
    beverage2 = new Mocha(beverage2);
    beverage2 = new Mocha(beverage2);
    beverage2 = new Whip(beverage2);
    System.out.println(beverage2.getDescription()
                               + " $" + beverage2.cost());

    Beverage beverage3 = new HouseBlend();
    beverage3 = new Soy(beverage3);
    beverage3 = new Mocha(beverage3);
    beverage3 = new Whip(beverage3);
    System.out.println(beverage3.getDescription()
                               + " $" + beverage3.cost());

    //  DTB: added code here
    //  Espresso + 2 Soy + 1 Whip
    Beverage beverage4 = new Espresso();
    //  our 2 soys
    beverage4 = new Soy(beverage4);
    beverage4 = new Soy(beverage4);
    //  our 1 whip
    beverage4 = new Whip(beverage4);
    System.out.println(beverage4.getDescription() + " $" + beverage4.cost());

    //  Dark Roast + 1 Mocha + 1 Soy + 2 Whip
    Beverage beverage5 = new DarkRoast();
    //  our 1 mocha
    beverage5 = new Mocha(beverage5);
    //  our 1 soy
    beverage5 = new Soy(beverage5);
    //  our 2 whips
    beverage5 = new Whip(beverage5);
    beverage5 = new Whip(beverage5);
    System.out.println(beverage5.getDescription() + " $" + beverage5.cost());

    //  House Blend + 2 Caramels + 1 Soy + 1 Whip
    Beverage beverage6 = new HouseBlend();
    //  our 2 caramels
    beverage6 = new Caramel(beverage6);
    beverage6 = new Caramel(beverage6);
    //  our 1 soy
    beverage6 = new Soy(beverage6);
    //  our 1 whip
    beverage6 = new Whip(beverage6);
    System.out.println(beverage6.getDescription() + " $" + beverage6.cost());

    //  Dark Roast + 1 Mocha + 1 Caramels + 1 Whip
    Beverage beverage7 = new DarkRoast();
    //  our 1 mocha
    beverage7 = new Mocha(beverage7);
    //  our 1 caramel
    beverage7 = new Caramel(beverage7);
    //  our 1 whip
    beverage7 = new Whip(beverage7);
    System.out.println(beverage7.getDescription() + " $" + beverage7.cost());
  }
}
