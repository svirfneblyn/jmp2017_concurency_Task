package waitnotify.service;

import datastorage.SomeDataContainer;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class DataContainerService {

    private SomeDataContainer dataConteiner;

    public DataContainerService(SomeDataContainer dataConteiner) {
        this.dataConteiner = dataConteiner;
    }

    /**
     * @return hardcoded int 1
     */
    public int a() {
        try {
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * Multiplies parameter by 10.
     *
     * @param a int
     * @return hardcoded a*10 int
     */
    public int c(int a) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a * 10;
    }

    /**
     * Sets d parameter in storage container to sum c and b.
     *
     * @param c int
     * @param b int
     * @return sum c + b int
     */
    public int d(int c, int b ) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c + b;
    }

    /**
     *
     * @return hardcoded int
     */
    public int b() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 4;
    }
}
