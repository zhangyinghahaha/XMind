package sort.module2;

import sort.module1.SortBase;

/**
 * @author zhangying
 */
public class DownToUpMerge extends SortBase {
    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        // 一次性分配空间
        aux = new Comparable[a.length];

        int i = 1;
        while (i < a.length) {
            for (int j=1; j) {
                merge(a, j, j+i/2,j+i);
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
}
