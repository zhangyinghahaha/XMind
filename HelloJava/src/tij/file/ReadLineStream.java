package tij.file;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadLineStream {
    public static void main(String[] args) throws Exception {
        Files.lines(Paths.get("src/tij/file/Cheese.txt"))
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
