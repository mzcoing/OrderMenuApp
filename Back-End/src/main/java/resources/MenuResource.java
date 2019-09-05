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
import com.google.*;


import javax.ws.rs.*;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/menu")
@Produces(MediaType.APPLICATION_JSON)

public class MenuResource {

  private MenuRepository menuRepository;

  private MongoCollection<Document> collection;

//    public MenuResource(final MenuRepository menuRepository) {
//        this.menuRepository = menuRepository;
//    }

  public MenuResource(MongoCollection<Document> collection, MenuRepository menuRepository) {
    this.collection = collection;
    this.menuRepository = menuRepository;
  }

//    @GET
//    @Timed
//    public Collection<Menu> getAll() {
//        return this.menuRepository.getAllMenus();
//    }

  @GET
  @Timed
  public Response getAll() {
    List<Document> documents = menuRepository.find(collection);
    return Response.ok(documents).build();
  }

  @GET
  @Path("/{id}")
  @Timed
  public Menu get(@PathParam("id") final int id) {

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

//      System.out.println(documents.get(0).get("id"));
//    return Response.ok(documents).build();
//        return this.menuRepository.get(id);
  }

  @POST
  @Timed
  public Response post(final Menu menu) {
    Gson gson = new Gson();
      menu.setId((double) this.menuRepository.find(collection).size() + 1.0);
    String json = gson.toJson(menu);
    this.menuRepository.insertOne(collection, new Document(BasicDBObject.parse(json)));
    Map<String, String> response = new HashMap<>();
    response.put("message", "Menu added successfully");
    return Response.ok(response).build();

//    return this.menuRepository.addNewMenu(menu);
  }

  @DELETE
  @Timed
  @Path("/{id}")
  public Response deleteEmployee(@PathParam("id") final int id) {
    this.menuRepository.deleteOne(collection, "id", id);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Employee with Name: " + id + " deleted successfully");
    return Response.ok(response).build();
  }

  @PATCH
  @Timed
  @Path("/add/{menuId}")
  public Response editEmployee(@PathParam("menuId") final String id, final Item item) {
    this.menuRepository.updateMenu(collection, id, "items", item);
    Map<String, String> response = new HashMap<>();
    response.put("message", "Employee with Name: " + item.getName() + " updated successfully");
    return Response.ok(response).build();
  }

//  @DELETE
//  @Path("/{id}")
//  @Timed
//  public Collection<Menu> delete(@PathParam("id") final int id) {
//    return this.menuRepository.removeMenu(id);
//  }

//  @DELETE
//  @Path("/{id}")
//  @Timed
//  public Collection<Menu> delete(@PathParam("id") final int id) {
//    return this.menuRepository.removeMenu(id);
//  }

//    @PATCH
//    @Path("/remove/{menuId}/{itemName}")
//    public java.util.List<Item> removeMenuItem(
//            @PathParam("menuId") final int menuId,
//            @PathParam("itemName") final String itemName) {
//      final java.util.List<Item> items = this.menuRepository.get(menuId).getItems();
//
//      for (final ListIterator<Item> iterator = items.listIterator(); iterator.hasNext();) {
//         final Item item = iterator.next();
//
//         if (itemName.equals(item.getName())) {
//            iterator.remove();
//
//            break;
//         }
//      }
//      return this.menuRepository.get(menuId).getItems();
//   }
//
//        @PATCH
//        @Path("/add/{menuId}")
//        public java.util.List<Item> addMenuItem(
//        @PathParam("menuId") final int menuId, final Item item) {
//        final java.util.List<Item> items = this.menuRepository.get(menuId).getItems();
//        items.add(item);
//
//        return this.menuRepository.get(menuId).getItems();
//        }
//
//   @PATCH
//   @Path("/update/{id}")
//   public Menu updateName(
//       @PathParam("id") final int id, final String menuName){
//        this.menuRepository.get(id).setName(menuName);
//
//        return this.menuRepository.get(id);
//
//       }

}
