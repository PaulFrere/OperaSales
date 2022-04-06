import entity.Premier;
import liquibase.pro.packaged.T;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import service.PremierService;
import service.TicketService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        final PremierService premierService = ctx.getBean(PremierService.class);
        final TicketService ticketService = ctx.getBean(TicketService.class);
        premierService.addPremier("Spartak", "Ballet", 12, 500, 500);
        premierService.addPremier("Boris Godunov", "Opera", 12, 500, 500);
        premierService.showAllPremier();
        premierService.showPremier("Spartak");
        premierService.editPremier("Spartak", "Ballet", 6, 350, 600);
        premierService.deletePremier("Spartak");
        ticketService.buyTicket("Spartak", 236);
        ticketService.returnTicket("Spartak", 236);
    }
}
