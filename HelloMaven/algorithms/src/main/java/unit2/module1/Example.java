package unit2.module1;

import util.In;

public class Example {
    private static int compareCount = 0;
    private static int exchangeCount = 0;

    public static void sort(Comparable[] a) {

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
        show(a);
        sort(a);
        //System.out.println(isSorted(a));
        show(a);
        System.out.println("Compare Count: " + compareCount);
        System.out.println("Exchange Count: " + exchangeCount);
    }
}
