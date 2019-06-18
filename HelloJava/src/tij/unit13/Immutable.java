package tij.unit13;

/**
 * Immutable class
 *
 * @author ying.zhang01
 * @date 2019/6/18
 */
public class Immutable {
    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void add (int i) {
        i++;
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        System.out.println(q);
    }
}
