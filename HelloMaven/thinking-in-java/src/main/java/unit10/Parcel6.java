package unit10;

/**
 * Parcel6 class
 *
 * @author zhangying
 * @date 2019/4/15
 */
public class Parcel6 {
    private void internalTracking(boolean b) {
        if(b) {
            class TrackingSlip {
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        //TrackingSlip ts = new TrackingSlip("s");
    }
}
