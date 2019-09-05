package repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import models.Item;
import models.Menu;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import repository.DBConnector;

import java.util.*;

public class MenuRepository {

    DBConnector db = new DBConnector();
    public Map<Double, Menu> menus;
    public int counter = 0;
    ArrayList<Item> items = new ArrayList<>();

    public MenuRepository() {
        this.menus = new HashMap<>();
        for (double i=0; i<2; i++) {
            Item item = new Item("Item " + i, i+200.00);
            this.items.add(item);
        }


        addNewMenu(new Menu(0, "First Menu", this.items));
        addNewMenu(new Menu(1, "Second Menu", this.items));
        addNewMenu(new Menu(2, "Third Menu", this.items));
        addNewMenu(new Menu(3, "Fourth Menu", this.items));
        addNewMenu(new Menu(4, "Fifth Menu", this.items));
        addNewMenu(new Menu(5, "Sixth Menu", this.items));

    }

    private int getNewId() {
        return counter++;
    }


    public Collection<Menu> getAllMenus() {
        return this.menus.values();
    }

    public Menu get(final int id) {
        return this.menus.get(id);
    }

  public List<Document> findById(MongoCollection<Document> collection, String key, int value) {

    return collection.find(Filters.eq(key, value)).into(new ArrayList<>());
  }

  public void insertOne(MongoCollection<Document> collection, Document document) {
      System.out.println(document.get("id"));
    collection.insertOne(document);
  }

  public void deleteOne(MongoCollection<Document> collection, String key, int value) {
    collection.deleteOne(Filters.eq(key, value));
  }

  public void updateMenu(MongoCollection<Document> collection, String key1, String key2, Item item) {

    collection.updateOne(new Document(key1, 3),
      new Document("$set", new Document(key2, item.getName() + "," + item.getPerson() + ", " +
        item.getQuantity() + "," + item.getPrice())));
  }

//  public Menu getOne(MongoCollection<Document> collection, int id) {
//
//    return collection.find(Filters.eq("id", id)).into(new Menu());
//  }

  public List<Document> find(MongoCollection<Document> collection) {
    return collection.find().into(new ArrayList<>());
  }

    public Collection<Menu> addNewMenu(final Menu menu) {

        menu.setItems(items);
        menu.setId(this.getNewId());
        this.menus.put(menu.getId(), menu);
        return this.menus.values();

    }

    public Collection<Menu> removeMenu(final int id) {
        this.menus.remove(id);
        return this.menus.values();
    }



}
