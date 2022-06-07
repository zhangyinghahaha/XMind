package unit12;

class A extends Exception {
    public A () {}

    public A(String msg) {
        super(msg);
    }
}

class B extends Exception {
    public B () {}

    public B(String msg) {
        super(msg);
    }
}

class C extends Exception {
    public C () {}

    public C(String msg) {
        super(msg);
    }
}

class Animal {
    public static int i = 1;
    public Animal()  {
        //throw new A();
    }

}

class Dog extends Animal {
    public static int i = 2;
    public Dog()  {
        //throw new B();
    }
}


/**
 * Exercise class
 *
 * @author ying.zhang01
 * @date 2019/5/20
 */
public class Exercise {
    public static void f(Animal animal){
        //throw new A();
        //throw new B();
        //throw new C();
        //System.out.println(animal.i);
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        f(animal);
        f(dog);
    }
}
