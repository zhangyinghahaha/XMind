package unit14;

interface Callable {
    void call(String s);
}

class Describe {
    void show(String msg) {
        System.out.println(msg);
    }
}

/**
 * MethodReferences class
 *
 * @author ying.zhang01
 * @date 2019/9/9
 */
public class MethodReferences {
    static void hello(String name) {
        System.out.println("Hello, " + name);
    }
    static class Description {
        String about;
        Description(String desc) {
            about = desc;
        }
        void help(String msg) {
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show;
        c.call("call()");

        c = MethodReferences::hello;
        c.call("Bob");
    }
}
