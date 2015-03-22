package org.buksbaum.module7.factory;

/**
 * Created by david on 3/22/2015.
 */
public class ClamPizza extends Pizza {
  public ClamPizza() {
    name = "Clam Pizza";
    dough = "Thin crust";
    sauce = "White garlic sauce";
    toppings.add("Clams");
    toppings.add("Grated parmesan cheese");
  }
}
