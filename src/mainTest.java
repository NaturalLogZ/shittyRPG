package shittyRPG;

import java.io.IOException;

public class mainTest {

	public static void main(String[] args) throws IOException {
		
		Game game = new Game();
		game.move("north");
		game.move("east");
		game.move("south");
		game.move("fuck");
	}

}
