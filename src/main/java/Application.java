import entity.EventEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import service.EventService;
import service.PremierService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        ctx.getBean(EventService.class).editEvent(new EventEntity(1, "Spartak"));
        EventEntity e = ctx.getBean(EventService.class).getEventById(1);
        System.out.println(e);
    }
}
