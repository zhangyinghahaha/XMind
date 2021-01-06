package String;

import java.io.PrintStream;
import java.util.Formatter;

public class Turtle {
    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)%n", name, x, y);
    }

    public static void main(String[] args) {
//        PrintStream outAlias = System.out;
//        Turtle tommy = new Turtle("Tommy", new Formatter(outAlias));
//        tommy.move(0, 0);
//        String a = "a";

        System.out.println(String.format("%s The Turtle is at (%d,%d)%n", "String Format", 0, 0));
    }
}
