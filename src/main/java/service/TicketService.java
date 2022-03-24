package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TicketService {
    private final ConsoleLogger logger;
    private final PremierServiceImpl premierService;

    @Autowired
    public TicketService(ConsoleLogger logger, PremierServiceImpl premierService){
        this.logger = logger;
        this.premierService = premierService;
    }
}
