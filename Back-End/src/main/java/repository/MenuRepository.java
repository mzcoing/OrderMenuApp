package repository;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import models.Item;
import org.bson.Document;

import java.util.*;

public class MenuRepository {

    public MenuRepository() {}

  public List<Document> findById(MongoCollection<Document> collection, String key, int value) {

    return collection.find(Filters.eq(key, value)).into(new ArrayList<>());
  }

  public void insertOne(MongoCollection<Document> collection, Document document) {
    collection.insertOne(document);
  }

  public void deleteOne(MongoCollection<Document> collection, String key, int value) {
    collection.deleteOne(Filters.eq(key, value));
  }

  public void updateMenu(MongoCollection<Document> collection, int id, Item item) {
    Gson gson = new Gson();
    String json = gson.toJson(item);
    collection.updateOne(Filters.eq("id", id), new Document("$push", new Document("items", BasicDBObject.parse(json))));
  }

  public List<Document> getAllMenus(MongoCollection<Document> collection) {
    return collection.find().into(new ArrayList<>());
  }

  public void removeItem(MongoCollection<Document> collection, int id, String name) {
    collection.updateOne(
      Filters.eq("id", id),
      new Document( "$pull", new Document("items", new Document("name", name)))
    );
  }

  public void renameMenu(MongoCollection<Document> collection, int id, String newName) {
      collection.updateOne(
        Filters.eq("id", id),
        new Document("$set", new Document("name", newName))
      );
  }

}
