package counter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class SynchronizedCounter {
    private int counter;
    private AtomicLong atomicLongCounter = new AtomicLong();

    public static final Object obj = new Object();

    public Thread getIncrementatorThread() {
        Thread incrementatorThread = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                synchronized (obj) {
                    counter++;
                }
            }
        }
        );
        return incrementatorThread;
    }

    public Thread getDecrementatorThread() {
        Thread decrementatorThread = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                synchronized (obj) {
                    counter--;
                }
            }
        }
        );
        return decrementatorThread;
    }

    public Thread getAtomicDecrementatorThread() {
        Thread decrementatorThread = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                atomicLongCounter.decrementAndGet();
            }
        }
        );
        return decrementatorThread;
    }

    public Thread getAtomicIncrementatorThread() {
        Thread incrementatorThread = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                atomicLongCounter.incrementAndGet();
            }
        }
        );
        return incrementatorThread;
    }

    public int getCounter() {
        return counter;
    }

    public AtomicLong getAtomicLongCounter() {
        return atomicLongCounter;
    }
    public  void countWithAtomic() {

        long start = System.currentTimeMillis();
        getAtomicIncrementatorThread().start();
        getAtomicDecrementatorThread().start();

        try {
            getAtomicIncrementatorThread().join();
            getAtomicDecrementatorThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
try {
    Thread.sleep(100);
} catch (InterruptedException e) {
    e.printStackTrace();
}
        System.out.println("AtomicLong counter : " + getAtomicLongCounter() + " time : " + (end - start));
    }

    public  void countWithSync() {
        long start = System.currentTimeMillis();
        getIncrementatorThread().start();
        getDecrementatorThread().start();
        try {
            getIncrementatorThread().join();
            getDecrementatorThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sync counter : " + getCounter() + " time : " + (end - start));
    }

}
