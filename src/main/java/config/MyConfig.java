package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.PremierService;
import service.TicketService;

@Configuration
public class MyConfig {

    @Bean
    public PremierService PremierRepo(){
        return new PremierService();
    }

    @Bean
    public TicketService TicketService(PremierService repository){
        return new TicketService(repository);
    }
}
