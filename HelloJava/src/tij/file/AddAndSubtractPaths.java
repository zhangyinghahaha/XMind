package tij.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddAndSubtractPaths {
    static Path base = Paths.get("..", "..", "..").toAbsolutePath().normalize();

    static void show(int id, Path result) {
        if (result.isAbsolute()) {
            System.out.println("(" + id + ")r " + base.relativize(result));
        } else {
            System.out.println("(" + id + ") " + result);
        }

        try {
            System.out.println("RealPath: " + result.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(base);
        System.out.println();

        Path p = Paths.get("AddAndSubtractPaths.java").toAbsolutePath();
        System.out.println(p);
        show(1, p);
        System.out.println();

        Path convoluted = p.getParent().getParent().resolve("strings").resolve("..").resolve(p.getParent().getFileName());
        show(2, convoluted);
        show(3, convoluted.normalize());
    }
}
