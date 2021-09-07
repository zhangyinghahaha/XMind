package basic.module3;

import java.util.Iterator;

/**
 * ResizingArrayStack class
 *
 * @author ying.zhang01
 * @date 2019/11/5
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    private void resize(int max) {

    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
