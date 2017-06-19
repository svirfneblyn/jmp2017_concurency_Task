package waitnotify.runnables;

import datastorage.SomeDataContainer;
import waitnotify.service.DataContainerService;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class ARunnable implements Runnable {
    private DataContainerService dataContainerService;
    private SomeDataContainer container;
    private final Object lockA;

    public ARunnable(DataContainerService dataContainerService, SomeDataContainer container, Object lockA) {
        this.dataContainerService = dataContainerService;
        this.container = container;
        this.lockA = lockA;
    }

    @Override
    public void run() {
        try {
            setParam(dataContainerService.a());
            System.out.println("Parameter 'a' successfully updated " + container.getA());

        } finally {
            synchronized (lockA) {
                lockA.notify();
            }
        }
    }

    private void setParam(int param) {
        container.setA(param);
    }
}
