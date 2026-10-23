
package mypackage.service;

import java.util.List;

import mypackage.model.FoodItem;
import mypackage.repository.FoodItemRepository;

public class FoodOrderService {

    private final FoodItemRepository repository;
    
    public List<FoodItem> getMenu() {
        return repository.getAllFoodItems();
    }

    public FoodOrderService(FoodItemRepository repository) {
        this.repository = repository;
    }

    public FoodItem findFoodById(int id) {
        return repository.findFoodById(id);
    }

    public double calculateTotal(List<Integer> foodIds) {
        double total = 0.0;

        for (int id : foodIds) {
            FoodItem item = repository.findFoodById(id);

            if (item != null) {
                total += item.getPrice();
            }
        }

        return total;
    }
}


