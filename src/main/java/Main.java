import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import repository.PremierRepo;
import service.TicketService;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class);
        ctx.getBean(PremierRepo.class).addPremier();
        ctx.getBean(PremierRepo.class).removePremier();
        ctx.getBean(PremierRepo.class).showPremiers();
        ctx.getBean(PremierRepo.class).showOnePremier(ctx.getApplicationName());
        ctx.getBean(ctx.getBean(TicketService.class).buyTicket("Spartak", 5));
        ctx.getBean(ctx.getBean(TicketService.class).returnTicket("Spartak", 5));
    }
}
