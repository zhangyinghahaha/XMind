package unit11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * QueueDemo class
 *
 * @author ying.zhang01
 * @date 2019/4/29
 */
public class QueueDemo {
    public static void printQ(Queue queue) {
        while(queue.peek() != null) {
            System.out.println(queue.remove() + " ");
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(47);
        for(int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i + 10));
        }
        printQ(queue);
    }
}
