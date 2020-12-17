package unit10;

/**
 * GreenhouseControls class
 *
 * @author ying.zhang01
 * @date 2019/4/22
 */
public class GreenhouseControls extends Controller {
    private boolean light = false;
    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            light = true;
        }
        @Override
        public String toString() {
            return "Light is on";
        }
    }

    private boolean water = false;
    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            water = true;
        }
        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }
        @Override
        public String toString() {
            return "Bing!";
        }
    }
}
