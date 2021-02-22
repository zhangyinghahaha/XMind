package typeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }

    @Override
    public abstract String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle";
    }
}

public class Shapes {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        Shape s = t;
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(t);
        int i = 1;
        Integer i2 = 1;
        Integer i3 = 1;
        System.out.println(i == i2);
        System.out.println(Objects.equals(i2, i3));
    }
}
