package unit9;

import java.util.Arrays;


public class Apply {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static String s = "a a A a";

    public static void main(String[] args) {

    }
}
