package tij.unit14;

import java.lang.reflect.Field;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {}
    Toy(int i) {}

    int i;
    String name;
}

class TestToy extends Toy {
    TestToy() {
        super(1);
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots{
    FancyToy() {
        super(1);
    }
}

/**
 * ToyTest class
 *
 * @author ying.zhang01
 * @date 2019/5/27
 */
public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    static void printSuperClass(Object o) {
        //if(o != null) {

            Class superClass = o.getClass().getSuperclass();
            System.out.println(superClass);
            for(Field field : superClass.getDeclaredFields()) {
                System.out.println(field.getName());
            }
            if(!superClass.getSimpleName().equals("Object")) {
                try {
                    printSuperClass(superClass.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        //}
    }

    public static void main(String[] args) {
        FancyToy fancyToy = new FancyToy();
        char[] chars = {'a', 'b', 'c'};
        printSuperClass(chars);
//        FancyToy fancyToy = new FancyToy();
//        System.out.println(fancyToy.getClass());
//        Toy toy = fancyToy;
//        System.out.println(toy.getClass());
//        if(toy instanceof TestToy) {
//            TestToy testToy = (TestToy)toy;
//        }
//
//        Class c = null;
//        try {
//            c = Class.forName("tij.unit14.FancyToy");
//
//        } catch (ClassNotFoundException e) {
//            System.out.println("Can't find FancyToy");
//            System.exit(1);
//        }
//        printInfo(c);
//        for(Class face : c.getInterfaces()) {
//            printInfo(face);
//        }
//        Class up = c.getSuperclass();
//        Object obj = null;
//        try {
//            obj = up.newInstance();
//        } catch (InstantiationException e) {
//            System.out.println("Cannot instantiate");
//            System.exit(1);
//        } catch (IllegalAccessException e) {
//            System.out.println("Cannot access");
//            System.exit(1);
//        }
//        printInfo(obj.getClass());
    }
}
