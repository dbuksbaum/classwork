package org.buksbaum.module9.ExampleMVC;

import javax.swing.*;
import java.awt.*;

/**
 * Created by david on 4/5/2015.
 */
public class ExampleDisplayView extends JPanel implements ExampleInterface {
  private static final String LOADALL_BUTTON = "Show All Students";
  private JTextArea exampleDetail;
  private JButton loadAllRecords;
  private JList allStudentsList;
  private ExampleDisplayController controller;

  /**
   * Constuct the view using the model
   * @param model the model to bind to
   */
  public ExampleDisplayView(ExampleModel model)
  { //  create a controller that binds the model & view
    controller = new ExampleDisplayController (model, this);
    createGui();
  }

  public void createGui() {
    setLayout(new BorderLayout());
    exampleDetail = new JTextArea(10, 40);
    exampleDetail.setEditable(false);
    JScrollPane scrollDisplay = new JScrollPane(exampleDetail);
    this.add(scrollDisplay, BorderLayout.CENTER);

    //  we create a new panel to house our new magic
    JPanel allRecordsPanel = new JPanel();
    //  make sure the panel is using a border layout
    allRecordsPanel.setLayout(new BorderLayout());
    //  create our new button
    loadAllRecords = new JButton(LOADALL_BUTTON);
    //  marry our button to the controller
    loadAllRecords.addActionListener(controller);
    //  add the button to the panel
    allRecordsPanel.add(loadAllRecords, BorderLayout.NORTH);

    //  create the history list
    allStudentsList = new JList();
    //  add the history list to the panel
    allRecordsPanel.add(allStudentsList, BorderLayout.CENTER);

    //  add our new panel after the original content
    this.add(allRecordsPanel, BorderLayout.AFTER_LAST_LINE);
  }

  public void refresh(String newFirstName, String newLastName,
                      String newCourse, String newId) {
    exampleDetail.setText("\n\tStudent Information\n\t" + "\tName: "
                                  + newFirstName + "\n\t\tLast Name: " + newLastName + "\n"
                                  + "\t\tCourse: " + newCourse + "\n" + "\t\tId: "
                                  + newId);
  }

  /**
   * Show the history to the world
   * @param history student history
   */
  public void setHistoryList(String[] history)
  { //  update the student list
    allStudentsList.setListData(history);
  }

  public Object getLoadRef()
  {
    return loadAllRecords;
  }
}
