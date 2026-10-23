
package mypackage.model;

public class FoodItem {

    private final int id;
    private final String name;
    private final double price;

    public FoodItem(int id, String name, double price) {
        if (id <= 0) {
            throw new IllegalArgumentException("Food ID must be positive");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Food name cannot be empty");
        }

        if (price < 0 || Double.isNaN(price) || Double.isInfinite(price)) {
            throw new IllegalArgumentException("Price must be a valid non-negative number");
        }

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
