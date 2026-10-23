
package mypackage.repository;

import java.util.ArrayList;
import java.util.List;

import mypackage.model.FoodItem;

public class CollectionFoodItemRepository implements FoodItemRepository {

    private final List<FoodItem> menu;

    public CollectionFoodItemRepository() {
        menu = new ArrayList<>();

        menu.add(new FoodItem(1, "Burger", 120.0));
        menu.add(new FoodItem(2, "Pizza", 250.0));
        menu.add(new FoodItem(3, "Biryani", 180.0));
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return new ArrayList<>(menu);
    }

    @Override
    public FoodItem findFoodById(int id) {
        for (FoodItem item : menu) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }
}

