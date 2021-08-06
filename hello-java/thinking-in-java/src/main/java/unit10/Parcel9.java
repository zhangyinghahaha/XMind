package unit10;

/**
 * Parcel9 class
 *
 * @author ying.zhang01
 * @date 2019/4/17
 */
public class Parcel9 {
    public Destination destination(int dest) {
        return new Destination() {
            private Integer label = dest;
            @Override
            public String readLabel() {
                return label.toString();
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination(111);
    }
}
