package ndj.no.entities;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brand")
@Data
@ToString(exclude = "lstShoes")
public class Brand {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brandName")
    private String name;

    @Column(name = "brandDesc")
    private String desc;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Shoe> lstShoes;
}
