package org.buksbaum.module8.DinerMerger;

/**
 * Created by david on 3/31/2015.
 */
public class ArrayIterator implements Iterator {
  MenuItem[] items;
  int position = 0;

  public ArrayIterator(MenuItem[] items) {
    this.items = items;
  }

  public Object next() {
    MenuItem menuItem = items[position];
    position = position + 1;
    return menuItem;
  }

  public boolean hasNext() {
    if (position >= items.length || items[position] == null) {
      return false;
    } else {
      return true;
    }
  }
}

