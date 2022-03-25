package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "opera")
@Proxy(lazy=false)
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq")
    private Integer id;

    @Column(name = "price")
    private int price;

    @JoinColumn(name = "event_id")
    @ManyToOne
    private EventEntity event;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    @Override
    public String toString(){
        return "TicketEntity{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
