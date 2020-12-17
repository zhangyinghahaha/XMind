package unit10;

/**
 * Parcel2 class
 *
 * @author ying.zhang01
 * @date 2019/4/10
 */
public class Parcel2 {

    private String label;
    private Destination destination;

    class Destination {

        Destination(String whereTo) {
            label = whereTo;
        }

        private String label2;
        String readLabel() {
            label2 = label;
            return label;
        }
    }

    public void to(String s) {
        destination = new Destination(s);
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        Parcel2.Destination d = p.new Destination("Shanghai");
        System.out.println(d.readLabel());
        System.out.println(d.label2);
        p.to("Beijing");
        System.out.println(p.label);
        System.out.println(p.destination.label2);
    }
}
