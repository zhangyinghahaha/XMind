package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadSize {
    static class Dummy extends Thread {
        @Override
        public void run() {
            new Nap(1);
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int count = 0;
        try {
            while (true) {
                executorService.execute(new Dummy());
                count++;
            }
        } catch (Error error) {
            System.out.println(error.getClass().getSimpleName() + ": " + count);
        } finally {
            executorService.shutdown();
        }
    }
}
