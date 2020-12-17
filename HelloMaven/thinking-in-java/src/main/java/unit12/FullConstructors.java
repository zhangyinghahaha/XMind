package unit12;

class MyException extends Exception {
    public MyException() {}

    public MyException(String msg) {
        super(msg);
    }
}


/**
 * FullConstructors class
 *
 * @author ying.zhang01
 * @date 2019/5/17
 */
public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        Integer i = null;
        Boolean flag = true;
        //FullConstructors.f();
        while (flag) {
            try{
                System.out.println(i.toString());
                flag = false;
            }catch (Exception e){
                e.printStackTrace(System.out);
                i = 1;
            }finally {
                System.out.println("finally");
            }
        }

    }
}
