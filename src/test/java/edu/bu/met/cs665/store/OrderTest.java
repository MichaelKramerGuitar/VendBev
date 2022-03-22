package edu.bu.met.cs665.store;

import edu.bu.met.cs665.beverages.Coffee;
import edu.bu.met.cs665.beverages.CondimentException;
import edu.bu.met.cs665.beverages.HotBeverage;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The purpose of this class is to test the Order constructors.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class OrderTest  {

  public void OrderTest() {}

  /**
   * Test espresso no condiments.
   */
  @Test
  public void TestSmallEspressoOrderNoCondiments() {
    Coffee small_espresso = new Coffee();
    small_espresso.setType("espresso");
    small_espresso.setSize("small");
    Order order = new Order(small_espresso);
    Assert.assertEquals("espresso", order.getBeverage().getType());
    Assert.assertEquals("small", order.getBeverage().getSize());
  }

  /**
   * Test one condiment.
   */
  @Test
  public void TestSmallEspressoOrderOneCondiment() {

    Coffee small_espresso = new Coffee();
    small_espresso.setType("espresso");
    small_espresso.setSize("small");
    try {
      small_espresso.addCondiment("milk", 3);
      Order order = new Order(small_espresso);
      HotBeverage bev = (HotBeverage) order.getBeverage();
      String milk = bev.getCondiments().keySet().toString().replaceAll("[\\[\\]]", "");
      String milkU = bev.getCondiments().values().toString().replaceAll("[\\[\\]]", "");
      Integer milkUnits = Integer.parseInt(milkU);
      Integer expectedUnits = 3;
      assertEquals("milk", milk);
      assertEquals(expectedUnits, milkUnits);
    } catch (CondimentException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test two condiments.
   */
  @Test
  public void TestSmallEspressoOrderTwoCondiments() {
    Coffee small_espresso = new Coffee();
    small_espresso.setType("espresso");
    small_espresso.setSize("small");
    try {
      String condiment1 = "almond-milk";
      Integer aMilkUs = 2;
      String condiment2 = "sugar";
      Integer sugarUs = 1;
      small_espresso.addCondiment(condiment1, aMilkUs);
      small_espresso.addCondiment(condiment2, sugarUs);
      Order order = new Order(small_espresso);
      HotBeverage bev = (HotBeverage) order.getBeverage();
      Integer almondMilkUnits = bev.getCondiments().get(condiment1);
      Integer sugarUnits = bev.getCondiments().get(condiment2);
      assertEquals(aMilkUs, almondMilkUnits);
      assertEquals(sugarUs, sugarUnits);
    } catch (CondimentException e) {
      e.printStackTrace();
    }
  }
}