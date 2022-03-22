package edu.bu.met.cs665.beverages;

/**
 * The purpose of this class is to throw an exception if a condiment
 * cannot be added to a beverage.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class CondimentException extends Exception {

  public CondimentException(String s) {
    super(s);
  }
}
