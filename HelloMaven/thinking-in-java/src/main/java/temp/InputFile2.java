package temp;

import unit12.InputFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * InputFile2 class
 *
 * @author ying.zhang01
 * @date 2020/1/8
 */
public class InputFile2 {
    private String fname;

    public InputFile2(String fname) {
        this.fname = fname;
    }

    public Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get(fname));
    }

    public static void main(String[] args) throws Exception {
        new InputFile2("C:\\Users\\ying.zhang01\\Desktop\\temp\\Study Materials\\Java\\XMind\\HelloJava\\src\\tij\\temp\\InputFile2.java").getLines()
                .skip(15)
                .limit(1)
                .forEach(System.out::println);
    }
}
