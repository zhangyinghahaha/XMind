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
    public static void main(String[] args) {
        String inputStr = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+~+r+u--+l+e+s---";
        char[] strArray = inputStr.toCharArray();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < strArray.length; i++) {
            if(strArray[i] == '+'){
                i++;
                stack.push(strArray[i]);
            }else if(strArray[i] == '-') {
                System.out.print(stack.pop());
            }
        }
    }
}
