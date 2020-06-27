package ndj.no.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.OrderItem;

@Data
@ToString(exclude = {"detailShoeModel", "orderPackageModel"})
@NoArgsConstructor
public class OrderItemModel {

    private int id;

    private int quantity;

    private long price;

    private DetailShoeModel detailShoeModel;

    private OrderPackageModel orderPackageModel;

    public OrderItemModel(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.detailShoeModel = new DetailShoeModel(orderItem.getDetailShoe());
        this.orderPackageModel = new OrderPackageModel(orderItem.getOrderPackage());
    }
}
