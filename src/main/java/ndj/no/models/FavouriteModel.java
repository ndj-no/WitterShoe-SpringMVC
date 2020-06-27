package ndj.no.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.Favourite;

import java.sql.Timestamp;


@Data
@ToString(exclude = {"shoeModel", "userModel"})
@NoArgsConstructor
public class FavouriteModel {

    private int id;

    private Timestamp dateLike;

    private ShoeModel shoeModel;

    private UserModel userModel;

    public FavouriteModel(Favourite favourite) {
        this.id = favourite.getId();
        this.dateLike = favourite.getDateLike();
        this.shoeModel = new ShoeModel(favourite.getShoe());
        this.userModel = new UserModel(favourite.getUser());
    }
}
