package unit2.module1;

import util.In;

public class Example {
    private static int compareCount = 0;
    private static int exchangeCount = 0;

    /**
     * 升序排列
     * @param a
     */
    public static void sort(Comparable[] a) {

    }

    /**
     * 比较两个元素大小
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        compareCount++;
        return v.compareTo(w) < 0;
    }

    /**
     * 交换两个元素位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        exchangeCount++;
    }

    /**
     * 打印数组内容
     * @param a
     */
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 验证数组a是否有序
     * @param a
     * @return
     */
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
        System.out.println("排序前:");
        show(a);
        sort(a);
        System.out.println("排序后:");
        show(a);
        System.out.println("是否排序:" + isSorted(a));
        System.out.println("Compare Count: " + compareCount);
        System.out.println("Exchange Count: " + exchangeCount);
    }
}
