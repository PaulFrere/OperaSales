package mapper;

import dto.Event;
import dto.EventDto;
import dto.Ticket;
import dto.TicketDto;
import entity.EventEntity;
import entity.TicketEntity;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    EventDto toDto(Event event);
    Event toDomain(EventDto eventDto);
    EventEntity toEntity(Event event);
    Event toDomain(EventEntity eventEntity);
    TicketDto toDto(Ticket ticket);
    Ticket toDomain(TicketDto ticketDto);
    TicketEntity toEntity(Ticket ticket);
    Ticket toDomain(TicketEntity ticketEntity);
}
