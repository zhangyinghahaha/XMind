package tij.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.println(id + ": " + result);
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));

        Path p = Paths.get("PathAnalysis.java").toAbsolutePath();
        say("Exists", Files.exists(p));
        say("Directory", Files.isDirectory(p));
        say("Executable", Files.isExecutable(p));
    }
}
