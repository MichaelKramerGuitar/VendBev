package edu.bu.met.cs665;

import edu.bu.met.cs665.beverages.Coffee;
import edu.bu.met.cs665.beverages.CondimentException;
import edu.bu.met.cs665.beverages.HotBeverage;
import edu.bu.met.cs665.beverages.Tea;
import edu.bu.met.cs665.customers.Customer;
import edu.bu.met.cs665.employees.Barista;
import edu.bu.met.cs665.store.Menu;
import edu.bu.met.cs665.store.Order;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainTest {
  /*
  Because the tests are the focus of this assignment we'll log these as well
   */
  private static Logger logger = Logger.getLogger(Main.class);
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
  private String[] names = new String[]{"Michael", "Glennys", "Maya", "Akiva"};
  public MainTest() {}

  @Test
  public void TestCustomerOrderSimulation(){
    LocalDateTime now = LocalDateTime.now();
    int upperbound = names.length;
    Customer customer =
      new Customer(names[(int) ((Math.random() * (upperbound - 1)) + 1)]);
    customer.chooseBeverage();
    customer.chooseSize();
    customer.chooseCondiment();
    customer.chooseSweetener();
    Barista barista = new Barista(); // vending machines internal agent
    Menu menu = new Menu();
    boolean isCoffee =
      Arrays.stream(menu.getCoffeeChoices()).anyMatch(customer.getChoice()::equals);
    boolean isTea =
      Arrays.stream(menu.getTeaChoices()).anyMatch(customer.getChoice()::equals);
    HotBeverage beverage = new HotBeverage();
    if (isCoffee) {
      beverage = new Coffee();
      beverage.setType(customer.getChoice());
      beverage.setSize(customer.getSizeChoice());
      beverage.setBrewTime(23);
    } else if (isTea) {
      beverage = new Tea();
      beverage.setType(customer.getChoice());
      beverage.setSize(customer.getSizeChoice());
      beverage.setBrewTime(21);
    }
    boolean ready = false;
    try {
      if (customer.getCondiment() == null) {
        Order order = new Order(beverage);
        Map<String, Double> price = barista.calculatePrice(order);
        logger.info(customer.getName() + " ordered a "
            + price.keySet().toString().replaceAll("[\\[\\]]", "")
            + " " + customer.getChoice() + " TOTAL: "
            + "$" +  price.values().toString().replaceAll("[\\[\\]]", "")
            + " " + dtf.format(now));
        System.out.println(customer.getName() + " ordered a "
            + price.keySet().toString().replaceAll("[\\[\\]]", "")
            + " " + customer.getChoice() + " TOTAL: "
            + "$" +  price.values().toString().replaceAll("[\\[\\]]", ""));
        barista.brew(order);
        ready = true;
        order.setStatus(ready);

      } else if (customer.getSweetener() == null) {
        Order order = new Order(beverage, customer.getCondiment(), customer.getCondimentUnits());
        Map<String, Double> price = barista.calculatePrice(order);
        logger.info(customer.getName() + " ordered a "
            + price.keySet().toString().replaceAll("[\\[\\]]", "")
            + " " + customer.getChoice()
            + " with " + " units of "
            + order.getBeverage().getCondiments().keySet().toString().replaceAll("[\\[\\]]", "")
            + order.getBeverage().getCondiments().values().toString().replaceAll("[\\[\\]]", "")
            + " TOTAL: " + "$"
            +  price.values().toString().replaceAll("[\\[\\]]", "")
            + " " + dtf.format(now));
        System.out.println(customer.getName() + " ordered a "
            + price.keySet().toString().replaceAll("[\\[\\]]", "")
            + " " + customer.getChoice()
            + " with " + order.getBeverage().getCondiments().keySet().toString().replaceAll("[\\[\\]]", "")
            + " units of " + order.getBeverage().getCondiments().values().toString().replaceAll("[\\[\\]]", "")
            + " TOTAL: " + "$"
            +  price.values().toString().replaceAll("[\\[\\]]", "")
            + " " + dtf.format(now));
        barista.brew(order);
        ready = true;
        order.setStatus(ready);
      } else {
        Order order = new Order(beverage, customer.getCondiment(), customer.getCondimentUnits(),
          customer.getSweetener(), customer.getSweetenerUnits());
        Map<String, Double> price = barista.calculatePrice(order);
        HashMap<String, Integer> condiments = order.getBeverage().getCondiments();
        logger.info(customer.getName() + " ordered a "
            + price.keySet().toString().replaceAll("[\\[\\]]", "")
            + " " + customer.getChoice() + " with " + condiments.get(customer.getCondiment())
            + " units of " + customer.getCondiment()
            + " and " + condiments.get(customer.getSweetener())
            + " units of " + customer.getSweetener() + " TOTAL: "
            + "$" +  price.values().toString().replaceAll("[\\[\\]]", "")
            + " " + dtf.format(now));
        System.out.println(customer.getName() + " ordered a "
            + price.keySet().toString().replaceAll("[\\[\\]]", "")
            + " " + customer.getChoice() + " with "
            + condiments.get(customer.getCondiment())
            + " units of "
            + customer.getCondiment()
            + " and " + condiments.get(customer.getSweetener())
            + " units of " + customer.getSweetener() + " TOTAL: "
            + "$" +  price.values().toString().replaceAll("[\\[\\]]", "")
            + " " + dtf.format(now));
        barista.brew(order);
        ready = true;
        order.setStatus(ready);
      }
      System.out.println(customer.getName() + " Your "
        + customer.getChoice() + " is ready.");
      logger.info(customer.getName() + "'s order complete.");

    } catch (CondimentException | InterruptedException e) {
      System.out.println(e);
    }
  }
}