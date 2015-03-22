package org.buksbaum.module7.factory;

/**
 * Created by david on 3/22/2015.
 */
public class CheesePizza extends Pizza {
  public CheesePizza() {
    name = "Cheese Pizza";
    dough = "Regular Crust";
    sauce = "Marinara Pizza Sauce";
    toppings.add("Fresh Mozzarella");
    toppings.add("Parmesan");
  }
}
