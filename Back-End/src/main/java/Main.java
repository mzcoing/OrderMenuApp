import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import io.dropwizard.Application;
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
    public void run(
        final Config configuration,
        final Environment environment
    ) throws Exception {
        final MenuRepository menuRepository = new MenuRepository();

        final MenuResource menuResource = new MenuResource(menuRepository);

        final OrderRepository orderRepository = new OrderRepository();

        final OrderResource orderResource = new OrderResource(orderRepository);
            //Force browsers to reload all js and html files for every request as angular gets screwed up
    environment.servlets()
    .addFilter("CacheBustingFilter", new CacheBustingFilter())
    .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

enableCorsHeaders(environment);

        environment.jersey().register(menuResource);
        environment.jersey().register(orderResource);
    }   
    private void enableCorsHeaders(Environment env) {
        final FilterRegistration.Dynamic cors = env.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

    
}