package org.buksbaum.module8.Composite.MenuIterator;

import java.util.Iterator;

/**
 * Created by david on 3/31/2015.
 */
public abstract class MenuComponent {

  public void add(MenuComponent menuComponent) {
    throw new UnsupportedOperationException();
  }
  public void remove(MenuComponent menuComponent) {
    throw new UnsupportedOperationException();
  }
  public MenuComponent getChild(int i) {
    throw new UnsupportedOperationException();
  }

  public String getName() {
    throw new UnsupportedOperationException();
  }
  public String getDescription() {
    throw new UnsupportedOperationException();
  }
  public double getPrice() {
    throw new UnsupportedOperationException();
  }
  public boolean isVegetarian() {
    throw new UnsupportedOperationException();
  }

  public abstract Iterator createIterator();

  public void print() {
    throw new UnsupportedOperationException();
  }
}
//^^ MenuItemCompositeV2Main
//^^ MenuItemCompositeV2
