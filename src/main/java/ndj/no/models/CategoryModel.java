package ndj.no.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.Category;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.stream.Collectors;


@Data
@ToString(exclude = {"lstShoeModels", "desc"})
@NoArgsConstructor
public class CategoryModel {

    private int id;

    private String name;

    private String thumb;

    private String desc;

    private List<ShoeModel> lstShoeModels;

    public CategoryModel(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.thumb = category.getThumb();
        this.desc = category.getDesc();
        if (Hibernate.isInitialized(category.getLstShoes()))
            this.lstShoeModels = category.getLstShoes().stream().map(ShoeModel::new).collect(Collectors.toList());
    }

}
