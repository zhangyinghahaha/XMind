package test;

public abstract class Transition {
    private String eventCode;
    private State currState;
    private State nextState;

    public Transition(String eventCode, State currState, State nextState) {
        super();
        this.eventCode = eventCode;
        this.currState = currState;
        this.nextState = nextState;
    }

    public State execute(Event event) {
        System.out.println(String.format("当前是：%s 状态，执行：%s 操作后，流转成：%s 状态。", currState, eventCode, nextState));
        if (this.doExecute(event)) {
            return this.nextState;
        } else {
            return null;
        }
    }

    protected abstract boolean doExecute(Event event);
}
