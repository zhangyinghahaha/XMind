package unit2.module2;

/**
 * @author ying.zhang01
 */
public class UpToDownMerge {
    // 归并所需的辅助数组
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        // 一次性分配空间
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        // 将数组a[lo.. hi]排序
        if (hi <= lo) {
            return;
        }

        // 寻找中间值 mid = (lo + hi)/2 = lo + (hi - lo)/2, 防止值溢出
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 原地归并
     * 将a[lo.. mid] 和 a[mid+1.. hi]排序合并
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
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

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
