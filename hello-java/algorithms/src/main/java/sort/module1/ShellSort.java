package sort.module1;

import utils.In;

/**
 * @author zhangying
 */
public class ShellSort extends SortBase {
    private static int compareCount = 0;
    private static int exchangeCount = 0;

    /**
     * 升序排列
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n/3) {
            h = 3*h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for(int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h = h/3;
        }
    }


    public static void main(String[] args) {
        SortBase sortBase = new ShellSort();
        String[] a = In.readStrings();

        System.out.println("排序前: ");
        sortBase.show(a);

        sortBase.sort(a);
        System.out.println("是否排序:" + sortBase.isSorted(a));
        System.out.println("Compare Count: " + sortBase.compareCount);
        System.out.println("Exchange Count: " + sortBase.exchangeCount);

        System.out.println("排序后:");
        sortBase.show(a);
    }
}
