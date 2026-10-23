
package mypackage.controller;

import java.util.List;

import mypackage.model.FoodItem;
import mypackage.service.FoodOrderService;

public class FoodOrderController {

    private final FoodOrderService service;

    public FoodOrderController(FoodOrderService service) {
        this.service = service;
    }

    public List<FoodItem> getMenu() {
        return service.getMenu();
    }

    public FoodItem findFoodById(int id) {
        return service.findFoodById(id);
    }

    public double calculateTotal(List<Integer> foodIds) {
        return service.calculateTotal(foodIds);
    }
}
