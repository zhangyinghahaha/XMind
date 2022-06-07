package sort.simple;

/**
 * @author zhangying
 */
public abstract class AbstractSort {
    public int compareCount = 0;
    public int exchangeCount = 0;

    /**
     * 升序排列
     * @param a
     */
    public abstract void sort(Comparable[] a);

    /**
     * 比较两个元素大小
     * @param v
     * @param w
     * @return
     */
    protected boolean less(Comparable v, Comparable w) {
        compareCount++;
        return v.compareTo(w) < 0;
    }

    /**
     * 交换两个元素位置
     * @param a
     * @param i
     * @param j
     */
    protected void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
        exchangeCount++;
    }

    /**
     * 打印数组内容
     * @param a
     */
    public void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * 验证数组a是否有序
     * @param a
     * @return
     */
    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
