# VendBev Application Description
* In this assignment, you will implement an application that controls a “Fully Automatic Beverage
Vending Machine”. Your are responsible to implement the controller software of this machine.
The software should be able to control the brew process of different coffee and tea beverages.
The machine should be able to:
  * brew Coffee sorts of Espresso, Americano, Latte Macchiato, and 
  * make Tea sorts of Black Tea, Green Tee and Yellow Tea.
* As an additional requirement, the coffee machine should be able to add condiments like milk
  and sugar to the hot beverage. Users of the machine should be able to select between zero to 3 units
  of milk or sugar to add. More than 3 units is not allowed.
  Note: There is no need to implement a graphical user interface (GUI). Implement Unit Tests to
  show functionality of your implementation.
  Optional Task: Calculate the final price of the hot beverage from a set of base prices, like hot
  coffee 2 USD.

#  2.1 Task 1: Implementation Description
* Run `src/main/java/edu/bu/met/cs655/Main.java` for simulation
  * customers chooses beverage with options 
  * order is created
  * barista brews orders in their own threads
    * See Customer.OrderBeverage subclass for thread implementation
* High Level Description and Approach 
    * The concept of this implementation is that VendBev is a beverage vending machine that has the following components to achieve a vend
      * Various Beverages (currently only Coffees and Teas)
      * Order
        * Has the details of the Beverage being ordered such as 
          * Beverage type 
          * Condiments and Sweeteners
      * Barista 
        * Brews a Beverage
        * Calculates the price of a beverages
      * Menu 
        * Has information about Beverages, condiments and prices 
      * Customer 
        * A framework object to choose options from a menu from which an order can be created for brewing/vending
* How flexible is your implementation, e.g., how you add or remove in future new drink types?
  * This implentation is highly flexible
  * The Beverage abstract class is extended by a Concrete class HotBeverage to support the current use case
    * To this end HotBeverage is extended by both Coffee and Tea subclasses
  * Using inheritance in this way one might imagine adding beverage types or new drinks by creating a concrete class extending Beverage, ColdBeverages
    * ColdBeverages might be extended by Juice and SoftDrink etc.
  * Inheritance in this way allows us to utilize polymorphism with our set and getType() methods from Beverage
    * These types in this current implementation are determined by the creation of two intermediary classes
      * The Menu which has String array attributes for coffee and tea choices, in addition to condiments, sizes and prices respectively.
      * The Customer class has methods to choose from these array values (at random in this implementation for simulation) and thus the appropriate Beverage sub type is determined.
    * If we wished to add or remove new drink types in the future it would simply be a matter of either updating the above referenced String arrays or extending the Beverage class appropriately and creating new appropriate String array attributes for said Beverage subclasses.

* How is the simplicity and understandability of your implementation?
  * With a pre-requisite basic knowledge of inheritance and polymorphism, this implementation is quite simple.
  * It would further be quite intuitive to explain to a superior or supervisor who did not understand how to write software because the principles of  inheritance utilized in this implementation are inspired by and mirror a Starbucks (or any Coffee shop) experience, only in code.
    * !To this end, once we understand that a Beverage is an abstraction (not a type to actually be ordered) of a HotBeverage (still not to be actually ordered) which is an abstraction of both Tea and Coffee (types the customer will actually order) basically we can easily see the following:
      * See **How you avoided duplicated code?**

* How you avoided duplicated code?
  * Through inheritance and designing classes modularity based on unique functional characteristics
    * A customer chooses their beverage, size and condiments from a menu
    * A menu has information on prices of available beverage types according to size and type
    * An order is created from the customers choice
    * A barista brews the order, charges the customer and delivers the beverage when ready
      * This implementation uses threading to simulate the concept of brewing multiple beverages at once and sleeps the threads to elongate the customer experience to a comparable real world brew time per order
  * Effort was made to determine the necessary processes and methods to meet the requirements laid out in the Implementation Description and to utilize the single responsibility principle learned in CS622 Advanced Programming Techniques
    * Each class should have a single job, or only one reason for its data to change
      * Each class method should have a single job, changing one single attribute of its class
  * Inheritance in Java gives us the Open Closed principle as well to facilitate avoiding duplication of code where objects are open for extension but closed for modification.


# Project Template

This is a Java Maven Project Template


# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

# Run all the unit test classes.


```bash
mvn clean compile test checkstyle:check  spotbugs:check
```

# Using Spotbugs to find bugs in your project 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn spotbugs:gui 
```

or 


```bash
mvn spotbugs:spotbugs
```


```bash
mvn spotbugs:check 
```

check goal runs analysis like spotbugs goal, and make the build failed if it found any bugs. 


For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html


SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```




