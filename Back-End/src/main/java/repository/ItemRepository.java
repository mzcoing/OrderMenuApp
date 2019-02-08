package repository;

import models.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ItemRepository {

    private Map<Integer, Item> items;

    public ItemRepository() {
        this.items = new HashMap<>();
         addNewItem(new Item(1, "Milos", "pljeskavica", 1, 110));
         addNewItem(new Item(2, "Marko", "pizza", 2, 120));
         addNewItem(new Item(3, "Pera", "burek", 3, 130));
         addNewItem(new Item(4, "Jovan", "kifla", 4, 140));
         addNewItem(new Item(5, "Ivan", "salata", 5, 150));
         addNewItem(new Item(6, "Mile", "piletina", 6, 160));
         addNewItem(new Item(7, "Miroslav", "bufla", 7, 170));
         addNewItem(new Item(8, "Nikola", "djevrek", 8, 180));
         addNewItem(new Item(9, "Ljuba", "virsla", 9, 190));
         addNewItem(new Item(10, "Zoran", "jaja", 10, 200));

    }

    public Collection<Item> getAllitems() {
        return this.items.values();
    }

    public Item get(final int id) {
        return this.items.get(id);
    }

    public Collection<Item> addNewItem(final Item item) {
        this.items.put(item.getId(), item);

        return this.items.values();
    }

    public Collection<Item> removeItem(final int id) {
        this.items.remove(id);

        return this.items.values();
    }

}
