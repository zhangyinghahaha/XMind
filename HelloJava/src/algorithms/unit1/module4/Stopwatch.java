package algorithms.unit1.module4;

public class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000;
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 100000; j++) {
                for (int k = 0; k < 100000; k++) {
                }
            }
        }
        System.out.println(timer.elapsedTime());
    }
}
