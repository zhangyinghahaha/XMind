package tij.unit10;

interface Selector {
    boolean end();
    Object current();
    void next();
}

/**
 * Sequence class
 *
 * @author ying.zhang01
 * @date 2019/4/10
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if(next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i==items.length;
        }
        @Override
        public Object current() {
            return items[i];
        }
        @Override
        public void next() {
            if(i < items.length) {
                i++;
            }
        }
        public Sequence getOuter() {
            return Sequence.this;
        }
    }

    private class ReverseSelector implements Selector {
        private int i = items.length - 1;

        @Override
        public boolean end() {
            return i==items.length-1;
        }
        @Override
        public Object current() {
            return items[i];
        }
        @Override
        public void next() {
            if(i > 0) {
                i--;
            }
        }
        public Sequence getOuter() {
            return Sequence.this;
        }
    }

    public Selector selector() {

        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new ReverseSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i=0; i < 10; i++) {
            sequence.add(new Animal("dog "+Integer.toString(i)));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
