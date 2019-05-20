package tij.unit12;

/**
 * InheritingExceptions class
 *
 * @author ying.zhang01
 * @date 2019/5/17
 */
public class InheritingExceptions {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        }catch (SimpleException e) {
            System.out.println("Caught it!");
        }
    }
}

class SimpleException extends Exception {}
