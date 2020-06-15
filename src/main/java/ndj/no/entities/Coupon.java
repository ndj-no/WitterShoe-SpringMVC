package ndj.no.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "coupon")
@Data
@ToString(exclude = {"lstOrderPackages"})
public class Coupon {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "couponTitle")
    private String title;

    @Column(name = "couponCode")
    private String code;

    @Column(name = "expirationDate")
    private Timestamp expirationDate;

    @Column(name = "discountRate")
    private Integer discountRate;

    @Column(name = "discountAmount")
    private Integer discountAmount;

    @Column(name = "couponAmount")
    private Integer amount;

    @Column(name = "couponDescription")
    private String desc;

    @OneToMany(mappedBy = "coupon")
    private List<OrderPackage> lstOrderPackages;
}
