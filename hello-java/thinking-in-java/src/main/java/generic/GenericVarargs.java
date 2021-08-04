package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {

    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("a", "b");
        System.out.println(ls);
    }
}
