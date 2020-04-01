package tij.file;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AddAndSubtractPaths {
    static Path base = Paths.get("..", "..", "..").toAbsolutePath();

    public static void main(String[] args) {
        System.out.println(base);
    }
}
