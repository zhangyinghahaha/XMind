package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathWatcher {
    static Path test = Paths.get("test");

    static void delTxtFiles() {
        try {
            Files.walk(test)
                    .filter(f -> f.toString().endsWith(".txt"))
                    .forEach(f -> {
                        try {
                            System.out.println("deleting " + f);
                            Files.delete(f);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
