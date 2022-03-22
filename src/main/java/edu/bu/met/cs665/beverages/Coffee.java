package edu.bu.met.cs665.beverages;

/**
 * The purpose of this class is to provide a subclass of HotBeverage for coffee.
 * Different coffee types are denoted by condiments (i.e. espresso has no milk,
 * cappuccino is an espresso with milk.)
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class Coffee extends HotBeverage {

  private int grindSize; // courseness of grind
  private String agitation; // pour type
  private String type; // tells VendBev Barista ingredients to add (i.e. cappuccino)

  // getters
  public int getGrindSize() {
    return grindSize;
  }

  public String getAgitation() {
    return agitation; // pour type
  }

  public String getType() {
    return type; // i.e. cappuccino, espresso etc.
  }

  // setters
  public void setGrindSize(int grindSize) {
    this.grindSize = grindSize;
  }

  public void setAgitation(String agitation) {
    this.agitation = agitation;
  }

  public void setType(String type) {
    this.type = type;
  }
}
