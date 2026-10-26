
package mypackage.repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import mypackage.model.FoodItem;

public class FileFoodItemRepository implements FoodItemRepository {

    private final String filePath = "data/fooditems.json";

    private final Gson gson = new Gson();

    @Override
    public List<FoodItem> getAllFoodItems() {

        try (FileReader reader = new FileReader(filePath)) {

            Type listType = new TypeToken<List<FoodItem>>() {}.getType();

            List<FoodItem> foodItems = gson.fromJson(reader, listType);

            return foodItems != null ? foodItems : new ArrayList<>();

        } catch (IOException e) {
            throw new RuntimeException("Unable to read food items from JSON file.", e);
        }
    }

    @Override
    public FoodItem findFoodById(int id) {

        return getAllFoodItems()
                .stream()
                .filter(food -> food.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
