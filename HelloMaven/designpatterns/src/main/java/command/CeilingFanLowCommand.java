package command;

/**
 * @author ying.zhang01
 */
public class CeilingFanLowCommand implements Command{
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.setLow();
    }

    @Override
    public void undo() {
        if(prevSpeed == CeilingFan.HIGH) {
            ceilingFan.setHigh();
        }
    }
}
