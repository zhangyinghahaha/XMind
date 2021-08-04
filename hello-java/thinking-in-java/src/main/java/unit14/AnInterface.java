package unit14;

/**
 * AnInterface interface
 *
 * @author ying.zhang01
 * @date 2019/11/29
 */
public interface AnInterface {
    void firstMethod();
    void secondMethod();
    default void newMethod() {
        System.out.println("newMenthod");
    }
}
