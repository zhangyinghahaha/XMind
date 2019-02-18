package unit7;

import static com.ying.util.Print.*;

class Component1 {
	Component1() {
		print("Component1 Constructor");
	}
}

class Component2 {
	Component2() {
		print("Component2 Constructor");
	}
}

class Component3 {
	Component3() {
		print("Component3 Constructor");
	}
}

public class Root {
	
	Component1 c1 = new Component1();
	Component2 c2 = new Component2();
	Component3 c3 = new Component3();

	Root() {
		print("Root Constructor");
	}
	
	public static void main(String[] args) {
		
	}
}

class Stem extends Root {
	
	Stem() {
		print("Stem Constructor");
	}
	
	public static void main(String[] args) {
		Stem s = new Stem();
	}
}
