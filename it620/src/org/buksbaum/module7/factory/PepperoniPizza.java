package org.buksbaum.module7.factory;

/**
 * Created by david on 3/22/2015.
 */
public class PepperoniPizza extends Pizza {
  public PepperoniPizza() {
    name = "Pepperoni Pizza";
    dough = "Crust";
    sauce = "Marinara sauce";
    toppings.add("Sliced Pepperoni");
    toppings.add("Sliced Onion");
    toppings.add("Grated parmesan cheese");
  }
}
