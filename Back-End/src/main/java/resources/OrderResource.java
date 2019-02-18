package resources;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.jersey.PATCH;
import models.Item;
import models.Order;
import repository.OrderRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.ListIterator;

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


    @PATCH
    @Path("/remove/{orderId}/{itemName}")
    public void removeOrderItem(
            @PathParam("orderId") final int orderId,
            @PathParam("itemName") final String itemName) {
      final java.util.List<Item> items = this.orderRepository.get(orderId).getItems();

      for (final ListIterator<Item> iterator = items.listIterator(); iterator.hasNext();) {
         final Item item = iterator.next();

         if (itemName.equals(item.getName())) {
            iterator.remove();
            break;
         }
      }
   }

   @PATCH
   @Path("/add/{orderId}")
   public void addOrderItem(
            @PathParam("orderId") final int orderId, final Item item) {  
      final java.util.List<Item> items = this.orderRepository.get(orderId).getItems();
      items.add(item);
   }
}
