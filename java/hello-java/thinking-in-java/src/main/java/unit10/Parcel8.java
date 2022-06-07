package unit10;

/**
 * Parcel8 class
 *
 * @author ying.zhang01
 * @date 2019/4/17
 */
public class Parcel8 {
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
//            @Override
////            public int value() {
////                return super.value() * 47;
////            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());
    }
}
