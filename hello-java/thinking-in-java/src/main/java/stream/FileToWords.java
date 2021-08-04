package stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * FileToWords class
 *
 * @author ying.zhang01
 * @date 2019/12/9
 */
public class FileToWords {
    public static Stream<String> stream(String filePath) throws Exception {
        return Files.lines(Paths.get(filePath))
                .skip(1)
                .flatMap(line -> Pattern.compile("[ .,?]+").splitAsStream(line));
    }
}
