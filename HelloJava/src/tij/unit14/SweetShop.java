package tij.unit14;

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}

/**
 * SweetShop class
 *
 * @author ying.zhang01
 * @date 2019/5/24
 */
public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        try {
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("After creating Cookie");
    }
}
