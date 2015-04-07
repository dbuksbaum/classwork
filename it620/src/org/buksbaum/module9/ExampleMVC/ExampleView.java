package org.buksbaum.module9.ExampleMVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by david on 4/5/2015.
 */
public class ExampleView extends JPanel implements ExampleInterface {
  //private static final long serialVersionUID = 1L;
  private static final String SHOW_BUTTON = "Show";
  private static final String EXIT_BUTTON = "Exit";
  //  save button text
  private static final String SAVE_BUTTON = "Save to Database";
  private static final String STUDENT_FIRST_NAME = "First Name  ";
  private static final String STUDENT_LAST_NAME = "Last Name  ";
  private static final String STUDENT_COURSE = "Course  ";
  private static final String STUDENT_ID = "Id  ";
  private static final int FNAME_COL_WIDTH = 30;
  private static final int LNAME_COL_WIDTH = 50;
  private static final int COURSE_COL_WIDTH = 35;
  private static final int ID_COL_WIDTH = 20;
  private ExampleController controller;
  private JLabel firstNameLabel, lastNameLabel, courseLabel, idLabel;
  private JTextField firstName, lastName, course, id;
  private JButton display, exit;
  //  the save record button
  private JButton saveRecord;

  public ExampleView(ExampleModel model) {
    controller = new ExampleController(model, this);
    createGui();
  }

  public ExampleView(ExampleModel model, ExampleController newController) {
    controller = newController;
    createGui();
  }

  public void createGui() {
    display = new JButton(SHOW_BUTTON);
    exit = new JButton(EXIT_BUTTON);
    //  create our new save button
    saveRecord = new JButton(SAVE_BUTTON);

    firstNameLabel = new JLabel(STUDENT_FIRST_NAME);
    lastNameLabel = new JLabel(STUDENT_LAST_NAME);
    courseLabel = new JLabel(STUDENT_COURSE);
    idLabel = new JLabel(STUDENT_ID);

    firstName = new JTextField(FNAME_COL_WIDTH);
    lastName = new JTextField(LNAME_COL_WIDTH);
    course = new JTextField(COURSE_COL_WIDTH);
    id = new JTextField(ID_COL_WIDTH);

    JPanel editPanel = new JPanel();
    editPanel.setLayout(new BoxLayout(editPanel, BoxLayout.X_AXIS));

    JPanel labelPanel = new JPanel();
    labelPanel.setLayout(new GridLayout(0, 1));

    labelPanel.add(firstNameLabel);
    labelPanel.add(lastNameLabel);
    labelPanel.add(courseLabel);
    labelPanel.add(idLabel);

    editPanel.add(labelPanel);

    JPanel fieldPanel = new JPanel();
    fieldPanel.setLayout(new GridLayout(0, 1));

    fieldPanel.add(firstName);
    fieldPanel.add(lastName);
    fieldPanel.add(course);
    fieldPanel.add(id);

    editPanel.add(fieldPanel);

    JPanel controlPanel = new JPanel();
    controlPanel.add(display);
    //  add the save button between display and exit
    controlPanel.add(saveRecord);
    controlPanel.add(exit);
    display.addActionListener(controller);
    exit.addActionListener(new ExitHandler());
    //  wire up the save button to the controller
    saveRecord.addActionListener(controller);

    setLayout(new BorderLayout());
    add(editPanel, BorderLayout.CENTER);
    add(controlPanel, BorderLayout.SOUTH);
  }

  public Object getUpdateRef() {
    return display;
  }

  public String getFirstName() {
    return firstName.getText();
  }

  public String getLastName() {
    return lastName.getText();
  }

  public String getCourse() {
    return course.getText();
  }

  public String getId() {
    return id.getText();
  }

  public void refresh(String newFirstName, String newLastName,
                      String newCourse, String newID) {
    firstName.setText(newFirstName);
    lastName.setText(newLastName);
    course.setText(newCourse);
    id.setText(newID);
  }

  /**
   * Get a reference to the save record button
   * @return referece to the save record button
   */
  public Object getSaveRef()
  {
    return saveRecord;
  }

  private class ExitHandler implements ActionListener
  {
    public void actionPerformed(ActionEvent event) {
      System.exit(0);
    }
  }

  /**
   * This is not the method you are looking for. Move along.
   * @param history there is no history here. only the future!
   */
  public void setHistoryList(String[] history)
  { //  nothing to do, so just ignore it
  }
}
