package ndj.no.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "color")
@Data
@ToString(exclude = "lstDetailShoes")
public class Color {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "colorName")
    private String name;

    @Column(name = "colorDesc")
    private String desc;

    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
    private List<DetailShoe> lstDetailShoes;
}
