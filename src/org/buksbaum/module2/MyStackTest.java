package org.buksbaum.module2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by david on 2/16/2015.
 */
public class MyStackTest
{
  @Test
  public void TestMyStackCoreFunctionalityWorks()
  { //  create the stack
    MyStack stack = new MyStack();

    //  assert that it created as expected - and is empty
    assertNotNull(stack);
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.getSize());

    //  push some items
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    //  confirm push worked
    assertFalse(stack.isEmpty());
    assertEquals(4, stack.getSize());

    //  confirm the value of last push
    assertEquals(4, stack.peek());

    //  and confirm peek did not change the size
    assertEquals(4, stack.getSize());

    //  confirm pop
    assertEquals(4, stack.pop());

    //  and confirm pop did change the size
    assertEquals(3, stack.getSize());

    //  pop until empty
    while(!stack.isEmpty())
      stack.pop();

    //  confirm stack is empty
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.getSize());
  }

  @Test
  public void TestMyStackShallowCopy()
  { //  create our stack
    MyStack stack = new MyStack();

    //  assert that it created as expected - and is empty
    assertNotNull(stack);
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.getSize());

    //  create a shallow copy of the empty stack
    MyStack shallowStack = stack;

    //  assert that the shallow stack is empty
    assertNotNull(shallowStack);
    assertTrue(shallowStack.isEmpty());
    assertEquals(0, shallowStack.getSize());

    //  assert that stack is the same instance of shallowStack
    assertSame(stack, shallowStack);

    //  now add some items to stack
    stack.push(1);
    stack.push(2);
    stack.push(3);

    //  prove that stack has been modified
    assertFalse(stack.isEmpty());
    assertEquals(3, stack.getSize());

    //  prove that shallowStack has been modified
    assertFalse(shallowStack.isEmpty());
    assertEquals(3, shallowStack.getSize());

    //  now add some items to shallowStack
    shallowStack.push(4);
    shallowStack.push(5);
    shallowStack.push(6);

    //  prove that shallowStack has been modified
    assertFalse(shallowStack.isEmpty());
    assertEquals(6, shallowStack.getSize());

    //  prove that stack has been modified
    assertFalse(stack.isEmpty());
    assertEquals(6, stack.getSize());
  }

  @Test
  public void TestMyStackDeepCopy() throws CloneNotSupportedException
  { //  create our stack
    MyStack stack = new MyStack();

    //  assert that it created as expected - and is empty
    assertNotNull(stack);
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.getSize());

    //  create a deep copy of the empty stack
    MyStack deepStack1 = (MyStack)stack.clone();

    //  assert that the shallow stack is empty
    assertNotNull(deepStack1);
    assertTrue(deepStack1.isEmpty());
    assertEquals(0, deepStack1.getSize());

    //  assert that stack is the same instance of shallowStack
    assertNotSame(stack, deepStack1);

    //  now add some items to stack
    stack.push(1);
    stack.push(2);
    stack.push(3);

    //  prove that stack has been modified
    assertFalse(stack.isEmpty());
    assertEquals(3, stack.getSize());

    //  prove that deepStack1 has not been modified
    assertTrue(deepStack1.isEmpty());
    assertEquals(0, deepStack1.getSize());

    //  now add some items to deepStack1
    deepStack1.push(4);
    deepStack1.push(5);
    deepStack1.push(6);

    //  prove that deepStack1 has been modified
    assertFalse(deepStack1.isEmpty());
    assertEquals(3, deepStack1.getSize());

    //  prove that stack has not been modified
    assertFalse(stack.isEmpty());
    assertEquals(3, stack.getSize());
  }
}
