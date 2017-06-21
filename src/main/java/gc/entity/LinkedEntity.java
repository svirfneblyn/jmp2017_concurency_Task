package gc.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
@Data
@Accessors(chain = true)
public class LinkedEntity {
    private Long id;
    private String name;
    private Long previousId;
}
