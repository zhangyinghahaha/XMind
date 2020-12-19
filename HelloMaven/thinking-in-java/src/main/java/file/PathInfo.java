package file;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * PathInfo class
 *
 * @author ying.zhang01
 * @date 2020/1/13
 */
public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    static void info(Path p) {
        System.out.println("----------------------------");
        show("toString", p);
        show("Exists", Files.exists(p));
        show("isRegularFile", Files.isRegularFile(p));
        show("isDirectory", Files.isDirectory(p));
        show("isAbsolute", p.isAbsolute());
        show("AbsolutePath", p.toAbsolutePath());
        show("FileName", p.getFileName());
        show("Parent", p.getParent());
        show("Root", p.getRoot());
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("thinking-in-java", "src", "main", "java", "file", "PathInfo.java");
        info(p);

        Path ap = p.toAbsolutePath();
        info(ap);

        try {
            info(p.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }

        URI u = p.toUri();
        System.out.println("URI: " + u);
//
//        Path puri = Paths.get(u);
//        System.out.println(Files.exists(puri));
//
//        // shit
//        File f = ap.toFile();
//        System.out.println(f);
    }
}
