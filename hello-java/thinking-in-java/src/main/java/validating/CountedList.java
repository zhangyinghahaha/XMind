// validating/CountedList.java
// Keeps track of how many of itself are created.
package validating;
import java.util.*;

/**
 * @author ying.zhang01
 */
public class CountedList extends ArrayList<String> {
    private static int counter = 0;
    private int id = counter++;
    public CountedList() {
        System.out.println("CountedList #" + id);
    }
    public int getId() { return id; }
}
