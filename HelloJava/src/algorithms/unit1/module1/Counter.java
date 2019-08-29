package algorithms.unit1.module1;

import algorithms.util.StdOut;

/**
 * Counter class
 *
 * @author ying.zhang01
 * @date 2019/8/22
 */
public class Counter {
    private final String name;
    private int count;

    public Counter(String id) {
        this.name = id;
    }

    public void increment() {
        count++;
    }
    public int tally() {
        return count;
    }
    @Override
    public String toString() {
        return count + " " + name;
    }

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        
        heads.increment();
        heads.increment();
        tails.increment();

        StdOut.println(heads + " " + tails);
    }
}
