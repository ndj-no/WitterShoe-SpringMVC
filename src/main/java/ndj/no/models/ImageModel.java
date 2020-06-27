package ndj.no.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.Image;

@Data
@ToString(exclude = {"shoeModel", "desc"})
@NoArgsConstructor
public class ImageModel {
    private int id;

    private String desc;

    private String url;

    private ShoeModel shoeModel;

    public ImageModel(Image image) {
        this.id = image.getId();
        this.desc = image.getDesc();
        this.url = image.getUrl();
        this.shoeModel = new ShoeModel(image.getShoe());
    }
}
