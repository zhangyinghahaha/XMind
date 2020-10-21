package test;

import java.util.List;

public abstract class StateMachine {
    // 待审批 -> 审批拒绝、审批通过

    private static List<State> allStates = null;

//    public State execute(String stateCode, Event event) {
//        State startState = this.getState(stateCode);
//        for (Transition transition : startState.getTransitions()) {
//            if (event.getEventCode().equals(transition.getEventCode())) {
//                return transition.execute(event);
//            }
//        }
//        //log.error("StateMachine[{}] Can not find transition for stateId[{}] eventCode[{}]", this.getClass().getSimpleName(), stateCode, event.getEventCode());
//        return null;
//    }
//
//    public State getState(String stateCode) {
//        if (allStates == null) {
//            allStates = this.declareAllStates();
//        }
//
//        for (State state : allStates) {
//            if (state.getStateCode().equals(stateCode)) {
//                return state;
//            }
//        }
//        return null;
//    }

    public abstract List<State> declareAllStates();
}
