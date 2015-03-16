package org.buksbaum.module6.Calculator;

/*
 * Created on Dec 6, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author donn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/**
 * Created by david on 3/16/2015.
 */
public class Calculator extends Applet implements ActionListener {

  /** Initialization method that will be called after the applet is loaded
   *  into the browser.
   */
  public void init() {
    backgroundColor = new Color(200,255,255);
    this.setLayout(new FlowLayout(FlowLayout.CENTER,4,1));
    result = new Label(initialString, Label.RIGHT);
    result.setBackground(new Color(255,255,255));
    add(result);
    makeButtons();

    row1 = makePanel(new FlowLayout(FlowLayout.LEFT,4,2), backgroundColor);
    row1.add(c);
    row1.add(eq);
    row1.add(div);
    row1.add(times);

    row2 = makePanel(new FlowLayout(FlowLayout.LEFT,4,2), backgroundColor);
    row2.add(d7);
    row2.add(d8);
    row2.add(d9);
    row2.add(minus);

    row3 = makePanel(new FlowLayout(FlowLayout.LEFT,4,2), backgroundColor);
    row3.add(d4);
    row3.add(d5);
    row3.add(d6);
    row3.add(plus);

    add(row1);
    add(row2);
    add(row3);

    p12 = makePanel(new BorderLayout(2,2), backgroundColor);
    p12.add("West", d1);
    p12.add("East", d2);

    p120 = makePanel(new BorderLayout(2,2), backgroundColor);
    p120.add("North", p12);
    p120.add("South", d0);

    p3p = makePanel(new BorderLayout(2,2), backgroundColor);
    p3p.add("North", d3);
    p3p.add("South", dp);

    p3peq = makePanel(new BorderLayout(2,2), backgroundColor);
    p3peq.add("West", p3p);
    p3peq.add("East", eq2);

    add(p120);
    add(p3peq);

    setBackground(backgroundColor);

    c.addActionListener(this);
    eq.addActionListener(this);
    eq2.addActionListener(this);
    div.addActionListener(this);
    times.addActionListener(this);
    minus.addActionListener(this);
    plus.addActionListener(this);
    d0.addActionListener(this);
    d1.addActionListener(this);
    d2.addActionListener(this);
    d3.addActionListener(this);
    d4.addActionListener(this);
    d5.addActionListener(this);
    d6.addActionListener(this);
    d7.addActionListener(this);
    d8.addActionListener(this);
    d9.addActionListener(this);

    clearCalc();
  }

  public void start() {
    appletWidth = 8 * 4 + row1.getSize().width;
    appletHeight = 8 * (2 + d1.getSize().height);
  }

  public void paint(Graphics g) {
    setSize(appletWidth, appletHeight);
    validate();
  }

  public void actionPerformed(ActionEvent e) {
    String s = (String)e.getActionCommand();

    if(digits.indexOf(s) != -1)
      handleDigit(s);
    else if(s.equals("."))
      handleDecimal();
    else if(operators.indexOf(s) != -1)
      handleOperator(s);
    else if(s.equals("C"))
      handleClear();
  }

  private void handleDigit(String s) {
    if(newOpd) {
      result.setText(s);
      newOpd  = false;
    }
    else
      result.setText(result.getText() + s);
    sawAnOpd = true;
  }

  private void handleClear() {
    clearCalc();
  }

  private void clearCalc() {
    sawDecimal = false;
    newOpd = true;
    sawAnOpd = false;
    lastOptr = "";
    result.setText(initialString);
  }

  private void handleOperator(String s) {
    if(!sawAnOpd)
      return;
    if(lastOptr.equals("+"))
      opd1 += getDisplay();
    else if(lastOptr.equals("-"))
      opd1 -= getDisplay();
    else if(lastOptr.equals("*"))
      opd1 *= getDisplay();
    else if(lastOptr.equals("/"))
      opd1 /= getDisplay();
    else
      opd1 = getDisplay();

    result.setText(opd1 + "");

    lastOptr = s;
    sawDecimal  = false;
    newOpd = true;
  }

  private void handleDecimal() {
    if(!sawDecimal) {
      if(newOpd) {
        result.setText("0.");
        newOpd = false;
      }
      else
        result.setText(result.getText() + ".");
      sawDecimal = true;
    }
  }

  private double getDisplay() {
    return Double.valueOf(result.getText()).doubleValue();
  }

  private Button makeButton(String label, Color color, Font font) {
    Button b = new Button(label);
    b.setBackground(color);
    b.setFont(font);
    return b;
  }

  private Panel makePanel(LayoutManager lm, Color c) {
    Panel p = new Panel();
    p.setLayout(lm);
    p.setBackground(c);
    return p;
  }

  private void makeButtons() {
    Font f = new Font("Courier", Font.BOLD, 10);
    Color lightRed = new Color(255, 100, 100);
    Color lightBlue = new Color(100, 100, 255);
    Color yellow = new Color(255, 255, 0);

    c = makeButton("C", lightRed, f);
    eq = makeButton("=", lightBlue, f);
    div = makeButton("/", lightBlue, f);
    times = makeButton("*", lightRed, f);
    d7 = makeButton("7", yellow, f);
    d8 = makeButton("8", yellow, f);
    d9 = makeButton("9", yellow, f);
    minus = makeButton("-", lightBlue, f);
    d4 = makeButton("4", yellow, f);
    d5 = makeButton("5", yellow, f);
    d6 = makeButton("6", yellow, f);
    plus = makeButton("+", lightBlue, f);
    d1 = makeButton("1", yellow, f);
    d2 = makeButton("2", yellow, f);
    d3 = makeButton("3", yellow, f);
    d0 = makeButton("0", yellow, f);
    dp = makeButton(".", yellow, f);
    eq2 = makeButton("=", lightBlue, f);
  }

  static final String initialString = "0.00000";
  static final String digits = "0123456789";
  static final String operators = "+-*/=";
  private String lastOptr;
  private String filler = "         ";
  private boolean sawDecimal, newOpd, sawAnOpd;
  private double opd1;

  private Panel row1, row2, row3, p12, p120, p3p, p3peq;
  private int appletWidth, appletHeight;

  private Button  c,  eq, div,   times,
          d7,  d8,  d9,   minus,
          d4,  d5,  d6,   plus,
          d1,  d2,  d3,
          d0,       dp,   eq2;

  private Color backgroundColor;
  private Label result;
}

