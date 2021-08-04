package stream;

import java.util.Comparator;

/**
 * SortedComparator class
 *
 * @author ying.zhang01
 * @date 2019/12/10
 */
public class SortedComparator {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("C:\\Users\\ying.zhang01\\Desktop\\temp\\Study Materials\\Java\\XMind\\HelloJava\\src\\tij\\stream\\Cheese.dat")
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
