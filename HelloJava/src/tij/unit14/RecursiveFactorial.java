package tij.unit14;

/**
 * RecursiveFactorial class
 *
 * @author ying.zhang01
 * @date 2019/9/9
 */
public class RecursiveFactorial {
    static IntCall fact;

    public static void main(String[] args) {
        fact = n -> n == 0 ? 1 : n * fact.call(n -1);
        for(int i = 0; i <= 10; i++) {
            System.out.println(fact.call(i));
        }
    }
}
