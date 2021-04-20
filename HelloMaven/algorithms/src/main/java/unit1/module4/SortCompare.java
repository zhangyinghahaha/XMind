package unit1.module4;

import unit2.module1.Insertion;
import unit2.module1.Selection;
import util.StdOut;
import util.StdRandom;
import util.Stopwatch;

public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        switch (alg) {
            case "Insertion":
                Insertion.sort(a);
                break;
            case "Selection":
                Selection.sort(a);
                break;
            default:
                break;
        }
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total/1000;
    }

    public static void main(String[] args) {
        System.out.println("Selection: " + timeRandomInput("Selection", 100000, 100));
        System.out.println("Insertion: " + timeRandomInput("Insertion", 100000, 100));
    }
}
