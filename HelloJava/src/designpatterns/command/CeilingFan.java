package designpatterns.command;

/**
 * @author ying.zhang01
 */
public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    private String location;
    private int speed;

    public CeilingFan(String location) {
        this.location = location;
        this.speed = CeilingFan.OFF;
    }

    public void setHigh() {
        this.speed = CeilingFan.HIGH;
    }

    public void setMedium() {
        this.speed = CeilingFan.MEDIUM;
    }

    public void setLow() {
        this.speed = CeilingFan.LOW;
    }

    public void setOff() {
        this.speed = CeilingFan.OFF;
    }

    public int getSpeed() {
        return this.speed;
    }
}
