package pinger;

public class Counter {
    private int c = 0;

    public synchronized int increment() {
        return c++;
    }

}
