package unit2.module1;

import util.In;

public class Insertion {
    private static int compareCount = 0;
    private static int exchangeCount = 0;
    /**
     * 升序排列
     * @param a
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // 这种写法类似冒泡
            Comparable current = a[i];
            for (int j = i; j >= 0 ; j--) {
                //exch(a, j, j-1);
                if (j>0 && less(current, a[j-1])) {
                    a[j] = a[j-1];
                } else {
                    a[j] = current;
                    break;
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        compareCount++;
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        exchangeCount++;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        //System.out.println(isSorted(a));
        show(a);
        System.out.println("Compare Count: " + compareCount);
        System.out.println("Exchange Count: " + exchangeCount);
    }
}
