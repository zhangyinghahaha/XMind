package tij.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.println(id + ": " + result);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("src", "tij", "file", "PathInfo.java").toAbsolutePath();
        System.out.println(p);

        say("Exists", Files.exists(p));
        say("Directory", Files.isDirectory(p));
        say("Executable", Files.isExecutable(p));
        say("Readable", Files.isExecutable(p));
        say("RegularFile", Files.isRegularFile(p));
        say("Writeable", Files.isWritable(p));
        say("notExists", Files.notExists(p));
        say("Hidden", Files.isHidden(p));
        say("Size", Files.size(p));
        say("FileStore", Files.getFileStore(p));
        say("LastModified", Files.getLastModifiedTime(p));
        say("Owner", Files.getOwner(p));
        say("ContentType", Files.probeContentType(p));
        say("SymbolickLink", Files.isSymbolicLink(p));
    }
}
