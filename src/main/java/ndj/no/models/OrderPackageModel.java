package ndj.no.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.OrderPackage;

import java.sql.Timestamp;
import java.util.List;


@Data
@ToString(exclude = {"couponModel", "userModel", "lstOrderItemModels"})
@NoArgsConstructor
public class OrderPackageModel {

    private int id;

    private Timestamp dateOrder;

    private Timestamp dateDelivery;

    private String receiver;

    private String receiverNumber;

    private String receiverAddress;

    private String note;

    private int status;

    private long totalPayment;

    private CouponModel couponModel;

    private UserModel userModel;

    private List<OrderItemModel> lstOrderItemModels;

    public OrderPackageModel(OrderPackage orderPackage) {
        this.id = orderPackage.getId();
        this.dateOrder = orderPackage.getDateOrder();
        this.dateDelivery = orderPackage.getDateDelivery();
        this.receiver = orderPackage.getReceiver();
        this.receiverNumber = orderPackage.getReceiverNumber();
        this.receiverAddress = orderPackage.getReceiverAddress();
        this.note = orderPackage.getNote();
        this.status = orderPackage.getStatus();
        this.totalPayment = orderPackage.getTotalPayment();
        this.couponModel = new CouponModel(orderPackage.getCoupon());
        this.userModel = new UserModel(orderPackage.getUser());
    }
}
