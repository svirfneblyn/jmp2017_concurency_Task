package gc.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
@Data
@Accessors(chain = true)
public class LargeObject {
    private byte[] largeObgect;
    private LargeObject perviousObj;
}