package file;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ListOfLines {
    public static void main(String[] args) throws Exception {
        Files.readAllLines(Paths.get("test/Cheese.txt")).stream()
                .filter(line -> !line.startsWith("//"))
                //.map(line -> line.substring(0, line.length()/2))
                .forEach(System.out::println);
    }
}
