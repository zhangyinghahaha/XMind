package unit7;

import static com.ying.util.Print.*;

class Plate {
	Plate(int i) {
		print("Plate Constructor");
	}
}

class DinnerPlate extends Plate {
	DinnerPlate(int i) {
		super(i);
		print("DinnerPlate Constructor");
	}
}

class Utensil {
	Utensil(int i) {
		print("Utensil constructor");
	}
}

class Spoon extends Utensil {
	Spoon(int i) {
		super(i);
		print("Spoon constructor");
	}
}

class Fork extends Utensil {
	Fork(int i) {
		super(i);
		print("Fork constructor");
	}
}

class Knife extends Utensil {
	Knife(int i) {
		super(i);
		print("Knife constructor");
	}
}

class Custom {
	Custom(int i) {
		print("Custom constructor");
	}
}

public class PlaceSetting extends Custom {
	
	private Spoon sp;
	private Fork frk;
	private Knife kn;
	private DinnerPlate pl;
	
	public PlaceSetting(int i) {
		super(i + 1);
		sp = new Spoon(i + 2);
	}

}
