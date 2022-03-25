package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "event")
@Proxy(lazy = false)
public class EventEntity {
    public EventEntity(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_seq")
    @SequenceGenerator(name = "events_seq", sequenceName = "events_seq")
    private Integer id;


    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public String getName(){return name;}

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private Collection<TicketEntity> tickets;

    @Column(name = "name")
    private String name;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(String.format("%s (%d)\n", name, id));
        for (TicketEntity ticket : tickets){
            sb.append(ticket).append("\n");
        }
        return sb.toString();
    }
}
