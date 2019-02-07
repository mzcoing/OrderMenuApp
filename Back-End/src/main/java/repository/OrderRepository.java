package repository;

import models.Order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    private Map<Integer, Order> orders;

    public OrderRepository() {
        this.orders = new HashMap<>();
    }

    public Collection<Order> getAllOrders() {
        return this.orders.values();
    }

}
