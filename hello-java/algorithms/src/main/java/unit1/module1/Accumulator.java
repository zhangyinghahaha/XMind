package unit1.module1;

import util.StdIn;
import util.StdOut;
import util.StdRandom;


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
