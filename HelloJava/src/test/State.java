package test;

import java.util.ArrayList;
import java.util.List;

public class State {
    private String stateCode;

    private List<Transition> transitions = new ArrayList<>();

    public State(String stateCode, Transition... transitions) {
        this.stateCode = stateCode;
        for (Transition transition : transitions) {
            this.transitions.add(transition);
        }
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    @Override
    public String toString() {
        return stateCode;
    }
}
