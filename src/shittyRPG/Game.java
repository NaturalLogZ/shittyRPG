package shittyRPG;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Game class handles the main functionality of the game.
 * It contains the Player, and all of the dungeon rooms.
 * Initializing Game initializes the Player and dungeon.
 * @author NaturalLogZ
 *
 */
public class Game {
	private Player player;
	private Room[] dungeon;
	
	//Methods
	/**
	 * Constructor for Game class.
	 * Initializes the dungeon array by calling loadRooms on default file (currently testRooms.txt).
	 * Initializes a new Player with location = dungeon[0]
	 * @throws IOException If loadRooms throws IOException
	 */
	public Game() throws IOException {
		loadRooms("C:\\Users\\Logan\\workspace\\shittyRPG\\textFiles\\testRooms.txt");
		player = new Player(dungeon[0]);
	}
	
	/**
	 * This method reads data about the dungeon rooms for a given level.
	 * It creates a Room object for every room specified and stores it
	 * in the array rooms.
	 * @param input_path The path for the text file containing room data
	 * @throws IOException If the file specified cannot be opened or it is not written in the expected way
	 * @see textFiles/RoomTemplate.txt
	 */
	private void loadRooms(String input_path) throws IOException {
		FileReader input_file = new FileReader(input_path);
		BufferedReader input_buff = new BufferedReader(input_file);
		 
		int numRooms = Integer.parseInt(input_buff.readLine());
		
		dungeon = new Room[numRooms];
		
		for (int i=0; i<numRooms; i++) {
			//Read Rooms message
			String enterMessage = input_buff.readLine();
			dungeon[i] = new Room(enterMessage);
		}
		
		while (input_buff.ready()) {
			int room1ID = Integer.parseInt(input_buff.readLine());
			char direction = (char) input_buff.read();
			input_buff.readLine(); //Skips newline
			int room2ID = Integer.parseInt(input_buff.readLine());
			dungeon[room1ID].setAdjacency(dungeon[room2ID], direction, false);
		}
	}
	
	/**
	 * Attempts to move the player in the specified direction.
	 * @param direction String specifying a cardinal direction
	 * @see Player::move
	 */
	public void move(String direction) {
		player.move(direction);
	}

}