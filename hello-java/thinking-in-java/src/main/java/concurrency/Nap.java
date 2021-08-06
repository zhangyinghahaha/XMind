package concurrency;

import java.util.concurrent.TimeUnit;

public class Nap {
    public Nap(double t) {
        try {
            TimeUnit.MILLISECONDS.sleep((int)(1000*t));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Nap(double t, String msg) {
        this(t);
        System.out.println(msg);
    }
}
