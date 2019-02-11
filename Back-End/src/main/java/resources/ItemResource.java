// package resources;

// import com.codahale.metrics.annotation.Timed;
// import models.Item;
// import repository.ItemRepository;

// import javax.ws.rs.*;
// import javax.ws.rs.core.MediaType;
// import java.util.Collection;

// @Path("/item")
// @Produces(MediaType.APPLICATION_JSON)

// public class ItemResource {

//     private ItemRepository itemRepository;

//     public ItemResource(final ItemRepository itemRepository) {
//         this.itemRepository = itemRepository;
//     }

//     @GET
//     @Timed
//     public Collection<Item> getAll() {
//         return this.itemRepository.getAllitems();
//     }

//     @GET
//     @Path("/{id}")
//     @Timed
//     public Item get(@PathParam("id") final int id) {
//         return this.itemRepository.get(id);
//     }

//     @POST
//     @Timed
//     public Collection<Item> post(final Item item) {
//         return this.itemRepository.addNewItem(item);
//     }

//     @DELETE
//     @Path("/{id}")
//     @Timed
//     public Collection<Item> delete(@PathParam("id") final int id) {
//         return this.itemRepository.removeItem(id);
//     }
// }
