package ndj.no.entities;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "favourite")
@Data
@ToString(exclude = {"shoe", "user"})
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_like")
    @CreationTimestamp
    private Timestamp dateLike;

    @ManyToOne
    @JoinColumn(name = "shoe_id")
    private Shoe shoe;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
