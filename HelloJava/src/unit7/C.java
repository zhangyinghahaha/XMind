package unit7;

import static com.ying.util.Print.*;

class A {
	A(int i) {
		print("A Constructor " + i);
	}
}

class B {
	B(int i) {
		print("B Constructor " + i);
	}
}

public class C extends A {
	
	// B b = new B(2);
	
	C() {
		super(1);
		print("C Constructor C()");
	}
	
	C(String name) {
		super(1);
		print("C Constructor C(String name)");
	}
	
	public static void main(String[] args) {
		C c = new C("zhang");
	}

}
