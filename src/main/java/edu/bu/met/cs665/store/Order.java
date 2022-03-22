package edu.bu.met.cs665.store;

import edu.bu.met.cs665.beverages.Beverage;
import edu.bu.met.cs665.beverages.CondimentException;
import edu.bu.met.cs665.beverages.HotBeverage;

/**
 * The purpose of this class is to allow the customer to
 * customize a beverage for brewing by a barista.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class Order {

  private HotBeverage beverage;

  private boolean isReady = false;

  public Order(HotBeverage beverage) {
    setBeverage(beverage);
  }

  /**
   * The purpose of this constructor is to order a beverage with a single condiment.
   */
  public Order(HotBeverage beverage, String condiment, int condimentUnits)
      throws CondimentException {
    try {
      beverage.addCondiment(condiment, condimentUnits);
      setBeverage(beverage);
    } catch (CondimentException e) {
      System.out.println(e);
    }
  }

  /**
   * The purpose of this constructor is to order a beverage with a single condiment.
   */
  public Order(HotBeverage beverage, String condiment1, int condimentUnits1,
               String condiment2, int condimentUnits2) throws CondimentException {
    try {
      beverage.addCondiment(condiment1, condimentUnits1);
      beverage.addCondiment(condiment2, condimentUnits2);
      //this.beverage = (HotBeverage) beverage.copyBeverage(beverage);
      setBeverage(beverage);
    } catch (CondimentException e) {
      System.out.println(e);
    }
  }

  public HotBeverage getBeverage() {
    return beverage;
  }

  public boolean getStatus() {
    return isReady;
  }

  public void setStatus(boolean status) {
    this.isReady = status;
  }

  public void setBeverage(HotBeverage beverage) {
    this.beverage = beverage;
  }
}
