package edu.bu.met.cs665.beverages;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertThrows;

/**
 * The purpose of this class is to test the Beverage class' non trivial methods
 * and Custom exception is appropriately thrown.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class HotBeverageTest {

  public void HotBeverageTest() {}

  /**
   * Test adding too many condiments to beverage throws CondimentException
   */
  @Test
  public void TestHotBeverageCondimentAddingTooManyUnits() {

    int upperOutOfBounds = 4;
    String condiment = "milk";
    HotBeverage bev = new HotBeverage();

    Exception e = assertThrows(CondimentException.class, () -> {
      bev.addCondiment(condiment, upperOutOfBounds);
    });

    String expectedMessage = "Error: " + condiment
      + " units must be between 1 and 3";
    String thrownMessage = e.getMessage();
    Assert.assertEquals(expectedMessage, thrownMessage);
  }

  /**
   * Test adding an illegally low number (under 1) of condiments throws
   * CondimentException.
   */
  @Test
  public void TestHotBeverageCondimentAddingInvalidUnitsLower() {
    int lowerOutOfBounds = 0;
    String condiment = "milk";
    HotBeverage bev = new HotBeverage();
    Exception e = assertThrows(CondimentException.class, () -> {
      bev.addCondiment(condiment, lowerOutOfBounds);
    });

    String expectedMessage = "Error: " + condiment
      + " units must be between 1 and 3";
    String thrownMessage = e.getMessage();
    Assert.assertEquals(expectedMessage, thrownMessage);
  }

  /**
   * Test adding more than max units of condiments, 3 milk, 3 sugar for example
   * throws CondimentException.
   */
  @Test
  public void TestNoMoreThanSixCondimentUnitsPerBeverage() {

    String milk = "milk";
    int milkUnits = 3;
    String sugar = "sugar";
    int sugarUnits = 3;
    String agave = "agave";
    int overLoadUnits = 1;
    HotBeverage bev = new HotBeverage();
    try {
      bev.addCondiment(milk, milkUnits); // legal
      bev.addCondiment(sugar, sugarUnits); // legal but at limit
      Exception e = assertThrows(CondimentException.class, () -> {
        bev.addCondiment(agave, overLoadUnits); // illegal
      });
      String expectedMessage = "Error: cannot add " + agave
        + ". Max condiments in Beverage reached.";
      String thrownMessage = e.getMessage();
      Assert.assertEquals(expectedMessage, thrownMessage);
    } catch (CondimentException e) {
      e.printStackTrace();
    }
  }
}