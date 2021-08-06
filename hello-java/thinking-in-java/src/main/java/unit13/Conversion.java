package unit13;

import java.util.Formatter;

/**
 * Conversion class
 *
 * @author ying.zhang01
 * @date 2019/6/26
 */
public class Conversion {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);

        char u = 'a';
        System.out.println("u = 'a'");
        f.format("s: %s\n", u);
    }
}
