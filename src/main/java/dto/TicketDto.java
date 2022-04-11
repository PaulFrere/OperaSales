package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDto {
    @JsonProperty
    private Integer id;

    @JsonProperty
    private int price;

    @JsonProperty
    private String eventName;

    @JsonProperty
    private Integer eventId;
}
