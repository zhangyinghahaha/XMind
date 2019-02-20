package unit7;

import static com.ying.util.Print.*;

public class Amphibian {

	void say() {
		print("I'm Amphibian");
	}
	
	static void upCasting(Amphibian amp) {
		amp.say();
	}
}
