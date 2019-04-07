package tij.unit9;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * RandomWords class
 *
 * @author zhangying
 * @date 2019/4/7
 */
public class RandomWords implements Readable {

    private static Random rand = new Random(47);
    private static final char[] CAPITALS =
            "ABCDEFGHIJK".toCharArray();
    private static final char[] LOWERS =
            "abcdefghijk".toCharArray();
    private static final char[] VOWELS =
            "aeiou".toCharArray();
    private int count;

    public RandomWords(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if(count-- == 0) {
            return -1;
        }
        cb.append(CAPITALS[rand.nextInt(CAPITALS.length)]);
        for(int i = 0; i < 4; i++) {
            cb.append(VOWELS[rand.nextInt(VOWELS.length)]);
            cb.append(LOWERS[rand.nextInt(LOWERS.length)]);
        }
        cb.append(" ");
        return 10;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(10));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}
