import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import repository.MenuRepository;
import repository.OrderRepository;
import repository.ItemRepository;
import resources.MenuResource;
import resources.OrderResource;
import resources.ItemResource;

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

        final ItemRepository itemRepository = new ItemRepository();

        final ItemResource itemResource = new ItemResource(itemRepository);

        environment.jersey().register(menuResource);
        environment.jersey().register(orderResource);
        environment.jersey().register(itemResource);
    }

    
}
