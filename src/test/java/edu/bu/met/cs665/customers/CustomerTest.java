package edu.bu.met.cs665.customers;

import edu.bu.met.cs665.store.Menu;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * The purpose of this class is to test the non-trivial methods of the Customer
 * class to ensure the vending simulation is proper.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class CustomerTest {

  private String[] names = new String[]{"John", "Paul", "George", "Ringo"};
  private Menu menu = new Menu();
  private int upperbound = names.length;
  // make a customer
  private Customer customer =
    new Customer(names[(int) ((Math.random() * (upperbound - 1)) + 1)]);

  public CustomerTest() {}

  /**
   * Test customer chooses valid beverage from the menu
   */
  @Test
  public void TestChooseBeverage() {
    // choose a beverage from the menu
    customer.chooseBeverage();
    // check if the customers choice is on the menu
    Assert.assertTrue(Arrays.stream(menu.getMenu()).anyMatch(customer.getChoice()::equals));
  }

  /**
   * Test customer chooses valid size from the menu
   */
  @Test
  public void TestChooseSize() {
    // choose a size
    customer.chooseSize();
    // checks the chosen size valid
    Assert.assertTrue(Arrays.stream(menu.getSizes()).anyMatch(customer.getSizeChoice()::equals));
  }

  /**
   * Test customer chooses valid condiment from the menu
   */
  @Test
  public void TestChooseCondiment() {
    customer.chooseCondiment();
    Assert.assertTrue(Arrays.stream(menu.getCondiments()).anyMatch(customer.getCondiment()::equals));
  }


  /**
   * Test customer chooses valid sweetener from the menu
   */
  @Test
  public void TestChooseSweetener() {
    customer.chooseSweetener();
    Assert.assertTrue(Arrays.stream(menu.getSweeteners()).anyMatch(customer.getSweetener()::equals));
  }
}