package resources;

import com.codahale.metrics.annotation.Timed;
import models.Order;
import repository.OrderRepository;

import javax.ws.rs.GET;
import java.util.Collection;

public class OrderResource {

    private OrderRepository orderRepository;

    public OrderResource(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GET
    @Timed
    public Collection<Order> getAll() {
        return this.orderRepository.getAllOrders();
    }
}
