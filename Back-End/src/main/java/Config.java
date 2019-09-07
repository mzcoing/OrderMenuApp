import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Config extends Configuration {
  @JsonProperty
  @NotEmpty
  public String mongoHost;

  @JsonProperty
  @Min(1)
  @Max(65535)
  public int mongoPort;

  @JsonProperty
  @NotEmpty
  public String mongoDB;

  @JsonProperty
  @NotEmpty
  public String collectionName;

  @JsonProperty
  @NotEmpty
  public String orderCollection;

  public String getMongoHost() {
    return mongoHost;
  }

  public void setMongoHost(String mongoHost) {
    this.mongoHost = mongoHost;
  }

  public int getMongoPort() {
    return mongoPort;
  }

  public void setMongoPort(int mongoPort) {
    this.mongoPort = mongoPort;
  }

  public String getMongoDB() {
    return mongoDB;
  }

  public void setMongoDB(String mongoDB) {
    this.mongoDB = mongoDB;
  }

  public String getCollectionName() {
    return collectionName;
  }

  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }

  public String getOrderCollectionName() { return orderCollection; }

  public void setOrderCollection(String orderCollection) {
    this.orderCollection = orderCollection;
  }
}

