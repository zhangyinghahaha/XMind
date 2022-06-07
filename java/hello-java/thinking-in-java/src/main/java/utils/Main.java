package utils;

import unit10.Animal;
import unit10.ClassInInterface;
import unit9.Months;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Main class
 *
 * @author ying.zhang01
 * @date 2019/4/8
 */
public class Main {

    private static void hi() {
        System.out.println("Hi");
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, null, 3, 4, null, 5);
        nums.stream().filter(num -> {
            System.out.println(num);
            return num != null;
        }).count();

        List<String> collected = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collected);

        Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        Stream<Integer> outputStream = inputStream.flatMap(childList -> childList.stream());
        List<Integer> collected2 = outputStream.collect(Collectors.toList());
        System.out.println(collected2);

        Integer[] sixNums = {1,2,3,4,5,6};
        Integer[] evens = Stream.of(sixNums)
                .filter(n -> n%2 == 0)
                .toArray(Integer[]::new);
        for (Integer i : evens) {
            System.out.println(i);
        }
    }

    public static String substring(String str, Integer f, Integer t) {
        if (f > str.length())
        {return null;}
        if (t > str.length()) {
            return str.substring(f, str.length());
        } else {
            return str.substring(f, t);
        }
    }
}
