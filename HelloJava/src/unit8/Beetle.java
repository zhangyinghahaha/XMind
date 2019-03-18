package unit8;

class Insect {
    private int i = printInit("not static Insect.i init");
    protected int j;

    Insect() {
        System.out.println("Insect Constructor");
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 =
            printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");

    public Beetle() {
        System.out.println("Beetle Constructor");
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 =
            printInit("static Beetle.x2 initialized");

    public static void main(String[] args) {
        System.out.println("Main");
        Beetle b = new Beetle();
    }
}