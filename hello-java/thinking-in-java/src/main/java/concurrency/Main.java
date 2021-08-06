package concurrency;

public class Main {
    public static volatile int count = 0;
    public static final Object lock = new Object();

    public static void main(String[] args) throws Exception {
        System.out.println("main start...");
        Thread add = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    count++;
                }
            }
        });
        Thread dec = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    count--;
                }
            }
        });
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println("Count: " + count);
        System.out.println("main end.");
    }
}
