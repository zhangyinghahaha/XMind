package unit10;

/**
 * Parcel3 class
 *
 * @author ying.zhang01
 * @date 2019/4/15
 */
public class Parcel3 {

    private class PDestination implements Destination {
        public String lable;

        PDestination(String whereTo) {
            lable = whereTo;
        }
        @Override
        public String readLabel() {
            return lable;
        }
    }

    public Destination getDestination() {
        return new PDestination("Shanghai");
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Destination d = p.getDestination();
        System.out.println(((Parcel3.PDestination)d).lable);
    }
}
