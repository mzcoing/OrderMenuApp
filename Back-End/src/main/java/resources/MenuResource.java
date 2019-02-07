package resources;

import com.codahale.metrics.annotation.Timed;
import models.Menu;
import repository.MenuRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

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
}
