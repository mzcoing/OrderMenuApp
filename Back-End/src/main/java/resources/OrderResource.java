package resources;

import com.codahale.metrics.annotation.Timed;
import models.Order;
import repository.OrderRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)

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

    @GET
    @Path("/{id}")
    @Timed
    public Order get(@PathParam("id") final int id) {
        return this.orderRepository.get(id);
    }

    @POST
    @Timed
    public Collection<Order> post(final Order order) {
        return this.orderRepository.addNewOrder(order);
    }

    @DELETE
    @Path("/{id}")
    @Timed
    public Collection<Order> delete(@PathParam("id") final int id) {
        return this.orderRepository.removeOrder(id);
    }
}
