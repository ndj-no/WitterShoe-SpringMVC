package ndj.no.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ndj.no.entities.User;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ToString(exclude = {"password", "dateJoined", "lastLogin", "lstCartModels", "lstFavouriteModels", "lstOrderPackageModels"})
@NoArgsConstructor
public class UserModel {

    private Integer id;

    private String username;

    private String password;

    private String displayName;

    private String email;

    private String phone;

    private String defaultAddress;

    private Integer gender;

    //    @Column(name = "is_superuser")
//    private Boolean isSuperuser;

    private Boolean isStaff;

    private Boolean isActive;

    private Timestamp dateJoined;

    private Timestamp lastLogin;

    private List<CartModel> lstCartModels;

    private List<FavouriteModel> lstFavouriteModels;

    private List<OrderPackageModel> lstOrderPackageModels;

    public UserModel(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.displayName = user.getDisplayName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.defaultAddress = user.getDefaultAddress();
        this.gender = user.getGender();
        this.isActive = user.getIsActive();
        this.isStaff = user.getIsStaff();
        this.dateJoined = user.getDateJoined();
        this.lastLogin = user.getLastLogin();

        if (Hibernate.isInitialized(user.getLstCarts()))
            this.lstCartModels = user.getLstCarts().stream()
                    .map(CartModel::new)
                    .collect(Collectors.toList());

        if (Hibernate.isInitialized(user.getLstFavourites()))
            this.lstFavouriteModels = user.getLstFavourites().stream()
                    .map(FavouriteModel::new)
                    .collect(Collectors.toList());

        if (Hibernate.isInitialized(user.getLstOrderPackages()))
            this.lstOrderPackageModels = user.getLstOrderPackages().stream()
                    .map(OrderPackageModel::new)
                    .collect(Collectors.toList());
    }
}
