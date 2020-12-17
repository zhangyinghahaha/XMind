package String;

public class Concatenation {
    public static void main(String[] args) {
        String mango = "mango";
        String mango2 = mango;
        String s = "abc" + mango;
        mango = "123" + mango;
        System.out.println(s);
        System.out.println(mango);
        System.out.println(mango2);
    }
}
