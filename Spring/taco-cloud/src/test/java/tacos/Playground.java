package tacos;

import java.util.ArrayList;
import java.util.List;

public class Playground {
    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        List<String> bList = new ArrayList<>();

        aList.add("a");
        aList.add("b");

        aList.forEach(bList::add);

        System.out.println(bList);
    }
}
