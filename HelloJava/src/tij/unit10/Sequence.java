package tij.unit10;

import java.util.ArrayList;
import java.util.List;

interface Iterator {
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
    private List<Object> items;
    private int next = 0;

    public Sequence(int size) {
        items = new ArrayList<>();
    }
    public void add(Object x) {
        if(next < items.size()) {
            items.add(x);
        }
    }

    private class SequenceSelector implements Iterator {
        private int i = 0;

        @Override
        public boolean end() {
            return i==items.size();
        }
        @Override
        public Object current() {
            return items.get(i);
        }
        @Override
        public void next() {
            if(i < items.size()) {
                i++;
            }
        }
        public Sequence getOuter() {
            return Sequence.this;
        }
    }

    private class ReverseSelector implements Iterator {
        private int i = items.size() - 1;

        @Override
        public boolean end() {
            return i==items.size()-1;
        }
        @Override
        public Object current() {
            return items.get(i);
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

    public Iterator iterator() {

        return new SequenceSelector();
    }

    public Iterator reverseSelector() {
        return new ReverseSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for(int i=0; i < 10; i++) {
            sequence.add(new Animal("dog "+Integer.toString(i)));
        }
        Iterator selector = sequence.iterator();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
