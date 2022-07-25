import dao.PremierDao;
import liquibase.pro.packaged.T;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import service.PremierList;
import service.PremierService;
import service.TicketService;
import dao.PremierDao;
import repository.PremierRepository;
import repository.TicketRepository;
import service.PremierList;
import service.TicketService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        final PremierService premierService = ctx.getBean(PremierService.class);
        final TicketService ticketService = ctx.getBean(TicketService.class);
        ctx.getBean(PremierList.class).addPremier();
        premierService.addPremier("Spartak", "Ballet", 12, 500, 500);
        premierService.addPremier("Boris Godunov", "Opera", 12, 500, 500);
        premierService.showAllPremier();
        premierService.showPremier("Spartak");
        premierService.editPremier("Spartak", "Ballet", 6, 350, 600);
        premierService.deletePremier("Spartak");
        ticketService.buyTicket("Spartak", String.valueOf(236));
        ticketService.returnTicket("Spartak", String.valueOf(236));
        System.out.println(ctx.getBean(PremierList.class).showAllPremier());
        System.out.println(ctx.getBean(PremierList.class).showOnePremier("Opera"));
        System.out.println(ctx.getBean(PremierList.class).updatePremier());
    }

        @Bean
        public PremierDao PremierDaoData(TicketRepository ticketRepository, PremierRepository premierRepository) {
            return new PremierDao(premierRepository, ticketRepository);
    }
}



