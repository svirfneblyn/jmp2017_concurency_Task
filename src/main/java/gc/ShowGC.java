package gc;

import gc.runnable.LargeObjectRunnable;
import gc.runnable.WorkerRunnable;
import gc.service.LargeObjectCreator;
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

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);

        Runnable task2 = new WorkerRunnable(new LinkedEntityCreator());
        Runnable task1 = new LargeObjectRunnable(new LargeObjectCreator());

           executor.scheduleWithFixedDelay(task2, 0, 1, TimeUnit.SECONDS);
           executor.scheduleWithFixedDelay(task1, 0, 1, TimeUnit.SECONDS);
    }
}