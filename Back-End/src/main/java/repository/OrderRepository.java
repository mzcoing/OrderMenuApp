package repository;

import models.Order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    private Map<Integer, Order> orders;

    public OrderRepository() {
        this.orders = new HashMap<>();
        addNewOrder (new Order (1, "First Order"));
        addNewOrder (new Order (2, "Second Order"));
        addNewOrder (new Order (3, "Third Order"));
        addNewOrder (new Order (4, "Fourth Order"));
        addNewOrder (new Order (5, "Fifth Order"));
    }

    public Collection<Order> getAllOrders() {
        return this.orders.values();
    }

    public Order get(final int id) {
        return this.orders.get(id);
    }

    public Collection<Order> addNewOrder(final Order order) {
        this.orders.put(order.getId(), order);

        return this.orders.values();
    }

    public Collection<Order> removeOrder(final int id) {
        this.orders.remove(id);

        return this.orders.values();
    }

}
