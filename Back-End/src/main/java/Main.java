import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
// import org.skife.jdbi.v2.DBI;

import io.dropwizard.Application;
// import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.servlets.CacheBustingFilter;
import io.dropwizard.setup.Environment;
import repository.DBConnector;
// import repository.DBConnector;
import repository.MenuRepository;
import repository.OrderRepository;
import resources.MenuResource;
import resources.OrderResource;



public class Main extends Application<Config> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
        
        
    }
    


    @Override
    public void run(final Config configuration, final Environment environment) 

   
    
    
        throws Exception {

        final DBConnector dbConnector = new DBConnector();
            
        final MenuRepository menuRepository = new MenuRepository();

        final MenuResource menuResource = new MenuResource(menuRepository);

        final OrderRepository orderRepository = new OrderRepository();

        final OrderResource orderResource = new OrderResource(orderRepository);
        // final DBIFactory factory = new DBIFactory();
        // final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "derby");

        // final DBConnector dbConnector = new DBConnector();

            //Force browsers to reload all js and html files for every request as angular gets screwed up
        environment.servlets()
        .addFilter("CacheBustingFilter", new CacheBustingFilter())
        .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

        enableCorsHeaders(environment);

        environment.jersey().register(menuResource);
        environment.jersey().register(orderResource);
        environment.jersey().register(dbConnector);

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