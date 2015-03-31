package org.buksbaum.module8.Composite.MenuIterator;

import java.util.Iterator;

/**
 * Created by david on 3/31/2015.
 */
public class MenuItem extends MenuComponent {

  String name;
  String description;
  boolean vegetarian;
  double price;

  public MenuItem(String name,
                  String description,
                  boolean vegetarian,
                  double price)
  {
    this.name = name;
    this.description = description;
    this.vegetarian = vegetarian;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public double getPrice() {
    return price;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public Iterator createIterator() {
    return new NullIterator();
  }

  public void print() {
    System.out.print("  " + getName());
    if (isVegetarian()) {
      System.out.print("(v)");
    }
    System.out.println(", " + getPrice());
    System.out.println("     -- " + getDescription());
  }
//vv MenuItemCompositeV2Main
}


