package com.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ying.zhang01
 */
public class Main {
    public static void main(String[] args) {
        var list = List.of("java", "666");
        var copy = List.copyOf(list);
        System.out.println(list == copy);

        var list2 = new ArrayList<String>();
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2);
    }
}
