package tij.unit10;

/**
 * Factories class
 *
 * @author zhangying
 * @date 2019/4/18
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation2.factory);
    }
}

interface Service {
    /**
     * 接口method1
     */
    void method1();

    /**
     * 接口method2
     */
    void method2();
}

interface ServiceFactory {
    /**
     * 获取Service对象
     *
     * @return Service
     */
    Service getService();
}

class Implementationl implements Service {
    private Implementationl() {}

    @Override
    public void method1() {
        System.out.println("Implementationl method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementationl method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementationl();
        }
    };
}

class Implementation2 implements Service {
    private Implementation2() {}

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}
