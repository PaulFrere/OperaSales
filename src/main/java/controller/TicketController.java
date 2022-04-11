package controller;

import dto.Ticket;
import dto.TicketDto;
import entity.TicketEntity;
import mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private TicketService ticketService;
    private Mapper mapper;

    @Autowired
    public TicketController(TicketService ticketService, Mapper mapper){
        this.ticketService = ticketService;
        this.mapper = mapper;
    }

    @PostMapping
    public Integer create(@RequestBody TicketDto ticketDto){
        Ticket ticket = mapper.toDomain(ticketDto);
        TicketEntity ticketEntity = mapper.toEntity(ticket);
        return ticketService.byTicket(ticketEntity);
    }
}
