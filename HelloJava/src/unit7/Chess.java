package unit7;

import static com.ying.util.Print.*;

class Game {
	Game(int i) {
		print("Game Constructor");
	}
}

class BoardGame extends Game {
	BoardGame(int i) {
		super(i);
		print("BoardGame Constructor");
	}
}

public class Chess extends BoardGame {

	Chess() {
		super(11);
		print("Chess Constructor");
	}
	
	public static void main(String[] args) {
		Chess x = new Chess();
	}
}
