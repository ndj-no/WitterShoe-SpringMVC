package ndj.no.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.DetailShoe;

import java.util.List;

@Data
@ToString(exclude = {"colorModel", "shoeModel", "lstCartModels", "lstOrderItemModels"})
@NoArgsConstructor
public class DetailShoeModel {

    private int id;

    private int size;

    private int quantityAvailable;

    private long oldPrice;

    private long newPrice;

    private String desc;

    private ShoeModel shoeModel;

    private ColorModel colorModel;

    private List<CartModel> lstCartModels;

    private List<OrderItemModel> lstOrderItemModels;

    public DetailShoeModel(DetailShoe detailShoe) {
        this.id = detailShoe.getId();
        this.size = detailShoe.getSize();
        this.quantityAvailable = detailShoe.getQuantityAvailable();
        this.oldPrice = detailShoe.getOldPrice();
        this.newPrice = detailShoe.getNewPrice();
        this.desc = detailShoe.getDesc();
        this.shoeModel = new ShoeModel(detailShoe.getShoe());
        this.colorModel = new ColorModel(detailShoe.getColor());
//        if (Hibernate.isInitialized(detailShoe.getLstCarts()))
//            this.lstCartModels = detailShoe.getLstCarts().stream()
//                    .map(CartModel::new)
//                    .collect(Collectors.toList());
//        if (Hibernate.isInitialized(detailShoe.getLstOrderItems()))
//            this.lstOrderItemModels = detailShoe.getLstOrderItems().stream()
//                    .map(OrderItemModel::new)
//                    .collect(Collectors.toList());
    }
}
