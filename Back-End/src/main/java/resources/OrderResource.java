package resources;

import com.codahale.metrics.annotation.Timed;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import io.dropwizard.jersey.PATCH;
import models.Item;
import models.Order;
import org.bson.Document;
import repository.OrderRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)

public class OrderResource {

    private OrderRepository orderRepository;
  private MongoCollection<Document> collection;

    public OrderResource(MongoCollection<Document> collection, final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.collection = collection;
    }

  @GET
  @Timed
  public Response getAllOrders() {
    List<Document> documents = orderRepository.getAllOrders(collection);
    return Response.ok(documents).build();
  }

  @GET
  @Path("/{id}")
  @Timed
  public Order getOrderById(@PathParam("id") final int id) {

    final List<Document> documents = this.orderRepository.findById(collection, "id", id);
    final Document document = documents.get(0);

    final List<Document> itemsD = (List<Document>) document.get("items");
    final List<Item> itemModelList = new LinkedList<>();
    try {
      itemsD.forEach(x -> {

        itemModelList.add(new Item(
          (String) x.get("person"),
          (String) x.get("name"),
          (double) x.get("quantity"),
          (double) x.get("price")
        ));
      });
    } catch (NullPointerException e) {
      itemModelList.add(new Item());
    }

    return new Order((double) document.get("id"), (String) document.get("name"), itemModelList);
  }

  @POST
  @Timed
  public Response addNewOrder(final Order order) {
    Gson gson = new Gson();
    order.setId((double) this.orderRepository.getAllOrders(collection).size() + 1.0);
    String json = gson.toJson(order);
    this.orderRepository.insertOne(collection, new Document(BasicDBObject.parse(json)));
    Map<String, String> response = new HashMap<>();
    response.put("message", "Order added successfully");
    return Response.ok(response).build();

  }

  @DELETE
  @Timed
  @Path("/{id}")
  public Response deleteOrder(@PathParam("id") final int id) {
    this.orderRepository.deleteOne(collection, "id", id);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Employee with Name: " + id + " deleted successfully");
    return Response.ok(response).build();
  }

  @PATCH
  @Timed
  @Path("/add/{orderId}")
  public Response addItem(@PathParam("orderId") final int id, final Item item) {
    this.orderRepository.updateOrder(collection, id, item);
    Map<String, String> response = new HashMap<>();
    response.put("message", item.getName() + " added to the order successfully");
    return Response.ok(response).build();
  }

  @PATCH
  @Timed
  @Path("/remove/{orderId}/{itemName}")
  public Response removeItem(@PathParam("orderId") final int id, @PathParam("itemName") final String itemName) {
    this.orderRepository.removeItem(collection, id, itemName);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Successfully deleted " + itemName + "from the order with id " + id);
    return Response.ok(response).build();
  }

  @PATCH
  @Timed
  @Path("/update/{id}")
  public Response updateName(
    @PathParam("id") final int id, final String newName) {
    this.orderRepository.renameOrder(collection, id, newName);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Order with id " + id + "successfully renamed to " + newName);
    return Response.ok(response).build();
  }

}
