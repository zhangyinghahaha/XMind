package tij.unit10;

/**
 * DotNew class
 *
 * @author ying.zhang01
 * @date 2019/4/15
 */
public class DotNew {

    public class Inner {

    }

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
    }
}
