
package mypackage.model;

import java.util.List;

import mypackage.repository.FoodItemRepository;

public class restaurant {

    private final String name;
    private final FoodItemRepository repository;

    public restaurant(String name, FoodItemRepository repository) {
        this.name = name;
        this.repository = repository;
    }

    public void displayMenu() {
        System.out.println("\nRestaurant: " + name);
        System.out.println("----- MENU -----");

        List<FoodItem> menu = repository.getAllFoodItems();

        for (FoodItem item : menu) {
            System.out.println(
                item.getId() + ". " +
                item.getName() + " - Rs. " +
                item.getPrice()
            );
        }
    }
}

