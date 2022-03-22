package edu.bu.met.cs665;

import edu.bu.met.cs665.customers.Customer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
// import org.apache.log4j.PropertyConfigurator;

/**
 * The purpose of this class is to house the main method.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class Main {

  private static Logger logger = Logger.getLogger(Main.class);

  /**
   * A main method to run examples.
   *
   * @param args not used
   */
  public static void main(String[] args) {

    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(new Customer.OrderBeverage());
    executorService.shutdown();
    try {
      executorService.awaitTermination(1, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    ExecutorService executorService1 = Executors.newCachedThreadPool();
    executorService1.execute(new Customer.OrderBeverage());
    executorService1.shutdown();
    try {
      executorService1.awaitTermination(1, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}
