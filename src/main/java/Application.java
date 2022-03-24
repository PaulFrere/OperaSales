import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import service.PremierService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        final PremierService premierService = ctx.getBean(PremierService.class);
        premierService.addPremier("Spartak", "Ballet", 12, 500, 500);
        premierService.addPremier("Boris Godunov", "Opera", 12, 500, 500);
        premierService.showAllPremier();
        premierService.showPremier("Spartak");
    }
}
