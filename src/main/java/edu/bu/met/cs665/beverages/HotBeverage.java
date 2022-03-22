package edu.bu.met.cs665.beverages;

import edu.bu.met.cs665.store.Menu;
import java.util.Arrays;
import java.util.HashMap;

/**
 * The purpose of this class is to extend the Beverage class and provide the
 * additional functionality of adding a condiment to this hot beverage such as
 * milk or sugar (or any other).
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class HotBeverage extends Beverage {

  private HashMap<String, Integer> condiments = new HashMap<String, Integer>();

  private int condimentCount = 0; // cannot be > 6
  private int waterTemperature; // 195-205
  private int brewTime; // in seconds round up
  private String type;

  // getters
  public int getWaterTemperature() {
    return waterTemperature;
  }

  public int getBrewTime() {
    return brewTime;
  }

  // setters
  public void setWaterTemperature(int waterTemperature) {
    this.waterTemperature = waterTemperature;
  }

  public void setBrewTime(int brewTime) {
    this.brewTime = brewTime;
  }

  /**
  * The purpose of this method is to add a condiment to a hot beverage.
  * <p>Precondition: an object extending HotBeverage has been instantiated</p>
  * <p>Postcondition: the condiment along with appropriate units has been added</p>
  * @param condiment a String, flexible but examples: "milk", "sugar"
  * @param condimentUnits int between 1 and 3
  */
  public void addCondiment(String condiment, int condimentUnits) throws CondimentException {
    if (condimentUnits > 3 || condimentUnits < 1) {
      throw new CondimentException("Error: " + condiment
        + " units must be between 1 and 3");
    }
    if (condimentCount == 6) {
      throw new CondimentException("Error: cannot add " + condiment
                                     + ". Max condiments in Beverage reached.");
    }
    Menu menu = new Menu();
    boolean goodCondiment = Arrays.stream(menu.getCondiments()).anyMatch(condiment::equals)
                            || Arrays.stream(menu.getSweeteners()).anyMatch(condiment::equals);
    if (goodCondiment && condimentCount < 6) {
      this.condiments.put(condiment, condimentUnits);
      condimentCount += condimentUnits; // track condimentUnits in beverage
    }
  }

  public HashMap<String, Integer> getCondiments() {
    return (HashMap<String, Integer>) condiments.clone();
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setType(String type) {
    this.type = type;
  }
}
