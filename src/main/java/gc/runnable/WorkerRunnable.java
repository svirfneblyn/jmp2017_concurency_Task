package gc.runnable;

import gc.entity.LinkedEntity;
import gc.service.LinkedEntityCreator;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class WorkerRunnable implements Runnable {
    private static LinkedEntity linkedEntity;
    private LinkedEntityCreator creator;
    private static Map<String, LinkedEntity> linkedEntityMap = new ConcurrentHashMap<>();

    public WorkerRunnable(LinkedEntityCreator creator) {
        this.creator = creator;
    }

    @Override
    public void run() {
        Long previousId = 0L;

        for (int i = 0; i < 100000000; i++) {
            linkedEntity = creator.getEntity(previousId);
            previousId = linkedEntity.getId();
            linkedEntityMap.put(linkedEntity.getName(), linkedEntity);
        }
        System.out.println("job done. Created map with " + linkedEntityMap.size() + " entities");
    }
}
