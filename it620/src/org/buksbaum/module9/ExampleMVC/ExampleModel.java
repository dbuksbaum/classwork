package org.buksbaum.module9.ExampleMVC;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by david on 4/5/2015.
 */
public class ExampleModel {
  private String firstName;
  private String lastName;
  private String course;
  private String id;
  private ArrayList exampleViews = new ArrayList();

  public ExampleModel() {
    this(null);
  }

  public ExampleModel(ExampleInterface view) {
    firstName = "";
    lastName = "";
    course = "";
    id = "";
    if (view != null) {
      exampleViews.add(view);
    }
  }

  public void addContactView(ExampleInterface view) {
    if (!exampleViews.contains(view)) {
      exampleViews.add(view);
    }
  }

  public void removeContactView(ExampleInterface view) {
    exampleViews.remove(view);
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTitle() {
    return course;
  }

  public String getId() {
    return id;
  }

  public void setFirstName(String newFirstName) {
    firstName = newFirstName;
  }

  public void setLastName(String newLastName) {
    lastName = newLastName;
  }

  public void setCourse(String newCourse) {
    course = newCourse;
  }

  public void setId(String newId) {
    id = newId;
  }

  public void updateModel(String newFirstName, String newLastName,
                          String newCourse, String newId) {
    if (!isEmptyString(newFirstName)) {
      setFirstName(newFirstName);
    }
    if (!isEmptyString(newLastName)) {
      setLastName(newLastName);
    }
    if (!isEmptyString(newCourse)) {
      setCourse(newCourse);
    }
    if (!isEmptyString(newId)) {
      setId(newId);
    }
    updateView();
  }

  private boolean isEmptyString(String input) {
    return ((input == null) || input.equals(""));
  }

  private void updateView() {
    Iterator notifyViews = exampleViews.iterator();
    while (notifyViews.hasNext()) {
      ((ExampleInterface) notifyViews.next()).refresh(firstName,
                                                      lastName, course, id);
    }
  }
}
