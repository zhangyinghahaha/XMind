package util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Test class
 *
 * @author ying.zhang01
 * @date 2019/8/3
 */
public class Test {
    public static void main(String[] args) {
        String test = "a=123&b=12+4";
        try {
            String encodeTest = URLEncoder.encode(test, "UTF-8");
            String decodeTest = URLDecoder.decode(encodeTest, "UTF-8");

            System.out.println(test);
            System.out.println(encodeTest);
            System.out.println(decodeTest);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    static class InnerClass {
        private int a;
    }

    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }
}

class InnerClass2 {
    protected int b;
}