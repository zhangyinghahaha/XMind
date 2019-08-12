package tij.utils;

import com.sun.deploy.util.ArrayUtil;
import tij.unit10.Animal;
import tij.unit10.ClassInInterface;
import tij.unit9.Months;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
        String a = "Templates_636963720321412898_uMR 安装维修部件交接单X2.pdf";
        String test = "0123456789";
        int len = 2;

        while(test.length()>len) {
            String childStr = test.substring(0, 2);
            System.out.println("childStr:" + childStr);
            test = test.substring(len);
            System.out.println("test:" + test);
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
