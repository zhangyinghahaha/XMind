package temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * TryWithResources class
 *
 * @author ying.zhang01
 * @date 2020/1/8
 */
public class TryWithResources {
    public static void main(String[] args) {
        try (
                InputStream in = new FileInputStream(new File("TryWithResources.java"))
        ) {
            int contents = in.read();
        } catch (IOException e) {

        }
    }
}
