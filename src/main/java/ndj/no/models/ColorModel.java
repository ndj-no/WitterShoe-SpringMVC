package ndj.no.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.Color;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.stream.Collectors;


@Data
@ToString(exclude = {"lstDetailShoeModels", "desc"})
@NoArgsConstructor
public class ColorModel {

    private Integer id;

    private String name;

    private String desc;

    private List<DetailShoeModel> lstDetailShoeModels;

    public ColorModel(Color color) {
        this.id = color.getId();
        this.name = color.getName();
        this.desc = color.getDesc();
        if (Hibernate.isInitialized(color.getLstDetailShoes()))
            this.lstDetailShoeModels = color.getLstDetailShoes()
                    .stream()
                    .map(DetailShoeModel::new)
                    .collect(Collectors.toList());
    }
}
