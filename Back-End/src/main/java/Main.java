import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.dropwizard.setup.Bootstrap;
import org.bson.Document;
import org.eclipse.jetty.servlets.CrossOriginFilter;
// import org.skife.jdbi.v2.DBI;

import io.dropwizard.Application;
// import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.servlets.CacheBustingFilter;
import io.dropwizard.setup.Environment;
import repository.MenuRepository;
import repository.OrderRepository;
import resources.MenuResource;
import resources.OrderResource;


public class Main extends Application<Config> {

  public static void main(String[] args) throws Exception {
    new Main().run(args);
  }

  @Override
  public void initialize(Bootstrap<Config> b) {

  }

  @Override
  public void run(final Config configuration, final Environment env) {


    final MongoClient mongoClient = new MongoClient(configuration.getMongoHost(), configuration.getMongoPort());

    final MongoManaged mongoManaged = new MongoManaged(mongoClient);
    env.lifecycle().manage(mongoManaged);

    final MongoDatabase db = mongoClient.getDatabase(configuration.getMongoDB());

    MongoCollection<Document> collection = db.getCollection(configuration.getCollectionName());

    MongoCollection<Document> orderCollection = db.getCollection(configuration.getOrderCollectionName());

    final MenuRepository menuRepository = new MenuRepository();

    final MenuResource menuResource = new MenuResource(collection, menuRepository);

    final OrderRepository orderRepository = new OrderRepository();

    final OrderResource orderResource = new OrderResource(orderCollection, orderRepository);

    //Force browsers to reload all js and html files for every request as angular gets screwed up
    env.servlets()
      .addFilter("CacheBustingFilter", new CacheBustingFilter())
      .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

    enableCorsHeaders(env);

    env.jersey().register(menuResource);
    env.jersey().register(orderResource);
  }


  private void enableCorsHeaders(Environment env) {
    final FilterRegistration.Dynamic cors = env.servlets().addFilter("CORS", CrossOriginFilter.class);

    // Configure CORS parameters
    cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "http://localhost:4200, http://localhost:8080, http://localhost:8080/menu, http://localhost:8080/order");
    cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "Overwrite, Destination, Content-Type, Depth, User-Agent, Translate, Range, Content-Range, Timeout, X-File-Size, X-Requested-With, If-Modified-Since, X-File-Name, Cache-Control, Location, Lock-Token, If,Accept,Origin");
    cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "ACL, CANCELUPLOAD, CHECKIN, CHECKOUT, COPY, DELETE, GET, HEAD, LOCK, MKCALENDAR, MKCOL, MOVE, OPTIONS, POST, PROPFIND, PROPPATCH, PUT, REPORT, SEARCH, UNCHECKOUT, PATCH, UNLOCK, UPDATE, VERSION-CONTROL");

    // Add URL mapping
    cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
  }


}
