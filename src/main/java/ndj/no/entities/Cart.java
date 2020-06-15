package ndj.no.entities;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Data
@ToString(exclude = {"detailShoe", "user"})
public class Cart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantityOnCart")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "detailShoe_id")
    private DetailShoe detailShoe;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
