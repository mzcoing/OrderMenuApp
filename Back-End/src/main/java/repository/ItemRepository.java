// package repository;

// import models.Item;

// import java.util.Collection;
// import java.util.HashMap;
// import java.util.Map;

// public class ItemRepository {

//     private Map<Integer, Item> items;

//     public ItemRepository() {
//         this.items = new HashMap<>();
//          addNewItem(new Item("Milos", "pljeskavica", 1, 110));
//          addNewItem(new Item("Marko", "pizza", 2, 120));
//          addNewItem(new Item("Pera", "burek", 3, 130));
//          addNewItem(new Item("Jovan", "kifla", 4, 140));
//          addNewItem(new Item("Ivan", "salata", 5, 150));
//          addNewItem(new Item("Mile", "piletina", 6, 160));
//          addNewItem(new Item("Miroslav", "bufla", 7, 170));
//          addNewItem(new Item("Nikola", "djevrek", 8, 180));
//          addNewItem(new Item("Ljuba", "virsla", 9, 190));
//          addNewItem(new Item("Zoran", "jaja", 10, 200));

//     }

//     public Collection<Item> getAllitems() {
//         return this.items.values();
//     }

//     public Item get(final int id) {
//         return this.items.get(id);
//     }

//     public Collection<Item> addNewItem(final Item item) {
//         this.items.put(item.getId(), item);

//         return this.items.values();
//     }

//     public Collection<Item> removeItem(final int id) {
//         this.items.remove(id);

//         return this.items.values();
//     }

// }
