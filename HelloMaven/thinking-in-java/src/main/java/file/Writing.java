package file;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Writing {
    static Random rand = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws Exception {
        byte[] bytes = new byte[SIZE];
        rand.nextBytes(bytes);
        Files.write(Paths.get("src/tij/file/bytes.dat"), bytes);
        System.out.println("bytes.dat: " + Files.size(Paths.get("src/tij/file/bytes.dat")));

        List<String> lines = Files.readAllLines(Paths.get("src/tij/stream/Cheese.dat"));
        Files.write(Paths.get("src/tij/file/Cheese.txt"), lines);
        System.out.println("Cheese.txt: " + Files.size(Paths.get("src/tij/file/Cheese.txt")));
    }
}
