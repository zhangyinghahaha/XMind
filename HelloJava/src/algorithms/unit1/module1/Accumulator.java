package algorithms.unit1.module1;

import algorithms.util.StdIn;
import algorithms.util.StdOut;
import algorithms.util.StdRandom;

/**
 * Accumulator class
 *
 * @author ying.zhang01
 * @date 2019/8/29
 */
public class Accumulator {
    private double total;
    private int N;

    public void addDataValue(double val) {
        this.N++;
        this.total += val;
    }
    public double mean() {
        return this.total/this.N;
    }
    @Override
    public String toString() {
        return "Mean (" + this.N + " values): " + String.format("%7.5f", this.mean());
    }

    public static void main(String[] args) {
        while(!StdIn.isEmpty()) {
            int T = StdIn.readInt();
            Accumulator a = new Accumulator();
            for(int t = 0; t < T; t++) {
                a.addDataValue(StdRandom.uniform());
            }
            StdOut.println(a);
        }

    }
}
