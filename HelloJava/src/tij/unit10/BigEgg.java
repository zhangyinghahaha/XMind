package tij.unit10;

class Egg {
    private  Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk");
        }
    }

    public Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}

/**
 * BigEgg class
 *
 * @author ying.zhang01
 * @date 2019/4/24
 */
public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    public BigEgg() {
        System.out.println("new BigEgg()");
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}
