package resources;
import models.*;

import com.codahale.metrics.annotation.Timed;

import io.dropwizard.jersey.PATCH;
// import io.dropwizard.validation.DurationRange.List;
import models.Menu;
import repository.MenuRepository;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.ListIterator;

@Path("/menu")
@Produces(MediaType.APPLICATION_JSON)

public class MenuResource {

    private MenuRepository menuRepository;

    public MenuResource(final MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GET
    @Timed
    public Collection<Menu> getAll() {
        return this.menuRepository.getAllMenus();
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
    public void removeMenuItem(
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
   }

   @PATCH
   @Path("/add/{menuId}")
   public void addMenuItem(
            @PathParam("menuId") final int menuId, final Item item) {  
      final java.util.List<Item> items = this.menuRepository.get(menuId).getItems();
      items.add(item);
   }

}
