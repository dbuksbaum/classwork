package org.buksbaum.module9.ExampleMVC;

/**
 * Created by david on 4/5/2015.
 */
public class ExampleData {
  private String firstName;
  private String lastName;
  private String course;
  private String id;

  private ExampleInterface view;

  public ExampleData(ExampleInterface newView) {

    firstName = "";
    lastName = "";
    course = "";
    id = "";

    view = newView;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public String getId() {
    return id;
  }

  public void setId(String newId) {
    this.id = newId;
  }

  public ExampleInterface getView() {
    return view;
  }

  public void setView(ExampleInterface view) {
    this.view = view;
  }
}
