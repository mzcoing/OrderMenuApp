package repository;
import models.Item;

import models.Order;
import java.util.ArrayList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    private Map<Integer, Order> orders;
    ArrayList<Item> items = new ArrayList<>();
    public int counter = 0;
    public int menuid = 0;


    public OrderRepository() {
        this.orders = new HashMap<>();
        for (int i=0; i<2; i++) {
            Item item = new Item("Person " + i, "Food Number " + i, i, i+200);

            this.items.add(item);
        }
        addNewOrder (new Order (0, "First Order", 0, this.items));
        addNewOrder (new Order (1, "Second Order", 1, this.items));
        addNewOrder (new Order (2, "Third Order", 2, this.items));
        addNewOrder (new Order (3, "Fourth Order", 3, this.items));
        addNewOrder (new Order (4, "Fifth Order", 4, this.items));
        addNewOrder (new Order (5, "Sixth Order", 5, this.items));
    }

    private int getNewId() {
        return counter++;
    }

    private int getNewMenuId(){
        return menuid++;
    }

    public Collection<Order> getAllOrders() {
        return this.orders.values();
    }

    public Order get(final int id) {
        return this.orders.get(id);
    }

    public Collection<Order> addNewOrder(final Order order) {

        order.setMenuId(this.getNewMenuId());
        order.setItems(items);
        order.setId(this.getNewId());
        this.orders.put(order.getId(), order);

        return this.orders.values();
    }

    public Collection<Order> removeOrder(final int id) {
        this.orders.remove(id);

        return this.orders.values();
    }

}
