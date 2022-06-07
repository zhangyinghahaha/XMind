package sort.merge;

import sort.simple.AbstractSort;

/**
 * @author ying.zhang01
 */
public class UpToDownMerge extends AbstractSort {

    // 归并所需的辅助数组
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        // 一次性分配空间
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    private void sort(Comparable[] a,int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo)/2;
        // 将左半边排序
        sort(a, lo, mid);
        // 将右半边排序
        sort(a, mid+1, hi);
        // 归并结果
        merge(a, lo, mid, hi);
    }

    /**
     * 原地归并
     * 将a[lo.. mid] 和 a[mid+1.. hi]合并
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        // 将a[lo.. hi]复制到aux[lo.. hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // 归并到a[lo.. hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if(j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new UpToDownMerge();
        // String[] a = In.readStrings();
        String[] a = new String[]{"1", "3", "2", "5", "2"};

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
