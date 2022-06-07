package file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Writing {
    static Random rand = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws Exception {
        byte[] bytes = new byte[SIZE];
        rand.nextBytes(bytes);
        Files.write(Paths.get("test/Hello.txt"), bytes);
        System.out.println("Hello.txt: " + Files.size(Paths.get("test/Hello.txt")));

        List<String> lines = Files.readAllLines(Paths.get("test/Cheese.txt"));
        Files.write(Paths.get("test/Cheese.dat"), lines);
        System.out.println("Cheese.data: " + Files.size(Paths.get("test/Cheese.dat")));
    }
}
