package waitnotify.runnables;

import datastorage.SomeDataContainer;
import waitnotify.service.DataContainerService;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class DRunnable implements Runnable {

    private DataContainerService dataContainerService;
    private SomeDataContainer container;
    private final Object lockB;
    private final Object lockC;

    public DRunnable(DataContainerService dataContainerService, SomeDataContainer container, Object lockB, Object lockC) {
        this.dataContainerService = dataContainerService;
        this.container = container;
        this.lockB = lockB;
        this.lockC = lockC;
    }

    @Override
    public void run() {

        try {
            synchronized (lockC) {
                if (container.getC() == 0) {
                    lockC.wait(1000);
                }
            }
            synchronized (lockB) {

                if (container.getB() == 0) {
                    lockB.wait(1000);
                }
            }
            setParam(dataContainerService.d(container.getC() , container.getB()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
                System.out.println("Parameter 'd' successfully updated " + container.getD());
        }
    }

    private void setParam(int param) {
        container.setD(param);
    }

}