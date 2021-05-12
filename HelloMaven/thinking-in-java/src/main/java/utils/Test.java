package utils;

class Person {
    int age = 12;
    private String name = "person";
}

interface Person2 {
    int age = 12;
    void name();
}

class Student2 implements Person2 {
    public Student2() {
        super();
        //super.name();
        //System.out.println(super.age);
        System.out.println("student2");
    }

    @Override
    public void name() {
        System.out.println("zhang");
    }
}

class Student extends Person {
    int age = 18;
    void display() {
        System.out.println("学生年龄：" + super.age);
    }
}

public class Test {
    public static void main(String[] args) {
        Student2 s = new Student2();
        s.name();
    }
}
