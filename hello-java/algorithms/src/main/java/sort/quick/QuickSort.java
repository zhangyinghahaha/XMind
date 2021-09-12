package sort.quick;

import sort.simple.AbstractSort;
import utils.In;
import utils.StdRandom;

/**
 * 快速排序
 *
 * @author zhangying
 */
public class QuickSort extends AbstractSort {

    @Override
    public void sort(Comparable[] a) {
        // 打乱数组，消除对输入的依赖
        // StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        // 切分
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j+1, hi);
    }

    /**
     * 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private int partition(Comparable[] a, int lo, int hi) {
        // 左右扫描指针
        int i = lo + 1;
        int j = hi;
        // 切分元素
        Comparable key = a[lo];

        for (;i < j;i++) {
            if (less(key, a[i])) {
                for (;j > i; j--) {
                    if (less(a[j], key)) {
                        exch(a, i, j);
                        break;
                    }
                }
            }
            if (i == j) {
                break;
            }
        }

        exch(a, lo, i - 1);

        return i - 1;
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new QuickSort();
        Integer[] a = new Integer[]{5, 2, 1, 6, 3};

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
