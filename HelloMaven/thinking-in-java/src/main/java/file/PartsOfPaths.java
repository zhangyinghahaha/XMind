package file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * PartsOfPaths class
 *
 * @author ying.zhang01
 * @date 2020/1/13
 */
public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PartsOfPaths.java").toAbsolutePath();
        System.out.println(p);
        System.out.println(Files.exists(p));

        for (int i = 0; i < p.getNameCount(); i++) {
            System.out.print(p.getName(i) + " ");
        }
        System.out.println();

        System.out.println("ends with '.java': " + p.endsWith(".java"));

        for (Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }
        System.out.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
    }
}
