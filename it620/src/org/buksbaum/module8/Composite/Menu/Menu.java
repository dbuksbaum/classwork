package org.buksbaum.module8.Composite.Menu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by david on 3/31/2015.
 */
public class Menu extends MenuComponent {
  ArrayList menuComponents = new ArrayList();
  String name;
  String description;

  public Menu(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public void add(MenuComponent menuComponent) {
    menuComponents.add(menuComponent);
  }

  public void remove(MenuComponent menuComponent) {
    menuComponents.remove(menuComponent);
  }

  public MenuComponent getChild(int i) {
    return (MenuComponent)menuComponents.get(i);
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public void print() {
    System.out.print("\n" + getName());
    System.out.println(", " + getDescription());
    System.out.println("---------------------");

    Iterator iterator = menuComponents.iterator();
    while (iterator.hasNext()) {
      MenuComponent menuComponent =
              (MenuComponent)iterator.next();
      menuComponent.print();
    }
  }
}
