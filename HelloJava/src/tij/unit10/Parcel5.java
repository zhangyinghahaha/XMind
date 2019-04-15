package tij.unit10;

/**
 * Parcel5 class
 *
 * @author ying.zhang01
 * @date 2019/4/15
 */
public class Parcel5 {
    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;
            private PDestination(String whereTo) {
                label = whereTo;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Shanghai");
        System.out.println(d.readLabel());
    }
}
