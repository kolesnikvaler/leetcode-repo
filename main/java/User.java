import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user", schema = "app")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name", length = 100)
    private String name;
    @Column(name = "occupation", length = 100)
    private String occupation;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "join_date", nullable = false)
    private Timestamp joinDate;
}
