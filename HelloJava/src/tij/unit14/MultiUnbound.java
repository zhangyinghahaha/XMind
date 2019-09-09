package tij.unit14;

class This {
    void two(int i, double d) {}
    void three(int i, double d, String s) {}
    void four(int i, double d, String s, char c) {}
}

interface TowArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call2(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(This athis, int i, double d, String s, char c);
}

/**
 * MultiUnbound class
 *
 * @author ying.zhang01
 * @date 2019/9/9
 */
public class MultiUnbound {
    //TowArgs towArgs = This::four;
    This aThis = new This();
}
