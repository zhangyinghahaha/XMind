package tij.unit10;

import javax.swing.text.AbstractDocument;

/**
 * TestParcel class
 *
 * @author ying.zhang01
 * @date 2019/4/15
 */
public class TestParcel extends Parcel4 {

    public Destination getPDestination() {
        return new PDestination("Shanghai");
    }

    public static void main(String[] args) {
        TestParcel tp = new TestParcel();
        Destination d = tp.getPDestination();
        System.out.println(d.readLabel());
    }
}

class Parcel4 {
    private class PContens implements Contents {
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;
        public PDestination(String whereTo) {
            label = whereTo;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }

}
