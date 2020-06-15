package ndj.no.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Data
@ToString(exclude = {"detailShoe", "orderPackage"})
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "itemPrice")
    private long price;

    @ManyToOne
    @JoinColumn(name = "detailShoe_id")
    private DetailShoe detailShoe;

    @ManyToOne
    @JoinColumn(name = "orderPackage_id")
    private OrderPackage orderPackage;
}
