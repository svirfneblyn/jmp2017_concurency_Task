package waitnotify.runnables;

import datastorage.SomeDataContainer;
import waitnotify.WaitNotifyTaskDemo;
import waitnotify.service.DataContainerService;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class CRunnable implements Runnable {

    private DataContainerService dataContainerService;
    private SomeDataContainer container;
    private final Object lockA;
    private final Object lockC;

    public CRunnable(DataContainerService dataContainerService, SomeDataContainer container, Object lockA, Object lockC) {
        this.dataContainerService = dataContainerService;
        this.container = container;
        this.lockA = lockA;
        this.lockC = lockC;
    }

    @Override
    public void run() {

        try {
            synchronized (lockA) {
                if (container.getA() == 0) {
                    lockA.wait(1000);
                }
            }
            setParam(dataContainerService.c(container.getA()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            synchronized (lockC) {
                lockC.notify();
                System.out.println("Parameter 'c' successfully updated " + container.getC());
            }
        }
    }

    private void setParam(int param) {
        container.setC(param);
    }
}
