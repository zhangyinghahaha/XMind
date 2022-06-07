package com.nowcoder.community;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTests {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Thread prod = new Thread(new Producer(queue));
        prod.start();
        Thread cons1 = new Thread(new Consumer(queue));
        cons1.start();
    }
}

class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                Thread.sleep(20);
                queue.put(i);
                System.out.println(Thread.currentThread().getName() + "生产: " + queue.size());
            }
            System.out.println("生产完毕");
        } catch (InterruptedException e) {
            System.out.println("生产失败！");
        }
    }
}

class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(400);
                queue.take();
                System.out.println(Thread.currentThread().getName() + "消费: " + queue.size());
            }
        } catch (InterruptedException e) {
            System.out.println("消费失败！");
        }
    }
}
