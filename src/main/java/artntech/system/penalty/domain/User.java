package artntech.system.penalty.domain;

import artntech.system.penalty.enums.UserType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String studentId;
    private String password;
    private UserType userType;
    private int score;
}
