package ndj.no.entities;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "order_package")
@Data
@ToString(exclude = {"coupon", "user", "lstOrderItems"})
public class OrderPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dateOrder")
    @CreationTimestamp
    private Timestamp dateOrder;

    @Column(name = "dateDelivery")
    private Timestamp dateDelivery;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "receiverNumber")
    private String receiverNumber;

    @Column(name = "receiverAddress")
    private String receiverAddress;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private int status;

    @Column(name = "totalPayment")
    private long totalPayment;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "orderPackage")
    private List<OrderItem> lstOrderItems;
}
