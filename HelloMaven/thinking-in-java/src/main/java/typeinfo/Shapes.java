package typeinfo;

import java.util.ArrayList;
import java.util.List;
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
    }
}
