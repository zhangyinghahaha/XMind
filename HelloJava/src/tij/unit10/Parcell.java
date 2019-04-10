package tij.unit10;

/**
 * Parcell class
 *
 * @author ying.zhang01
 * @date 2019/4/10
 */
public class Parcell {

    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }

        String readLaabel() {
            return label;
        }
    }

    public void ship(String dest) {
        Contents s = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLaabel());
    }

    public static void main(String[] args) {
        Parcell p = new Parcell();
        p.ship("Taasmania");
    }
}
