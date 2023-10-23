import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;


@Getter
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private String occupation;
    private Integer salary;
    private Timestamp joinDate;
}
