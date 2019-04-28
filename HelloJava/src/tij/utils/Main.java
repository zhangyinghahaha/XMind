package tij.utils;

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
        String input = "";
        LinkedList<Character> linkedList = new LinkedList<Character>();
        //Collections.addAll(linkedList, {'c'});


        Stack<Character> stack = new Stack<Character>();
        for(Character s : input.toCharArray()){
            if(s == '+'){

            }else if(s == '-') {

            }
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
