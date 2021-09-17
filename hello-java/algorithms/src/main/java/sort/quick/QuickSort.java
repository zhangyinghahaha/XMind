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
        int i = lo;
        int j = hi + 1;
        // 切分元素
        Comparable v = a[lo];

        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            //
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        // 将v = a[j]放入正确的位置, a[lo..j-1] <= a[j] <= a[j+1..hi]
        exch(a, lo, j);

        return j;
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
