package tij.unit11;

import java.util.*;

class Apple {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}

class Orange {

}

/**
 * ApplesAndOrangesWithoutGenerics class
 *
 * @author ying.zhang01
 * @date 2019/4/25
 */
public class ApplesAndOrangesWithoutGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for(int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        //apples.add(new Orange());
        for(int i = 0; i < apples.size(); i++) {
            apples.get(i).id();
        }
    }
}
