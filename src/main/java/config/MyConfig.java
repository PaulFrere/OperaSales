package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repository.PremierRepo;
import service.TicketService;

@Configuration
public class MyConfig {

    @Bean
    public PremierRepo PremierRepo(){
        return new PremierRepo();
    }

    @Bean
    public TicketService TicketService(PremierRepo repository){
        return new TicketService(repository);
    }
}
