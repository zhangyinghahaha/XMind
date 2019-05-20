package tij.unit12;

/**
 * Rethrowing class
 *
 * @author ying.zhang01
 * @date 2019/5/20
 */
public class Rethrowing {
    public static void f() throws Exception {
        System.out.println("Originating the exception in f()");
        throw new Exception("thrown from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g(), e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g(), e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception)e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }

        try {
            h();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
