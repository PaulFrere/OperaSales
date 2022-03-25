package controller;

import dto.Event;
import dto.EventDto;
import dto.Ticket;
import mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EventService;
import service.TicketService;

import java.util.Collection;
import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/event")
public class EventController {
    private EventService eventService;
    private TicketService ticketService;
    private Mapper mapper;

    @Autowired
    public EventController(EventService eventService, TicketService ticketService, Mapper mapper){
        this.eventService = eventService;
        this.ticketService = ticketService;
        this.mapper = mapper;
    }
    @GetMapping
    public Collection<EventDto> getEvents(){
        final List<Event> events = eventService.getList();
        return events.stream()
                .map(mapper::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    public EventDto get(@PathVariable("id") int id){
        final Event event = eventService.getEventById(id);
        final List<Ticket> tickets = ticketService.getETickets(event.getId());
        event.setTicket(tickets);
        return mapper.toDto(event);
    }

    @PutMapping
    public Integer create(@RequestBody EventDto eventDto){
        Event event = mapper.toDomain(eventDto);
        return eventService.addEvent(mapper.toEntity(event));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        eventService.deleteEvent(id);
    }

}
