package ndj.no.entities;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "detail_shoe")
@Data
@ToString(exclude = {"color", "shoe", "lstCarts", "lstOrderItems"})
public class DetailShoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "size")
    private int size;

    @Column(name = "quantityAvailable")
    private int quantityAvailable;

    @Column(name = "oldPrice")
    private long oldPrice;

    @Column(name = "newPrice")
    private long newPrice;

    @Column(name = "detailShoeDesc")
    private String desc;

    @ManyToOne
    @JoinColumn(name = "shoe_id")
    private Shoe shoe;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @OneToMany(mappedBy = "detailShoe")
    private List<Cart> lstCarts;

    @OneToMany(mappedBy = "detailShoe")
    private List<OrderItem> lstOrderItems;
}
