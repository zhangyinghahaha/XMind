package unit11;

import java.util.*;

/**
 * PriorityQueueDemo class
 *
 * @author zhangying
 * @date 2019/5/3
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random rand = new Random(47);
        for(int i = 0; i < 10; i++) {
            priorityQueue.offer(rand.nextInt(i + 10));
        }
        System.out.println(priorityQueue);
        for(int i = 0; i < 10; i++) {
            priorityQueue.remove();
        }
        System.out.println(priorityQueue);

        PriorityQueue<Object> priorityQueue1 = new PriorityQueue<>();
        priorityQueue1.offer(new Dog2());
        priorityQueue1.offer(new Dog2());
        System.out.println(priorityQueue1);

    }
}

class Dog2 {}
