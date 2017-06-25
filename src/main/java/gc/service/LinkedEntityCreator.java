package gc.service;

import gc.entity.LinkedEntity;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class LinkedEntityCreator {

    private static volatile AtomicLong id = new AtomicLong(0);

    public LinkedEntity getEntity(LinkedEntity perviousEntity) {
        Long entityId = id.incrementAndGet();
        String name = "Entity_" + (String.valueOf(entityId));
        return new LinkedEntity()
                .setId(id.incrementAndGet())
                .setName(name)
                .setPerviousEntity(perviousEntity
                .setLinkedEntityId(ThreadLocalRandom.current().nextLong()));
    }
}
