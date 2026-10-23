
package mypackage.model;

public class deliveryAgent extends Users {

    public deliveryAgent(int id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
    }

    @Override
    public void performRole() {
        System.out.println("Delivery Agent: View assigned orders and deliver food.");
    }
}
