package ndj.no.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.Cart;

@Data
@ToString
@NoArgsConstructor
public class CartModel {

    private int id;

    private int quantity;

    private DetailShoeModel detailShoeModel;

    private UserModel userModel;

    public CartModel(Cart cart) {
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.detailShoeModel = new DetailShoeModel(cart.getDetailShoe());
        this.userModel = new UserModel(cart.getUser());
    }
}
