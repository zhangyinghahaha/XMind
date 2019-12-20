package tij.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * TreeSetOfWords class
 *
 * @author ying.zhang01
 * @date 2019/12/12
 */
public class TreeSetOfWords {
    public static void main(String[] args) throws Exception {
        Set<String> words2 = Files.lines(Paths.get("C:\\Users\\ying.zhang01\\Desktop\\temp\\Study Materials\\Java\\XMind\\HelloJava\\src\\tij\\stream\\TreeSetOfWords.java"))
                .flatMap(s -> Arrays.stream(s.split("[ .?,]+ ")))
                .filter(s -> !s.matches("\\d+"))
                .map(String::trim)
                .filter(s -> s.length() > 2)
                .limit(100)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(words2);
    }
}
