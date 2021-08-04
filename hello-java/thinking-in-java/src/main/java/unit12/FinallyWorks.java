package unit12;

class ThreeException extends Exception {}

/**
 * FinallyWorks class
 *
 * @author ying.zhang01
 * @date 2019/5/21
 */
public class FinallyWorks {
    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                if(count++ == 0) {
                    throw new ThreeException();
                }
                System.out.println("No Exception.");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if(count == 2) {
                    break;
                }
            }
        }
    }
}
