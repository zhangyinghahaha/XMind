package algorithms.unit1.module3;

public class Josephus {

    public static void josephusProblem(int m, int n) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < m; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < n; i++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");
        }
    }

    public static void main(String[] args) {
        josephusProblem(7, 2);
    }
}
