package mypackage.repository;

import java.util.List;
import mypackage.model.FoodItem;
public interface FoodItemRepository {

    List<FoodItem> getAllFoodItems();

    FoodItem findFoodById(int id);
}


