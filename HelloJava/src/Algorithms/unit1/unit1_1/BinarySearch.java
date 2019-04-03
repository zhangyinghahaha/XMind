package Algorithms.unit1.unit1_1;

import Algorithms.util.In;
import Algorithms.util.StdIn;
import Algorithms.util.StdOut;

import java.util.Arrays;

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
        int[] whitelist = {12, 454, 67, 34, 767, 78};
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if(rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
    }
}
