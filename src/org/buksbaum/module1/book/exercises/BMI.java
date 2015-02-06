package org.buksbaum.module1.book.exercises;

/**
 * BMI class to implement BMI calculations
 * Based on Listing 10.4 - BMI.Java code on Page 371 of Introduction to Java Programming 10th Edition
 * Created by david on 2/6/2015.
 */
public class BMI
{
  private String name;
  private int age;
  private double weight;  //  in pounds
  private double height;  //  in inches
  private static final double KILOGRAMS_PER_POUND = 0.45359237;
  private static final double METERS_PER_INCH = 0.0254;
  private static final double INCHES_PER_FEET = 12;

  /**
   * Construct a BMI instance using name, age, weight, and height
   * @param name The name of the person
   * @param age The age of the person
   * @param weight The weight of the person in pounds
   * @param height The height of the person in inches
   */
  public BMI(String name, int age, double weight, double height)
  {
    this.name = name;
    this.age = age;
    this.weight = weight;
    this.height = height;
  }

  /**
   * Construct a BMI instance using name, weight, and height.
   * Will default to an age of 20 years old
   * @param name The name of the person
   * @param weight The weight of the person in pounds
   * @param height The height of the person in inches
   */
  public BMI(String name, double weight, double height)
  {
    this(name, 20, weight, height);
  }

  /**
   * Construct a BMI instance using name, age, weight, feet, and inches.
   * New constructor created because of Exercise 10.2 on Page 400.
   * @param name The name of the person
   * @param age The age of the person
   * @param weight The weight of the person in pounds
   * @param feet The foot height of the person
   * @param inches The sub-foot height in inches
   */
  public BMI(String name, int age, double weight, double feet, double inches)
  {
    this(name, age, weight, (feet * INCHES_PER_FEET) + inches);
  }

  /**
   * Construct a BMI instance using name, age, weight, feet, and inches
   * Will default to an age of 20 years old
   * New constructor created because of Exercise 10.2 on Page 400.
   * This constructor was added to provide a new variant of the age defaulting
   * variant that was already in the class.
   * @param name The name of the person
   * @param weight The weight of the person in pounds
   * @param feet The foot height of the person
   * @param inches The sub-foot height in inches
   */
  public BMI(String name, double weight, double feet, double inches)
  {
    this(name, weight, (feet * INCHES_PER_FEET) + inches);
  }

  /**
   * Calculates and returns the BMI
   * @return the BMI
   */
  public double getBMI()
  {
    double weightInKilograms = weight * KILOGRAMS_PER_POUND;
    double heightInMeters = height * METERS_PER_INCH;
    double bmi = weightInKilograms / (heightInMeters * heightInMeters);
    return Math.round(bmi * 100) / 100.0;
  }

  /**
   * Gets the BMI status as text
   * @return the BMI status
   */
  public String getStatus()
  {
    double bmi = getBMI();
    if (bmi < 18.5)
      return "Underweight";
    else if (bmi < 25)
      return "Normal";
    else if (bmi < 25)
      return "Overweight";
    else
      return "Obese";
  }

  /**
   * The name of the person
   * @return Name of the person
   */
  public String getName()
  {
    return name;
  }

  /**
   * The age of the person
   * @return Age of the person
   */
  public int getAge()
  {
    return age;
  }

  /**
   * The weight of the person in pounds
   * @return Weight of the person
   */
  public double getWeight()
  {
    return weight;
  }

  /**
   * The height of the person in inches
   * @return Height of the person
   */
  public double getHeight()
  {
    return height;
  }
}
