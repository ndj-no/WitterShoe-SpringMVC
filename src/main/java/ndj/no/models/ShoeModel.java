package ndj.no.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.Shoe;

import java.sql.Timestamp;
import java.util.List;

@Data
@ToString(exclude = {"desc", "brandModel", "categoryModel", "lstDetailShoeModels", "lstFavouriteModels", "lstImageModels"})
@NoArgsConstructor
public class ShoeModel {

    public static final String DATE_CREATED = "dateCreated";
    public static final String DATE_MODIFIED = "dateModified";
    public static final String QUANTITY_SOLD = "quantitySold";
    public static final String VIEW_COUNT = "viewCount";
    public static final String FAVOURITE_COUNT = "favouriteCount";

    private int id;

    private String name;

    private String thumb;

    private Boolean isActive;

    private int quantitySold;

    private int viewCount;

    private int favouriteCount;

    private Timestamp dateCreated;

    private Timestamp dateModified;

    private String desc;

    private String imageStatic;

    private String model;

    private CategoryModel categoryModel;

    private BrandModel brandModel;

    private List<DetailShoeModel> lstDetailShoeModels;

    private List<FavouriteModel> lstFavouriteModels;

    private List<ImageModel> lstImageModels;

    public ShoeModel(Shoe shoe) {
        this.id = shoe.getId();
        this.name = shoe.getName();
        this.thumb = shoe.getThumb();
        this.isActive = shoe.getIsActive();
        this.quantitySold = shoe.getQuantitySold();
        this.viewCount = shoe.getViewCount();
        this.favouriteCount = shoe.getFavouriteCount();
        this.dateCreated = shoe.getDateCreated();
        this.dateModified = shoe.getDateModified();
        this.desc = shoe.getDesc();
        this.imageStatic = shoe.getImageStatic();
        this.model = shoe.getModel();
        this.categoryModel = new CategoryModel(shoe.getCategory());
        this.brandModel = new BrandModel(shoe.getBrand());

//        if (Hibernate.isInitialized(shoe.getLstDetailShoe()))
//            this.lstDetailShoeModels = shoe.getLstDetailShoe().stream()
//                    .map(DetailShoeModel::new)
//                    .collect(Collectors.toList());
//
//        if (Hibernate.isInitialized(shoe.getLstFavourites()))
//            this.lstFavouriteModels = shoe.getLstFavourites().stream()
//                    .map(FavouriteModel::new)
//                    .collect(Collectors.toList());
//
//        if (Hibernate.isInitialized(shoe.getLstImages()))
//            this.lstImageModels = shoe.getLstImages().stream()
//                    .map(ImageModel::new)
//                    .collect(Collectors.toList());
    }
}
