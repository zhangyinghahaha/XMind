package tij.unit14;

import java.util.stream.Stream;

/**
 * Shape class
 *
 * @author ying.zhang01
 * @date 2019/9/2
 */
abstract class Shape {
    void draw() {
        System.out.println(this + ".draw()");
    }
    @Override
    abstract public String toString();

    public static void main(String[] args) {
        Stream.of(new Circle(), new Square()).forEach(Shape::draw);
    }
}

class Circle extends Shape {
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    @Override
    public String toString() { return "Square"; }
}
