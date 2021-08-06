package unit12;

/**
 * MultipleReturns class
 *
 * @author ying.zhang01
 * @date 2019/5/21
 */
public class MultipleReturns {
    public static void f(int i) {
        System.out.println("Initializtion that requires cleanup");
        try {
            System.out.println("Point 1");
            if(i == 1) {
                return;
            }
            System.out.println("Point 2");
            if(i == 2) {
                return;
            }
            System.out.println("End");
            return;
        } finally {
            System.out.println("Performing cleanup");
        }
        // System.out.println("");
    }

    public static void main(String[] args) {
        //for(int i = 1; i <= 4; i++) {
            f(1);
        //}
    }
}
