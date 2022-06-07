package sort.pq;

import sort.simple.AbstractSort;
import sort.simple.InsertionSort;
import utils.In;

/**
 * 堆排序
 * @author zhangying
 */
public class HeapSort extends AbstractSort {
    @Override
    public void sort(Comparable[] a) {
        int size = a.length - 1;
        // 堆构造
        for (int k = size/2; k > 0; k--) {
            sink(a, k, size);
        }

        // 下沉排序
        while (size > 1) {
            exch(a, 1, size);
            sink(a, 1, --size);
        }
    }

    private void sink(Comparable[] a, int k, int n) {
        while (2*k <= n) {
            int maxChild = 2*k;
            if (2*k < n && less(a[2*k], a[2*k + 1])) {
                maxChild = 2*k + 1;
            }

            if (!less(a[k], a[maxChild])) {
                break;
            }
            exch(a, k, maxChild);
            k = maxChild;
        }
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new HeapSort();
        String[] a = new String[]{"0", "3", "2", "5", "2", "1"};

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
