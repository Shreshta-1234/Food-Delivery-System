
package mypackage.model;

public class customer extends Users {

    public customer(int id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
    }

    @Override
    public void performRole() {
        System.out.println("Customer: Browse menu and place an order.");
    }
}
