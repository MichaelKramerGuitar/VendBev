package edu.bu.met.cs665.beverages;

/**
 * The purpose of this class is to extend HotBeverage with a specific type of Tea.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class Tea extends HotBeverage {

  private String type; // i.e. green, white, yellow

  // getters
  public String getType() {
    return type;
  }

  // setters
  public void setType(String type) {
    this.type = type;
  }
}
