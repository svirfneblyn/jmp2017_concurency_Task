import counter.CounterHolder;
import counter.DecrementatorThread;
import counter.IncrementatorThread;
import counter.SynchronizedCounter;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class CounterTaskDemo {

    public static void main(String[] args) {
        SynchronizedCounter syncCounter = new SynchronizedCounter();
        syncCounter.countWithAtomic();
        syncCounter.countWithSync();
    }


}
/*
* output :
*
* increment cycle done count = 1537203
decrement cycle done count = 1804779
AtomicLong counter : 0 time : 37
Sync counter : 0 time : 0
counter = 1804779
* */