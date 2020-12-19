package command;

/**
 * Light class
 *
 * @author ying.zhang01
 * @date 2020/3/10
 */
public class Light {
    private String name;

    Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(this.name + " Light is on!");
    }

    public void off() {
        System.out.println(this.name + " Light is off!");
    }
}
