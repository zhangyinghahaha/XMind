package algorithms.unit1.module3;

/**
 * Queue implementation with a resizing arry.
 *
 * @author ying.zhang01
 */
public class ResizingArrayQueue<Item> {
    private final static int MIN_SIZE = 10;
    private Item[] q;

    ResizingArrayQueue() {
        q = (Item[]) new Object[MIN_SIZE];
    }

    public void enqueue(Item item) {
        
    }

    public Item dequeue() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return q.length;
    }
}
