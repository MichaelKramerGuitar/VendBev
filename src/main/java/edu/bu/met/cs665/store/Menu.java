package edu.bu.met.cs665.store;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * The purpose of this class is to realize the concept of menu options.
 *
 * @author Michael Kramer
 *
 * <p>CS665 Spring 2, 2022 Software Design Patterns</p>
 */
public class Menu {

  private String[] sizes = new String[]{"small", "medium", "large"};

  private Double[] coffeeValues = new Double[]{2.49, 3.25, 4.15};

  private Double[] teaValues = new Double[]{1.25, 1.95, 2.25};

  private String[] coffeeChoices = new String[]{"espresso", "americano", "latte-macchiato"};

  private String[] teaChoices = new String[]{"black-tea", "green-tea", "yellow-tea"};

  private HashMap<String, Double> coffeePrices = new HashMap<>();

  private HashMap<String, Double> teaPrices = new HashMap<>();

  // concat categories
  private String[] menu =
    Stream.of(coffeeChoices, teaChoices).flatMap(Stream::of).toArray(String[]::new);

  // possible condiments
  private String[] possibleCondiments = new String[]{"milk", "half-and-half",
                                                     "cream", "almond-milk", "oat-milk"};

  private String[] possibleSweeteners = new String[]{"sugar", "agave","stevia",
                                                     "equal", "splenda"};

  // Constructor sets prices
  public Menu() {
    setPrices();
  }

  // getters
  public String[] getMenu() {
    return Arrays.copyOf(menu, menu.length);
  }

  public String[] getCondiments() {
    return Arrays.copyOf(possibleCondiments, possibleCondiments.length);
  }

  public String[] getSweeteners() {
    return Arrays.copyOf(possibleSweeteners, possibleSweeteners.length);
  }

  public String[] getCoffeeChoices() {
    return Arrays.copyOf(coffeeChoices, coffeeChoices.length);
  }

  public String[] getTeaChoices() {
    return Arrays.copyOf(teaChoices, teaChoices.length);
  }

  public String[] getSizes() {
    return Arrays.copyOf(sizes, sizes.length);
  }

  public Double[] getCoffeeValues() {
    return Arrays.copyOf(coffeeValues, coffeeValues.length);
  }

  public Double[] getTeaValues() {
    return Arrays.copyOf(teaValues, teaValues.length);
  }

  public HashMap<String, Double> getCoffeePrices() {
    /*
    IntelliJ SpotBugs Plugin was telling me to return a copy but the pom.xml file
    version was giving me a WARNING that this is an unchecked/unsafe operation
     */
    //return (HashMap<String, Double>) coffeePrices.clone();
    return coffeePrices;
  }

  public HashMap<String, Double> getTeaPrices() {
    /*
    See getCoffeePrices() method body
     */
    //return (HashMap<String, Double>) teaPrices.clone();
    return teaPrices;
  }

  /**
   * The purpose of this method is to set the prices for the beverages on the
   * menu.
   */
  public void setPrices() {
    Double[] coffeeValues = getCoffeeValues();
    Double[] teaValues = getTeaValues();
    String[] sizes = getSizes();
    for (int i = 0; i < sizes.length; i++) {
      coffeePrices.put(sizes[i], coffeeValues[i]);
      teaPrices.put(sizes[i], teaValues[i]);
    }
  }
}
