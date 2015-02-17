package org.buksbaum.module2;

import java.util.ArrayList;

/**
 * Created by david on 2/16/2015.
 * DTB: Exercise 13.8: (Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to perform a deep copy of the list field.
 *
 * MyStack class implementing a stack using and ArrayList
 */
public class MyStack implements Cloneable
{
  /**
   * the list of items in my stack
   */
  private ArrayList<Object> list = new ArrayList<>();

  /**
   * Is the stack empty
   * @return true if empty, false if not empty
   */
  public boolean isEmpty()
  {
    return list.isEmpty();
  }

  /**
   * The number of items in the stack
   * @return number of items in the stack
   */
  public int getSize()
  {
    return list.size();
  }

  /**
   * Peeks at the top of the stack without removing it
   * @return the item at the top of the stack
   */
  public Object peek()
  {
    return list.get(getSize() - 1);
  }

  /**
   * Pops the top most item off the stack. This reduces the
   * items on the stack by 1
   * @return object at top of the stack
   */
  public Object pop()
  {
    Object o = list.get(getSize() - 1);
    list.remove(getSize() - 1);
    return o;
  }

  /**
   * Pushes a new item on top of the stack
   * @param o the new item to be put onto the stack
   */
  public void push(Object o)
  {
    list.add(o);
  }

  /**
   * Override of the Object.toString() method
   * @return string value about this object
   */
  @Override
  public String toString()
  {
    return "stack: " + list.toString();
  }

  /**
   * Override of the Object.clone() method to increase visibility (protected to public)
   * and to perform a deep copy of the stack.
   * NOTE: this does not do a deep copy of the contents of the stack
   * @return a new stack instance containing the same elements
   * @throws CloneNotSupportedException
   */
  @Override
  protected Object clone() throws CloneNotSupportedException
  {
    MyStack deepCopy = new MyStack();

    //  deep copy of the list, but not the elements
    deepCopy.list = (ArrayList<Object>)list.clone();
    // this is the same as: deepCopy.list.addAll(list);

    //  deep copy of the list: loop through all items, cloning each item
    //  NOTE: this needs each item to implemented clone()
    //for(Object item: list)
    //  deepCopy.list.add(item.clone());

    return deepCopy;
  }
}
