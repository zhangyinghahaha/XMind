package unit7;

import static com.ying.util.Print.*;

class Art {
	
}

class Drawing extends Art {
	
}

public class Cartoon extends Drawing {

	public Cartoon() {
		print("Cartoon Constructor");
	}
	
	public static void main(String[] args) {
		Cartoon x = new Cartoon();
	}
}
