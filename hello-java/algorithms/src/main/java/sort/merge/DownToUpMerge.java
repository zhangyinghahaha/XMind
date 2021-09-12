package sort.merge;

import sort.simple.AbstractSort;

/**
 * @author zhangying
 */
public class DownToUpMerge extends AbstractSort {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        // 一次性分配空间
        aux = new Comparable[a.length];

        int length = a.length;
        for (int subSize = 1; subSize < length; subSize = 2*subSize) {
            for (int lo = 0; lo < length - subSize; lo = lo + 2*subSize) {
                int mid = lo + subSize - 1;
                int hi = Math.min(lo+2*subSize-1, length-1);
                merge(a, lo, mid, hi);
            }
        }
    }

    private void sort(Comparable[] a,int lo, int hi) {

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
        AbstractSort abstractSort = new DownToUpMerge();
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
