package tij.unit10;

/**
 * Parcel10 class
 *
 * @author zhangying
 * @date 2019/4/18
 */
public class Parcel10 {
    public Destination destination(String dest, float price) {
        return new Destination() {
            private int cost;
            {
                cost = Math.round(price);
                if(cost > 100) {
                    System.out.println("Over budget");
                }
            }
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Shanghai", 101.34F);
    }
}
