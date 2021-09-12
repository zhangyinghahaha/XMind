package utils;


import sort.simple.InsertionSort;
import sort.simple.SelectionSort;
import sort.simple.ShellSort;

/**
 * @author zhangying
 */
public class SortCompare {
    public static double time(String alg, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        switch (alg) {
            case "Insert":
                InsertionSort insertionSort = new InsertionSort();
                insertionSort.sort(a);
                break;
            case "Select":
                SelectionSort selectionSort = new SelectionSort();
                selectionSort.sort(a);
                break;
            case "Shell":
                ShellSort shellSort = new ShellSort();
                shellSort.sort(a);
            default:
                break;
        }
        return timer.elapsedTime();
    }

    /**
     * 使用算法alg将T个长度为N的数组排序
     *
     * @param alg 算法名称
     * @param N 数组长度
     * @param T 数组数量
     * @return 排序总时间
     */
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        int arraySize = 100;
        int arrayNum = 1000;
        double t1 = timeRandomInput("Select", arraySize, arrayNum);
        double t2 = timeRandomInput("Insert", arraySize, arrayNum);
        double t3 = timeRandomInput("Shell", arraySize, arrayNum);
        System.out.println("Select: " + t1);
        System.out.println("Insert: " + t2);
        System.out.println("Shell: " + t3);
        System.out.println("Select/Insert: " + t1/t2);
        System.out.println("Inset/Shell: " + t2/t3);
    }
}
