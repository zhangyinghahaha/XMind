package unit2.module1;

import utils.In;

import java.text.MessageFormat;

/**
 * @author zhangying
 */
public class SortBase {
    protected int compareCount = 0;
    protected int exchangeCount = 0;

    /**
     * 升序排列
     * @param a
     */
    public void sort(Comparable[] a) {

    }

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
    protected void show(Comparable[] a) {
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

    public static void main(String[] args) {
        SortBase sortBase = new SortBase();
        // String[] a = In.readStrings();
        String[] a = new String[]{"1", "3", "2"};

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
