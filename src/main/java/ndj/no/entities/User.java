package ndj.no.entities;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@ToString(exclude = {"password", "dateJoined", "lastLogin", "lstCarts", "lstFavourites", "lstOrderPackages"})
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "displayName", length = 100)
    private String displayName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "defaultAddress")
    private String defaultAddress;

    @Column(name = "gender")
    private Integer gender;

    //    @Column(name = "is_superuser")
//    private Boolean isSuperuser;
    @Column(name = "is_staff")
    private Boolean isStaff;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "date_joined")
    @CreationTimestamp
    private Timestamp dateJoined;

    @Column(name = "last_login")
    private Timestamp lastLogin;

    @OneToMany(mappedBy = "user")
    private List<Cart> lstCarts;

    @OneToMany(mappedBy = "user")
    private List<Favourite> lstFavourites;

    @OneToMany(mappedBy = "user")
    private List<OrderPackage> lstOrderPackages;
}
