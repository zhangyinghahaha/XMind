package tij.unit14;

/**
 * GenericClassReferences class
 *
 * @author ying.zhang01
 * @date 2019/9/6
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<? extends Number> genericIntClass = int.class;
        genericIntClass = Integer.class;
        genericIntClass = double.class;
    }
}
