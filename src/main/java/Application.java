import config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import repository.PremierRepo;
import service.TicketService;

@Import(MyConfig.class)
public class Application {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);
        ctx.getBean(PremierRepo.class).addPremier();
        ctx.getBean(PremierRepo.class).removePremier();
        ctx.getBean(PremierRepo.class).showPremiers();
        ctx.getBean(PremierRepo.class).showOnePremier(ctx.getApplicationName());
        ctx.getBean(ctx.getBean(TicketService.class).buyTicket("Spartak", 5));
        ctx.getBean(ctx.getBean(TicketService.class).returnTicket("Spartak", 5));
    }
}
