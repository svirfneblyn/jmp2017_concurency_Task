package gc.runnable;

import gc.entity.LargeObject;
import gc.entity.LinkedEntity;
import gc.service.LargeObjectCreator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class LargeObjectRunnable implements Runnable {
    private LargeObject largeObject = new LargeObject();
    private LargeObjectCreator creator;
    private static Map<String, LargeObject> linkedEntityMap = new ConcurrentHashMap<>();

    public LargeObjectRunnable(LargeObjectCreator creator) {
        this.creator = creator;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            largeObject = creator.getLargeObject(largeObject);
            linkedEntityMap.put(largeObject.toString(), largeObject);
        }
    }
}
