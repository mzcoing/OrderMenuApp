import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import repository.MenuRepository;
import resources.MenuResource;

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

        environment.jersey().register(menuResource);
    }
}
