package models;
import java.util.ArrayList;

public class Order {
    private Customer customer;
    private ArrayList<OrderItem> orderItems;

    public Order(Customer customer, ArrayList<OrderItem> orderItems) {
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public float calculateTotal() {
        float total = 0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.getBook().getPrice() * orderItem.getQuantity();
        }
        return total;
    }

    public void process() {
        customer.orderCount++;
    }
}

