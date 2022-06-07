package sort.simple;

import utils.In;

/**
 * @author zhangying
 */
public class SelectionSort extends AbstractSort {

    @Override
    public void sort(Comparable[] a) {
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

    public static void main(String[] args) {
        AbstractSort abstractSort = new SelectionSort();
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
