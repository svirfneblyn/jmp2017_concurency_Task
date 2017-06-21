package gc;

import gc.runnable.WorkerRunnable;
import gc.service.LinkedEntityCreator;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class ShowGC {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task2 = new WorkerRunnable(new LinkedEntityCreator());

        executor.scheduleWithFixedDelay(task2, 0, 1, TimeUnit.SECONDS);
    }
}