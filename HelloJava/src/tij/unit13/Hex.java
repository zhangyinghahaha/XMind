package tij.unit13;

/**
 * Hex class
 *
 * @author ying.zhang01
 * @date 2019/6/26
 */
public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for(byte b : data) {
            if(n % 16 == 0) {
                result.append(String.format("%0.5X: ", n));
            }
        }
    }
}
