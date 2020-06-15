package ndj.no.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
@ToString(exclude = "shoe")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "imageDesc")
    private String desc;

    @Column(name = "shoeImage")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_id")
    private Shoe shoe;
}
