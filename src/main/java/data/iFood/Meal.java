package data.iFood;
/*
* This class demonstrates aggregation.
* A Meal is an object that contains (aggregates) multiple FoodItem objects.
 */
import java.util.ArrayList;

// A meal is made up of a list of FoodItem objects.
    // This is an example of AGGREGATION (Meal "has" FoodItems).

public class Meal {
    private ArrayList<FoodItem> items;

    public Meal() {
        items = new ArrayList<>();
    }

    // Adds a FoodItem to the meal

    public void addItem(FoodItem item) {
        items.add(item);
    }

    // Calculates the total carbon footprint of the meal by summing the carbon footprint of every food item
    public double getCarbonFootprint() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.calculateCarbonFootprint();
        }
        return total;
    }

    /**
     * Calculates the total water usage of the meal
     * by summing the water usage of every food item.
     */

    public double getWaterUsage() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.calculateWaterUsage();
        }
        return total;
    }

    // Displays all food items in the meal and the total impact.
    public void displayMealImpact() {
        System.out.println("\nMeals");

        // Listing  all food names in the meal
        
        for (FoodItem item : items) {
            System.out.println("- " + item.getName());
        }
        // Display environmental impact
        System.out.println("\nTotal Carbon Footprint: " + getCarbonFootprint() + " kg CO₂");
        System.out.println("Total Water Usage: " + getWaterUsage() + " L");
    }
}
