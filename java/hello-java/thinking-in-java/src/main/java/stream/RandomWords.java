package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * RandomWords class
 *
 * @author ying.zhang01
 * @date 2019/12/3
 */
public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    RandomWords(String fname) throws IOException {
        System.out.println(Paths.get(fname));
        List<String> lines = Files.readAllLines(Paths.get(fname));
        for(String line : lines.subList(1, lines.size())) {
            for(String word : line.split("[ .?,]+")) {
                words.add(word.toLowerCase());
            }
        }
    }
    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(
                Stream.generate(
                        new RandomWords("C:\\Users\\ying.zhang01\\Desktop\\temp\\Study Materials\\Java\\XMind\\HelloJava\\src\\tij\\stream\\Cheese.dat"))
                        .limit(10)
                        .collect(Collectors.joining(" "))
        );
    }
}
