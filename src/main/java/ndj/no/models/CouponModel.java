package ndj.no.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.Coupon;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString(exclude = {"lstOrderPackageModels", "desc"})
@NoArgsConstructor
public class CouponModel {

    private Integer id;

    private String title;

    private String code;

    private Timestamp expirationDate;

    private Integer discountRate;

    private Integer discountAmount;

    private Integer amount;

    private String desc;

    private List<OrderPackageModel> lstOrderPackageModels;

    public CouponModel(Coupon coupon) {
        this.id = coupon.getId();
        this.title = coupon.getTitle();
        this.code = coupon.getCode();
        this.expirationDate = coupon.getExpirationDate();
        this.discountRate = coupon.getDiscountRate();
        this.discountAmount = coupon.getDiscountAmount();
        this.amount = coupon.getAmount();
        this.desc = coupon.getDesc();
        if (Hibernate.isInitialized(coupon.getLstOrderPackages()))
            this.lstOrderPackageModels = coupon.getLstOrderPackages()
                    .stream()
                    .map(OrderPackageModel::new)
                    .collect(Collectors.toList());
    }
}
