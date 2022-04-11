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
@Table(name = "events")
@Proxy(lazy = false)
public class EventEntity {

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

    @Column(name = "name")
    private String name;

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(String.format("%s (%d)\n", name, id));
        return sb.toString();
    }
}
