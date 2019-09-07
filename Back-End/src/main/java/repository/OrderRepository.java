package repository;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import models.Item;

import models.Order;
import org.bson.Document;

import java.util.*;

public class OrderRepository {

  public List<Document> getAllOrders(MongoCollection<Document> collection) {
    return collection.find().into(new ArrayList<>());
  }

  public List<Document> findById(MongoCollection<Document> collection, String key, int value) {

    return collection.find(Filters.eq(key, value)).into(new ArrayList<>());
  }

  public void insertOne(MongoCollection<Document> collection, Document document) {
    collection.insertOne(document);
  }

  public void deleteOne(MongoCollection<Document> collection, String key, int value) {
    collection.deleteOne(Filters.eq(key, value));
  }

  public void updateOrder(MongoCollection<Document> collection, int id, Item item) {
    Gson gson = new Gson();
    String json = gson.toJson(item);
//    collection.updateOne(Filters.eq("id", id), new Document("$push", new Document("items", BasicDBObject.parse(json))));
    List checkForValue = new ArrayList();
    System.out.println(item.getName());
    System.out.println(item.getPerson());
    System.out.println(item.getPrice());
    System.out.println(item.getQuantity());

    collection.find(Filters.and(Filters.eq("id", id), Filters.eq("items.name", item.getName()), Filters.eq("items.person", item.getPerson()),
      Filters.eq("items.price", item.getPrice())
    )
    ).into(checkForValue);
//    System.out.println(checkForValue.get(0));
    System.out.println(checkForValue.isEmpty());

    if (checkForValue.isEmpty()) {
      collection.updateOne(Filters.eq("id", id), new Document("$push", new Document("items", BasicDBObject.parse(json))));
    } else {
      collection.findOneAndUpdate(Filters.and(Filters.eq("id", id), Filters.eq("items.name", item.getName())), new Document("$set", new Document("items.quantity", 1.0)));
    }
  }

  public void removeItem(MongoCollection<Document> collection, int id, String name) {
    collection.updateOne(
      Filters.eq("id", id),
      new Document( "$pull", new Document("items", new Document("name", name)))
    );
  }

  public void renameOrder(MongoCollection<Document> collection, int id, String newName) {
    collection.updateOne(
      Filters.eq("id", id),
      new Document("$set", new Document("name", newName))
    );
  }

}
