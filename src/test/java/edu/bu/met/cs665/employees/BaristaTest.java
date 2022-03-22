package edu.bu.met.cs665.employees;


import edu.bu.met.cs665.beverages.Coffee;
import edu.bu.met.cs665.beverages.CondimentException;
import edu.bu.met.cs665.beverages.Tea;
import edu.bu.met.cs665.store.Menu;
import edu.bu.met.cs665.store.Order;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * The purpose of this class is to test the Barista calculating the price
 * of various beverages and sizes based off the menu prices. Also tests
 * constructors for Coffee and Tea classes. Further tests getting prices
 * for Tea and Coffee respectively from Menu.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class BaristaTest {

  public BaristaTest() {}

  /**
   * Test calculating price of small coffee.
   */
  @Test
  public void TestCalculateCoffeePriceSmall() {
    Menu menu = new Menu(); // to see all prices
    Barista barista = new Barista();
    Coffee small_espresso = new Coffee();
    small_espresso.setType("espresso");
    String size = "small";
    small_espresso.setSize(size);
    try {
      String condiment1 = "almond-milk";
      Integer aMilkUs = 2;
      String condiment2 = "sugar";
      Integer sugarUs = 1;
      small_espresso.addCondiment(condiment1, aMilkUs);
      small_espresso.addCondiment(condiment2, sugarUs);
      Order order = new Order(small_espresso);
      Map<String, Double> price = barista.calculatePrice(order); // small coffee
      Map<String, Double> menuPrices = menu.getCoffeePrices();
      Assert.assertEquals(menuPrices.get(size), price.get(size));

    } catch (CondimentException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test calculating price of medium coffee.
   */
  @Test
  public void TestCalculateCoffeePriceMedium() {
    Menu menu = new Menu(); // to see all prices
    Barista barista = new Barista();
    Coffee medium_espresso = new Coffee();
    medium_espresso.setType("espresso");
    String size = "medium";
    medium_espresso.setSize(size);
    Order order = new Order(medium_espresso);
    Map<String, Double> price = barista.calculatePrice(order); // medium coffee
    Map<String, Double> menuPrices = menu.getCoffeePrices();
    Assert.assertEquals(menuPrices.get(size), price.get(size));
  }

  /**
   * Test calculating price of large coffee.
   */
  @Test
  public void TestCalculateCoffeePriceLarge() {
    Menu menu = new Menu(); // to see all prices
    Barista barista = new Barista();
    Coffee large_espresso = new Coffee();
    large_espresso.setType("espresso");
    String size = "large";
    large_espresso.setSize(size);
    Order order = new Order(large_espresso);
    Map<String, Double> price = barista.calculatePrice(order); // large coffee
    Map<String, Double> menuPrices = menu.getCoffeePrices();
    Assert.assertEquals(menuPrices.get(size), price.get(size));
  }

  /**
   * Test calculating price of small tea.
   */
  @Test
  public void TestCalculateTeaPriceSmall() {
    Menu menu = new Menu(); // to see all prices
    Barista barista = new Barista();
    Tea large_green = new Tea();
    large_green.setType("yellow-tea");
    String size = "small";
    large_green.setSize(size);
    Order order = new Order(large_green);
    Map<String, Double> price = barista.calculatePrice(order); // small tea
    Map<String, Double> menuPrices = menu.getTeaPrices();
    Assert.assertEquals(menuPrices.get(size), price.get(size));
  }

  /**
   * Test calculating price of medium tea.
   */
  @Test
  public void TestCalculateTeaPriceMedium() {
    Menu menu = new Menu(); // to see all prices
    Barista barista = new Barista();
    Tea large_green = new Tea();
    large_green.setType("black-tea");
    String size = "medium";
    large_green.setSize(size);
    Order order = new Order(large_green);
    Map<String, Double> price = barista.calculatePrice(order); // medium tea
    Map<String, Double> menuPrices = menu.getTeaPrices();
    Assert.assertEquals(menuPrices.get(size), price.get(size));
  }

  /**
   * Test calculating price of large tea.
   */
  @Test
  public void TestCalculateTeaPriceLarge() {
    Menu menu = new Menu(); // to see all prices
    Barista barista = new Barista();
    Tea large_green = new Tea();
    large_green.setType("green-tea");
    String size = "large";
    large_green.setSize(size);
    Order order = new Order(large_green);
    Map<String, Double> price = barista.calculatePrice(order); // large tea
    Map<String, Double> menuPrices = menu.getTeaPrices();
    Assert.assertEquals(menuPrices.get(size), price.get(size));
  }
}