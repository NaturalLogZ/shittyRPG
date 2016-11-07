package shittyRPG;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {
	private Player player;
	private Room[] rooms;
	
	//Methods
	//Ctor
	public Game() throws IOException {
		loadRooms("C:\\Users\\Logan\\workspace\\shittyRPG\\textFiles\\testRooms.txt");
		player = new Player(rooms[0]);
	}
	
	private void loadRooms(String input_path) throws IOException {
		FileReader input_file = new FileReader(input_path);
		BufferedReader input_buff = new BufferedReader(input_file);
		 
		int numRooms = Integer.parseInt(input_buff.readLine());
		
		rooms = new Room[numRooms];
		
		for (int i=0; i<numRooms; i++) {
			//Read Rooms message
			String enterMessage = input_buff.readLine();
			rooms[i] = new Room(enterMessage);
		}
		
		while (input_buff.ready()) {
			int room1ID = Integer.parseInt(input_buff.readLine());
			char direction = (char) input_buff.read();
			input_buff.readLine(); //Skips newline
			int room2ID = Integer.parseInt(input_buff.readLine());
			rooms[room1ID].setAdjacency(rooms[room2ID], direction, false);
		}
	}
	
	public void move(String direction) {
		player.move(direction);
	}

}