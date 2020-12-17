package stream;

/**
 * Peeking class
 *
 * @author ying.zhang01
 * @date 2019/12/9
 */
public class Peeking {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("C:\\Users\\ying.zhang01\\Desktop\\temp\\Study Materials\\Java\\XMind\\HelloJava\\src\\tij\\stream\\Cheese.dat")
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);
    }
}
