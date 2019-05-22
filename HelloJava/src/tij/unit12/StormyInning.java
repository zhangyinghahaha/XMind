package tij.unit12;

class BaseballException extends Exception {}

class Foul extends BaseballException {}

class Strike extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}

    public void event() throws BaseballException {

    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {}
}

class StormException extends Exception {}

class RainedOut extends  StormException {}

class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

/**
 * StormyInning class
 *
 * @author ying.zhang01
 * @date 2019/5/22
 */
//public class StormyInning extends Inning implements Storm {
//    public StormyInning() throws RainedOut, BaseballException {}
//
//    public StormyInning(String s) throws Foul, BaseballException {}
//
//    //@Override
//    //void walk() throws PopFoul {}
//
//    //@Override
//    //public void event() throws RainedOut {}
//
//    //@Override
//    //public void rainHard() throws BaseballException,RainedOut {}
//}
