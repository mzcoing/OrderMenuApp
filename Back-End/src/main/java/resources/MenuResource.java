package resources;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import models.*;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.PATCH;
import models.Menu;
import org.bson.Document;
import repository.MenuRepository;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/menu")
@Produces(MediaType.APPLICATION_JSON)

public class MenuResource {

  private MenuRepository menuRepository;

  private MongoCollection<Document> collection;

  public MenuResource(MongoCollection<Document> collection, MenuRepository menuRepository) {
    this.collection = collection;
    this.menuRepository = menuRepository;
  }

  @GET
  @Timed
  public Response getAllMenus() {
    List<Document> documents = menuRepository.getAllMenus(collection);
    return Response.ok(documents).build();
  }

  @GET
  @Path("/{id}")
  @Timed
  public Menu getMenuById(@PathParam("id") final int id) {

    final List<Document> documents = this.menuRepository.findById(collection, "id", id);
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

    return new Menu((double) document.get("id"), (String) document.get("name"), itemModelList);
  }

  @POST
  @Timed
  public Response addNewMenu(final Menu menu) {
    Gson gson = new Gson();
    menu.setId((double) this.menuRepository.getAllMenus(collection).size() + 1.0);
    String json = gson.toJson(menu);
    this.menuRepository.insertOne(collection, new Document(BasicDBObject.parse(json)));
    Map<String, String> response = new HashMap<>();
    response.put("message", "Menu added successfully");
    return Response.ok(response).build();

  }

  @DELETE
  @Timed
  @Path("/{id}")
  public Response deleteMenu(@PathParam("id") final int id) {
    this.menuRepository.deleteOne(collection, "id", id);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Employee with Name: " + id + " deleted successfully");
    return Response.ok(response).build();
  }

  @PATCH
  @Timed
  @Path("/add/{menuId}")
  public Response addItem(@PathParam("menuId") final int id, final Item item) {
    this.menuRepository.updateMenu(collection, id, item);
    Map<String, String> response = new HashMap<>();
    response.put("message", item.getName() + " added to the menu successfully");
    return Response.ok(response).build();
  }

  @PATCH
  @Timed
  @Path("/remove/{menuId}/{itemName}")
  public Response removeItem(@PathParam("menuId") final int id, @PathParam("itemName") final String itemName) {
    this.menuRepository.removeItem(collection, id, itemName);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Successfully deleted " + itemName + "from the menu with id " + id);
    return Response.ok(response).build();
  }

  @PATCH
  @Timed
  @Path("/update/{id}")
  public Response updateName(
    @PathParam("id") final int id, final String newName) {
    this.menuRepository.renameMenu(collection, id, newName);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Menu with id " + id + "successfully renamed to " + newName);
    return Response.ok(response).build();
  }

}
