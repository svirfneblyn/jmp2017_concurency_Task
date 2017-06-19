package waitnotify.runnables;

import datastorage.SomeDataContainer;
import waitnotify.service.DataContainerService;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class BRunnable implements Runnable {
    private DataContainerService dataContainerService;
    private SomeDataContainer container;
    private final Object lockB;

    public BRunnable(DataContainerService dataContainerService, SomeDataContainer container, Object lockB) {
        this.dataContainerService = dataContainerService;
        this.container = container;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        try {
            setParam(dataContainerService.b());
            System.out.println("Parameter 'b' successfully updated " + container.getB());
        } finally {
            synchronized (lockB) {
                lockB.notify();
            }
        }
    }

    private void setParam(int param) {
        container.setB(param);
    }
}
