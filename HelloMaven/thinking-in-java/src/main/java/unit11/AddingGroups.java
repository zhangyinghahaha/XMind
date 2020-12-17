package unit11;

import java.util.*;

/**
 * AddingGroups class
 *
 * @author ying.zhang01
 * @date 2019/4/25
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,  2, 3, 4, 5));

        Integer[] moreInts = {6, 7, 8, 9, 10};
        collection.addAll(Arrays.asList(moreInts));

        System.out.println(collection);
        //Collection.addAll();
    }
}
