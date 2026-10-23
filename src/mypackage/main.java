package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import mypackage.model.Users;
import mypackage.model.customer;
import mypackage.model.deliveryAgent;
import mypackage.model.FoodItem;
import mypackage.repository.FoodItemRepository;
import mypackage.repository.CollectionFoodItemRepository;
import mypackage.service.FoodOrderService;
import mypackage.controller.FoodOrderController;
public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Food Delivery System");
        System.out.println("1. Customer");
        System.out.println("2. Delivery Agent");
        System.out.print("Choose your role (1 or 2): ");

        int choice = sc.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid role selected!");
            sc.close();
            return;
        }

        System.out.print("Enter your ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = sc.nextLine();

        Users user;

        if (choice == 1) {
            user = new customer(id, name, phoneNumber);
        } else {
            user = new deliveryAgent(id, name, phoneNumber);
        }

        System.out.println("\nUser Details");
        System.out.println("Role: " +
                (choice == 1 ? "Customer" : "Delivery Agent"));
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Phone: " + user.getPhoneNumber());

        FoodItemRepository repository = new CollectionFoodItemRepository();

        FoodOrderService service = new FoodOrderService(repository);

        FoodOrderController controller = new FoodOrderController(service);

        System.out.println("\nRestaurant: Food Corner");
        System.out.println("MENU");

        for (FoodItem item : controller.getMenu()) {
            System.out.println(
                item.getId() + ". " +
                item.getName() + " - Rs. " +
                item.getPrice()
            );
        }

        System.out.print(
                "\nEnter food IDs separated by commas (e.g., 1,3): ");
        String input = sc.nextLine().trim();

        String[] foodIds = input.split(",");
        List<Integer> selectedIds = new ArrayList<>();

        System.out.println("\nYOUR ORDER");

        for (String foodIdText : foodIds) {

            foodIdText = foodIdText.trim();

            if (foodIdText.isEmpty()) {
                continue;
            }

            try {
                int foodId = Integer.parseInt(foodIdText);
                FoodItem selectedFood = controller.findFoodById(foodId);

                if (selectedFood != null) {
                    System.out.println(
                            selectedFood.getName() + " - Rs. " +
                            selectedFood.getPrice());

                    selectedIds.add(foodId);
                } else {
                    System.out.println("Invalid food ID: " + foodId);
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input: " + foodIdText +
                        ". Please enter numeric food IDs.");
            }
        }

        double total = controller.calculateTotal(selectedIds);

        System.out.println("Total Bill: Rs. " + total);

        sc.close();
    }
}
