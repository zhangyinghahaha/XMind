package command;

/**
 * LightOnCommand class
 *
 * @author ying.zhang01
 * @date 2020/3/10
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
