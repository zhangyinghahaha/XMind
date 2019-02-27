package unit7;

public class Test {
    int i;

    public Test(int i) {
        this.i = i;
    }

    private void p() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        Test t = new Test(2);
        // p();
        System.out.println(t.i);
    }
}

class Test2 {
    public static void main(String[] args) {
        Test t = new Test(2);
        System.out.println(t.i);
    }
}
