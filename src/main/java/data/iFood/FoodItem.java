package data.iFood;

/*
* This class represents a general food item with its environmental impact.
 * Every specific food type (Beef, Cheese, Lentils, etc.) inherits from this class.
 */
* */

public class FoodItem {
    
     // Instance variables
    private String name;
    private double carbonFootprintPerKg;  // carbon emitted per kg
    private double waterUsagePerKg;       // water used per kg
    private double weightInKg;            // actual weight of the food item

    // Constructor for creating a FoodItem.
    
    FoodItem(String name, double carbonFootprintPerKg, double waterUsagePerKg, double weightInKg){
        // initializing the name
        this.name = name;
        // setter methods
        setCarbonFootprintPerKg(carbonFootprintPerKg);
        setWaterUsagePerKg(waterUsagePerKg);
        setWeightInKg(weightInKg);
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getCarbonFootprintPerKg() {
        return carbonFootprintPerKg;
    }
    public double getWaterUsagePerKg() {
        return waterUsagePerKg;
    }
    public double getWeightInKg() {
        return weightInKg;
    }

    // Setters
    public void setCarbonFootprintPerKg(double carbonFootprintPerKg) {
        // Check footprint
        // Carbon footprint cannot be negative
        if (carbonFootprintPerKg >= 0) {
            this.carbonFootprintPerKg = carbonFootprintPerKg;
        } else {
            throw new IllegalArgumentException("You need to have at least no to one footprint");
        }
    }
    public void setWaterUsagePerKg(double waterUsagePerKg) {
        // Check waterusage in the food
         // Water usage cannot be negative
        if (waterUsagePerKg >= 0){
            this.waterUsagePerKg = waterUsagePerKg;
        } else {
            throw new IllegalArgumentException("You need to either have no or at least one water usage");
        }
    }
    public void setWeightInKg(double weightInKg) {
         // Food weight cannot be negative
        if (weightInKg >= 0) {
            this.weightInKg = weightInKg;
        } else {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
    }

    // Calculates the total carbon footprint based on weight.
    public double calculateCarbonFootprint(){
        return carbonFootprintPerKg * this.weightInKg;
    }

    //Calculates the total water usage based on weight.
    public double calculateWaterUsage() {
        return waterUsagePerKg * this.weightInKg;
    }

    // --------------------------
    // Output Formatting
    // --------------------------
    
    @Override
    public String toString() {
        return String.format("Food Item >> %s: %.2f kg\nEnvironmental Impact | Carbon: %.1f kg CO₂, Water: %.0f L",
                name, weightInKg, calculateCarbonFootprint(), calculateWaterUsage());
    }
}
