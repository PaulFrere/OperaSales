package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Event {
    private Integer id;
    private String name;
    List<Ticket> ticket;
}
