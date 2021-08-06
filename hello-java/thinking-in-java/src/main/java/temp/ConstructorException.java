package temp;

class CE extends Exception {}

class SecondExcept extends Reporter {
    SecondExcept() throws CE {
        super();
        throw new CE();
    }
}

/**
 * ConstructorException class
 *
 * @author ying.zhang01
 * @date 2020/1/8
 */
public class ConstructorException {
    public static void main(String[] args) {
        try(
                First f = new First();

                Second s2 = new Second();
                ) {
            System.out.println("In body");
            SecondExcept s = new SecondExcept();
            System.out.println("End body");
        } catch (CE e) {
            System.out.println("Caught: " + e);
        }
    }
}
