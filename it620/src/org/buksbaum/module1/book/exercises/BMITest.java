package org.buksbaum.module1.book.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the BMI class
 */
public class BMITest
{
  private static final String PERSON_1_NAME = "Kim Yang";
  private static final String PERSON_2_NAME = "Susan King";
  private static final int PERSON_1_AGE = 18;
  private static final double PERSON_1_WEIGHT = 145;
  private static final double PERSON_2_WEIGHT = 215;
  private static final double HEIGHT = 70;
  private static final double HEIGHT_IN_FEET = Math.abs(HEIGHT / 12);
  private static final double HEIGHT_REMAINING_INCHES = HEIGHT - (HEIGHT_IN_FEET * 12);

  /**
   * Tests the BMI class using the values supplied in the text book (p. 371)
   * Listing 10.3 using the 2 constructors defined in the book and demonstrated
   * in the Listing.
   */
  @Test
  public void TestConstructorInInchesWorks()
  { //  create our test objects
    BMI bmi1 = new BMI(PERSON_1_NAME, PERSON_1_AGE, PERSON_1_WEIGHT, HEIGHT);
    BMI bmi2 = new BMI(PERSON_2_NAME, PERSON_2_WEIGHT, HEIGHT);

    //  make sure the test objects are not null
    assertNotNull(bmi1);
    assertNotNull(bmi2);

    //  make sure both objects are not the same instance
    assertNotSame(bmi1, bmi2);

    //  make sure that BMI1 has the right values
    assertEquals(PERSON_1_NAME, bmi1.getName());
    assertEquals(PERSON_1_AGE, bmi1.getAge());
    assertEquals(PERSON_1_WEIGHT, bmi1.getWeight(), 0.0);
    assertEquals(HEIGHT, bmi1.getHeight(), 0.0);

    //  make sure that BMI2 has the right values
    assertEquals(PERSON_2_NAME, bmi2.getName());
    assertEquals(20, bmi2.getAge());  //  20 is the default age
    assertEquals(PERSON_2_WEIGHT, bmi2.getWeight(), 0.0);
    assertEquals(HEIGHT, bmi2.getHeight(), 0.0);

    //  make sure the BMI is correct
    assertEquals(20.81, bmi1.getBMI(), 0.00);
    assertEquals(30.85, bmi2.getBMI(), 0.00);

    //  make sure the BMI status is correct
    assertEquals("Normal", bmi1.getStatus());
    assertEquals("Obese", bmi2.getStatus());
  }

  /**
   * Tests the BMI class using the values supplied in the text book (p. 371)
   * Listing 10.3 using the 2 new constructors created because of Exercise 10.2 on
   * Page 400.
   */
  @Test
  public void TestConstructorInFeetAndInchesWorks()
  { //  create our test objects
    BMI bmi1 = new BMI(PERSON_1_NAME, PERSON_1_AGE, PERSON_1_WEIGHT, HEIGHT_IN_FEET, HEIGHT_REMAINING_INCHES);
    BMI bmi2 = new BMI(PERSON_2_NAME, PERSON_2_WEIGHT, HEIGHT_IN_FEET, HEIGHT_REMAINING_INCHES);

    //  make sure the test objects are not null
    assertNotNull(bmi1);
    assertNotNull(bmi2);

    //  make sure both objects are not the same instance
    assertNotSame(bmi1, bmi2);

    //  make sure that BMI1 has the right values
    assertEquals(PERSON_1_NAME, bmi1.getName());
    assertEquals(PERSON_1_AGE, bmi1.getAge());
    assertEquals(PERSON_1_WEIGHT, bmi1.getWeight(), 0.0);
    assertEquals(HEIGHT, bmi1.getHeight(), 0.0);

    //  make sure that BMI2 has the right values
    assertEquals(PERSON_2_NAME, bmi2.getName());
    assertEquals(20, bmi2.getAge());  //  20 is the default age
    assertEquals(PERSON_2_WEIGHT, bmi2.getWeight(), 0.0);
    assertEquals(HEIGHT, bmi2.getHeight(), 0.0);

    //  make sure the BMI is correct
    assertEquals(20.81, bmi1.getBMI(), 0.00);
    assertEquals(30.85, bmi2.getBMI(), 0.00);

    //  make sure the BMI status is correct
    assertEquals("Normal", bmi1.getStatus());
    assertEquals("Obese", bmi2.getStatus());
  }
}