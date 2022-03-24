package config;

import org.springframework.context.annotation.Bean;
import service.ConsoleLogger;
import service.Logger;

public class LoggerConfig {
    @Bean
    public Logger logger(){
        return new ConsoleLogger();
    }
}
