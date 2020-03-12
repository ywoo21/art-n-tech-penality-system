package artntech.system.penalty.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_advantage")
public class UserAdvantage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private int advantageId;
    private LocalDateTime registeredTime;
}
