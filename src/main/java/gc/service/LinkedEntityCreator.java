package gc.service;

import gc.entity.LinkedEntity;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class LinkedEntityCreator {

    private static volatile AtomicLong id = new AtomicLong(0);

    public LinkedEntity getEntity(Long perviousId) {
        Long entityId = id.incrementAndGet();
        String name = "Entity_" + (String.valueOf(entityId));
        return new LinkedEntity()
                .setId(id.incrementAndGet())
                .setName(name)
                .setPreviousId(perviousId);
    }
}
