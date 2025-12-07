package data.iFood;
import java.util.Scanner;

/*
 This class calculates the environmental impact 
 of different food items based on user input and preset meals
*/

public class EnvironmentImpactCalculator{
     // Scanner object to read user input
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    // An instance of the calculator to access non-static fields/methods
        EnvironmentImpactCalculator calculator = new EnvironmentImpactCalculator();

        System.out.println("Perform Your Food Choices");

        // Getting user input for a custom food item
        System.out.print("Enter food name: ");
        String name = calculator.sc.nextLine();

        System.out.print("Enter carbon footprint per kg: ");
        double carbon = calculator.sc.nextDouble();

        System.out.print("Enter water usage per kg: ");
        double water = calculator.sc.nextDouble();

        System.out.print("Enter food weight in kg: ");
        double weight = calculator.sc.nextDouble();

        // Creating a FoodItem based on the user's input
        FoodItem otherMeal = new FoodItem(name, carbon, water, weight);

        // Displaying main food
        System.out.println("\nMain Foods\n\n");

        // First object
        Beef beef = new Beef();
        beef.setWeightInKg(0.5);
        System.out.println(beef + "\n");

        // Second Object
        Lentil lentils = new Lentil();
        lentils.setWeightInKg(0.3);
        System.out.println(lentils + "\n");

        // Third Object (Cheese)
        Cheese cheese = new Cheese();
        cheese.setWeightInKg(0.4);
        System.out.println(cheese + "\n");

        System.out.println("Other Meals\n");
        System.out.println(otherMeal);

        // creating a new meal
        Meal usersMeal = new Meal();
        usersMeal.addItem(beef);
        usersMeal.addItem(lentils);
        usersMeal.addItem(otherMeal);

        System.out.println("\nMeal Summary\n");
        usersMeal.displayMealImpact();

        // Compare the user's meal with alternative meals
        calculator.compareWithAlternativeMeals(usersMeal);

        calculator.sc.close();
    }

    public void compareWithAlternativeMeals(Meal usersMeal) {

        System.out.println("Comparing meals");

        Meal beefOverload = new Meal();
        Beef beef1 = new Beef();
        beef1.setWeightInKg(0.6);
        beefOverload.addItem(beef1);

        Meal lentilOverload = new Meal();
        Lentil lentils1 = new Lentil();
        lentils1.setWeightInKg(0.5);
        lentilOverload.addItem(lentils1);

        Meal cheeseOverload = new Meal();
        Cheese cheese1 = new Cheese();
        cheese1.setWeightInKg(0.25);
        cheeseOverload.addItem(cheese1);

        // Show summary for all three meals
        System.out.println(" Meal Comparison Summary");

        System.out.println("Your custom meal total carbon is: " + usersMeal.getCarbonFootprint() + " kg CO₂");
        System.out.println("Your custom meal total water usage is: " + usersMeal.getWaterUsage() + " L\n");

        System.out.println("High total carbon is: " + beefOverload.getCarbonFootprint() + " kg CO₂");
        System.out.println("High total water usage is: " + beefOverload.getWaterUsage() + " L\n");

        System.out.println("Veggie total carbon is: " + lentilOverload.getCarbonFootprint() + " kg CO₂");
        System.out.println("Veggie total water usage is: " + lentilOverload.getWaterUsage() + " L");

        System.out.println("Cheese total carbon is: " + cheeseOverload.getCarbonFootprint() + " kg CO₂");
        System.out.println("Cheese total water usage is: " + cheeseOverload.getWaterUsage() + " L");


        // Determine which meal has the lowest carbon footprint
        double userCarbon = usersMeal.getCarbonFootprint();
        double beefCarbon = beefOverload.getCarbonFootprint();
        double vegCarbon = lentilOverload.getCarbonFootprint();

        double minCarbon = Math.min(userCarbon, Math.min(beefCarbon, vegCarbon));

        System.out.println();
        if (minCarbon == userCarbon) {
            System.out.println(" Your meal has the lowest carbon footprint among these three options!");
        } else if (minCarbon == vegCarbon) {
            System.out.println(" The veggie meal is the best option for the environment.");
        } else {
            System.out.println("The high-beef meal has the highest carbon footprint.");
        }
    }
}
