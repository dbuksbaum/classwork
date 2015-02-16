package org.buksbaum.module2;

import java.util.ArrayList;

/**
 * Created by david on 2/16/2015.
 * DTB: Exercise 13.8: (Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to perform a deep copy of the list field.
 */
public class MyStack implements Cloneable
{
  private ArrayList<Object> list = new ArrayList<>();

  public boolean isEmpty()
  {
    return list.isEmpty();
  }

  public int getSize()
  {
    return list.size();
  }

  public Object peek()
  {
    return list.get(getSize() - 1);
  }

  public Object pop()
  {
    Object o = list.get(getSize() - 1);
    list.remove(getSize() - 1);
    return o;
  }

  public void push(Object o)
  {
    list.add(o);
  }

  @Override
  public String toString()
  {
    return "stack: " + list.toString();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException
  {
    MyStack deepCopy = new MyStack();

    //  deep copy of the list, but not the elements
    deepCopy.list.addAll(list);

    //  deep copy of the list: loop through all items, cloning each item
    //for(Object item: list)
    //  deepCopy.list.add(item.clone());

    return deepCopy;
  }
}
