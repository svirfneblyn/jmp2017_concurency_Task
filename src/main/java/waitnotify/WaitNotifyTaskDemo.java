package waitnotify;

import datastorage.SomeDataContainer;
import waitnotify.runnables.ARunnable;
import waitnotify.runnables.BRunnable;
import waitnotify.runnables.CRunnable;
import waitnotify.runnables.DRunnable;
import waitnotify.service.DataContainerService;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class WaitNotifyTaskDemo {

    private static final Object obj = new Object();
    private static final Object lockA = new Object();
    private static final Object lockC = new Object();
    private static final Object lockB = new Object();


    public static void main(String[] args) {
        SomeDataContainer container = new SomeDataContainer();
        DataContainerService service = new DataContainerService(container);


        Thread aThread = new Thread(new ARunnable(service, container, lockA));
        Thread bThread = new Thread(new BRunnable(service, container, lockB));
        Thread threadC = new Thread(new CRunnable(service, container, lockA, lockC));
        Thread dThread = new Thread(new DRunnable(service, container, lockB, lockC));
        aThread.start();
        bThread.start();
        threadC.start();
        dThread.start();
    }

}
/*
* Parameter 'a' successfully updated 1
  Parameter 'b' successfully updated 4
  Parameter 'c' successfully updated 10
  Parameter 'd' successfully updated 14
*
* */
