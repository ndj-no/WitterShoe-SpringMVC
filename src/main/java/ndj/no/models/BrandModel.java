package ndj.no.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.Brand;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString(exclude = {"lstShoeModels"})
@NoArgsConstructor
public class BrandModel {

    private int id;

    private String name;

    private String desc;

    private List<ShoeModel> lstShoeModels;

    public BrandModel(Brand brand) {
        this.id = brand.getId();
        this.name = brand.getName();
        this.desc = brand.getDesc();
        if (Hibernate.isInitialized(brand.getLstShoes()))
            this.lstShoeModels = brand.getLstShoes().stream().map(ShoeModel::new).collect(Collectors.toList());
    }
}
