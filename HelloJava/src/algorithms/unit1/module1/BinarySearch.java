package algorithms.unit1.module1;

import algorithms.util.In;
import algorithms.util.StdIn;
import algorithms.util.StdOut;

import java.util.Arrays;

/**
 * BinarySearch class
 *
 * 二分查找算法
 *
 * @author zhangying
 * @date 2019/04/07
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]){
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] whitelist = {12, 454, 67, 34, 767, 78};
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if(rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
//        int sum = 0;
//        while (!StdIn.isEmpty()) {
//            sum += StdIn.readDouble();
//            StdOut.println(sum);
//        }
    }
}

