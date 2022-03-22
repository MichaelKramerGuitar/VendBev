package edu.bu.met.cs665.employees;

import edu.bu.met.cs665.beverages.HotBeverage;
import edu.bu.met.cs665.store.Menu;
import edu.bu.met.cs665.store.Order;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The purpose of this class is to provide the concept of the part of the machine
 * that does the brewing made to order.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class Barista {

  private final Menu menu = new Menu();

  /**
   * The purpose of this method is to calculate the price of an order.
   * @param order an Order object
   * @return A Map with this size:String and price:Double
   */
  public Map<String, Double> calculatePrice(Order order) {
    Map<String, Double> price = new HashMap<>();
    HotBeverage beverage = (HotBeverage) order.getBeverage();
    String type = beverage.getType();
    String size = beverage.getSize();
    boolean isCoffee =
        Arrays.stream(menu.getCoffeeChoices()).anyMatch(type::equals);
    boolean isTea =
        Arrays.stream(menu.getTeaChoices()).anyMatch(type::equals);
    if (isCoffee) {
      HashMap<String, Double> coffeePrices = menu.getCoffeePrices();
      Double menuPrice = coffeePrices.get(size);
      price.put(size, menuPrice);
    } else if (isTea) {
      HashMap<String, Double> teaPrices = menu.getTeaPrices();
      Double menuPrice = teaPrices.get(size);
      order.getBeverage().setPrice(menuPrice);
      price.put(size, menuPrice);
    }
    return price;
  }

  /**
   * The purpose of this method is to brew a Beverage order for the given
   * brew time in a synchronized thread.
   * <p>Precondition: an Order object has been instantiated </p>
   * <p>Postcondition: the Order object is brewed</p>
   *
   * @param order is the Order to be brewed
   */
  public synchronized void brew(Order order) throws InterruptedException {
    HotBeverage beverage = (HotBeverage) order.getBeverage();
    System.out.println("Brewing " + beverage.getType() + " for approximately "
                        + beverage.getBrewTime() + " seconds...");
  }
}
