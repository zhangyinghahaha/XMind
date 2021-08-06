package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0;i < 6;i++) {
            futures.add(i, es.submit(new Task2(String.valueOf(i))));
            System.out.println("try " + i + " isDone " + futures.get(i).isDone());
            System.out.println(futures.get(i).get());
            System.out.println("success " + i);
        }

        es.shutdown();

//        for (Future future : futures) {
//            System.out.println(future.get());
//        }
    }
}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("end task " + name);
    }
}

class Task2 implements Callable<String> {
    private final String name;

    public Task2(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        System.out.println("end task " + name);
        return "zhang ying " + name;
    }
}
