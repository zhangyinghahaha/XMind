package unit9;

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
    Implementationl() {};

    @Override
    public void method1() {
        System.out.println("Implementationl method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementationl method2");
    }
}

class ImplementationlFactory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementationl();
    }
}

class Implementation2 implements Service {
    Implementation2() {};

    @Override
    public void method1() {
        System.out.println("Implementation2 method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 method2");
    }
}

class Implementation2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new Implementation2();
    }
}

/**
 * Factories class
 *
 * @author ying.zhang01
 * @date 2019/4/8
 */
public class Factories {
    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new ImplementationlFactory());
        serviceConsumer(new Implementation2Factory());
    }
}
