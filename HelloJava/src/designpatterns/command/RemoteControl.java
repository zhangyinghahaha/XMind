package designpatterns.command;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl() {
        this.onCommands = new Command[7];
        this.offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            this.onCommands[i] = noCommand;
            this.offCommands[i] = noCommand;
        }
        this.undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        this.undoCommand = this.onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        this.undoCommand = this.offCommands[slot];
    }

    public void undoButtonWasPushed() {
        this.undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n-------Remote Control---------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuffer.append("[slot " + 1 + "] " + onCommands[1].getClass().getName()
                    + "     " + offCommands[i].getClass().getName() + "\n");
        }

        return stringBuffer.toString();
    }
}
