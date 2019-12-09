package tij.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * FileToWordsBuilder class
 *
 * @author ying.zhang01
 * @date 2019/12/9
 */
public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws Exception {
        Files.lines(Paths.get(filePath))
                .skip(1)
                .forEach(line -> {
                    for(String w : line.split("[ .?,]+")) {
                        builder.add(w);
                    }
                });
    }

    Stream<String> stream() {
        return builder.build();
    }
}
