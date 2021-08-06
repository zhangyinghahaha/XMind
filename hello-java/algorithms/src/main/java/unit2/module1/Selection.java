package unit2.module1;

import util.In;

public class Selection {
    private static int compareCount = 0;
    private static int exchangeCount = 0;

    public static void sort(Comparable[] a) {
        // 升序排列
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // 将a[i]和a[i+1.. n]中最小的元素交换
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
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
