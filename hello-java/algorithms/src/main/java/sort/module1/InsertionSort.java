package sort.module1;

import utils.In;

/**
 * @author zhangying
 */
public class InsertionSort extends SortBase {


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
        SortBase sortBase = new InsertionSort();
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
