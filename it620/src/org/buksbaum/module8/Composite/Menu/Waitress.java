package org.buksbaum.module8.Composite.Menu;

/**
 * Created by david on 3/31/2015.
 */
public class Waitress {
  MenuComponent allMenus;

  public Waitress(MenuComponent allMenus) {
    this.allMenus = allMenus;
  }

  public void printMenu() {
    allMenus.print();
  }
}
