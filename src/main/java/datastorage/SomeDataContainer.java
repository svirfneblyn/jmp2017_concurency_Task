package datastorage;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public class SomeDataContainer {
    private volatile int a;
    private volatile int b;
    private volatile int c;
    private volatile int d;

    public volatile boolean available;


    public SomeDataContainer() {
        available = false;
    }




    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "a =" + a + "b = " + b + " c =" + c+ " d = " + d;
    }
}
