package sort.simple;

import utils.In;

/**
 * @author zhangying
 */
public class InsertionSort extends AbstractSort {
    /**
     * 升序排列
     * @param a
     */
    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // 将a[i]插入到a[i-1]、a[i-2]、a[i-3]...a[0]之中
            // 基于交换操作
            for (int j = i; j > 0 && less(a[j], a[j-1]) ; j--) {
                exch(a, j, j-1);
            }
        }
    }


    public static void main(String[] args) {
        AbstractSort abstractSort = new InsertionSort();
        String[] a = In.readStrings();

        System.out.println("排序前: ");
        abstractSort.show(a);

        abstractSort.sort(a);
        System.out.println("是否排序:" + abstractSort.isSorted(a));
        System.out.println("Compare Count: " + abstractSort.compareCount);
        System.out.println("Exchange Count: " + abstractSort.exchangeCount);

        System.out.println("排序后:");
        abstractSort.show(a);
    }
}
