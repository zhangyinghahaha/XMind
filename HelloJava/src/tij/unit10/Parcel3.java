package tij.unit10;

/**
 * Parcel3 class
 *
 * @author ying.zhang01
 * @date 2019/4/15
 */
public class Parcel3 {
    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    class Destination {
        private String lable;

        Destination(String whereTo) {
            lable = whereTo;
        }

        String readLabel() {
            return lable;
        }
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Parcel3.Contents c = p.new Contents();
        Parcel3.Destination d = p.new Destination("Tasmaina");
    }
}
