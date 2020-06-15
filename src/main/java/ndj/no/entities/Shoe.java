package ndj.no.entities;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "shoe")
@Data
@ToString(exclude = {"desc", "brand", "category", "lstDetailShoe", "lstFavourites", "lstImages"})
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "shoeName")
    private String name;

    @Column(name = "shoeThumbnail")
    private String thumb;

    @Column(name = "active")
    private Boolean isActive;

    @Column(name = "quantitySold")
    private int quantitySold;

    @Column(name = "viewCount")
    private int viewCount;

    @Column(name = "favouriteCount")
    private int favouriteCount;

    @Column(name = "dateCreated")
    @CreationTimestamp
    private Timestamp dateCreated;

    @Column(name = "dateModified")
    @UpdateTimestamp
    private Timestamp dateModified;

    @Column(name = "shoeDesc")
    private String desc;

    @Column(name = "image_static")
    private String imageStatic;

    @Column(name = "shoeModel")
    private String model;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "shoe")
    private List<DetailShoe> lstDetailShoe;

    @OneToMany(mappedBy = "shoe")
    private List<Favourite> lstFavourites;

    @OneToMany(mappedBy = "shoe")
    private List<Image> lstImages;
}
