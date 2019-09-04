package resources;
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
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

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


        return this.menuRepository.get(id);
    }

    @POST
    @Timed
    public Collection<Menu> post(final Menu menu) {
        return this.menuRepository.addNewMenu(menu);
    }

    @DELETE
    @Path("/{id}")
    @Timed
    public Collection<Menu> delete(@PathParam("id") final int id) {
        return this.menuRepository.removeMenu(id);
    }

    @PATCH
    @Path("/remove/{menuId}/{itemName}")
    public java.util.List<Item> removeMenuItem(
            @PathParam("menuId") final int menuId,
            @PathParam("itemName") final String itemName) {
      final java.util.List<Item> items = this.menuRepository.get(menuId).getItems();

      for (final ListIterator<Item> iterator = items.listIterator(); iterator.hasNext();) {
         final Item item = iterator.next();

         if (itemName.equals(item.getName())) {
            iterator.remove();

            break;
         }
      }
      return this.menuRepository.get(menuId).getItems();
   }

        @PATCH
        @Path("/add/{menuId}")
        public java.util.List<Item> addMenuItem(
        @PathParam("menuId") final int menuId, final Item item) {
        final java.util.List<Item> items = this.menuRepository.get(menuId).getItems();
        items.add(item);

        return this.menuRepository.get(menuId).getItems();
        }

   @PATCH
   @Path("/update/{id}")
   public Menu updateName(
       @PathParam("id") final int id, final String menuName){
        this.menuRepository.get(id).setName(menuName);

        return this.menuRepository.get(id);

       }

}
