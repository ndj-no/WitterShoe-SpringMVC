package ndj.no.entities;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@ToString(exclude = "lstShoes")
public class Category {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "categoryName")
    private String name;

    @Column(name = "categoryThumbnail")
    private String thumb;

    @Column(name = "categoryDesc")
    private String desc;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Shoe> lstShoes;

}
