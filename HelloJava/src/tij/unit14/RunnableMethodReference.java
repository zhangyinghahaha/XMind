package tij.unit14;

class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}

/**
 * RunnableMethodReference class
 *
 * @author ying.zhang01
 * @date 2019/9/9
 */
public class RunnableMethodReference {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(
                () -> System.out.println("lambda")
        ).start();

        new Thread(Go::go).start();
    }
}
