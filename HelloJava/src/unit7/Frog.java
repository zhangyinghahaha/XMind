package unit7;

import static com.ying.util.Print.*;

public class Frog extends Amphibian {

	void say() {
		print("I'm Frog");
	}
	
	public static void main(String[] args) {
		Frog frog = new Frog();
		
		Amphibian.upCasting(frog);
	}
}
