import config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import service.PremierService;
import service.TicketService;

@Import(MyConfig.class)
public class Application {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);
        ctx.getBean(PremierService.class).addPremier();
        ctx.getBean(PremierService.class).removePremier();
        ctx.getBean(PremierService.class).showPremiers();
        ctx.getBean(PremierService.class).showOnePremier(ctx.getApplicationName());
        ctx.getBean(ctx.getBean(TicketService.class).buyTicket("Spartak", 5));
        ctx.getBean(ctx.getBean(TicketService.class).returnTicket("Spartak", 5));
    }
}
