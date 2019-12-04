package tij.unit14;

/**
 * AnImplementation class
 *
 * @author ying.zhang01
 * @date 2019/11/29
 */
public class AnImplementation implements AnInterface {
    @Override
    public void firstMethod() {
        System.out.println("firstMethod");
    }

    @Override
    public void secondMethod() {
        System.out.println("secondMethod");
    }

    public static void main(String[] args) {
        AnInterface i = new AnImplementation();
        i.firstMethod();
        i.secondMethod();
        i.newMethod();
    }
}
