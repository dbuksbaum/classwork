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

  public ExampleDisplayView(ExampleModel model)
  {
    controller = new ExampleDisplayController (model, this);
    createGui();
  }

  public void createGui() {
    setLayout(new BorderLayout());
    exampleDetail = new JTextArea(10, 40);
    exampleDetail.setEditable(false);
    JScrollPane scrollDisplay = new JScrollPane(exampleDetail);
    this.add(scrollDisplay, BorderLayout.CENTER);

    JPanel allRecordsPanel = new JPanel();
    allRecordsPanel.setLayout(new BorderLayout());
    loadAllRecords = new JButton(LOADALL_BUTTON);
    loadAllRecords.addActionListener(controller);
    allRecordsPanel.add(loadAllRecords, BorderLayout.NORTH);

    allStudentsList = new JList();
    allRecordsPanel.add(allStudentsList, BorderLayout.CENTER);

    this.add(allRecordsPanel, BorderLayout.AFTER_LAST_LINE);
  }

  public void refresh(String newFirstName, String newLastName,
                      String newCourse, String newId) {
    exampleDetail.setText("\n\tStudent Information\n\t" + "\tName: "
                                  + newFirstName + "\n\t\tLast Name: " + newLastName + "\n"
                                  + "\t\tCourse: " + newCourse + "\n" + "\t\tId: "
                                  + newId);
  }

  public void setHistoryList(String[] history)
  {
    allStudentsList.setListData(history);
  }

  public Object getLoadRef()
  {
    return loadAllRecords;
  }
}
