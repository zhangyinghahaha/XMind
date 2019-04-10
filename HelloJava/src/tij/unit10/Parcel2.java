package tij.unit10;

/**
 * Parcel2 class
 *
 * @author ying.zhang01
 * @date 2019/4/10
 */
public class Parcel2 {
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

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents s = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLaabel());
    }

    public static void main(String[] args) {
        //Parcel2 p = new Parcel2();
        //p.ship("Ta");
        //Parcel2.Contents c = p.contents();
        //Parcel2.Destination d = new Parcel2.Destination("to");
    }
}
