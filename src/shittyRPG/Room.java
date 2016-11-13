package shittyRPG;

public class Room {
	//Adjacent Rooms
	private int numAdjRooms;
	private Room north, east, south, west;
	//Monster monster;
	//Trap trap;
	//Treasure treasure[];
	private String enterMessage;
	
	//Methods
	//Ctor
	public Room(String enterMessage) {
		this.enterMessage = enterMessage;
		north = east = south = west = null;
	}

	public void setAdjacency(Room other, char direction, Boolean recurse) {
		char complementDir;
		numAdjRooms++;
		if (direction == 'n') {
			north = other;
			complementDir = 's';
		}
		else if (direction == 'e') {
			east = other;
			complementDir = 'w';
		}
		else if (direction == 's') {
			south = other;
			complementDir = 'n';
		}
		else if (direction == 'w') {
			west = other;
			complementDir = 'e';
		}
		else {
			System.out.println("Not a valid direction");
			return;
		}
		
		if (!recurse) {
			other.setAdjacency(this, complementDir, true);
		}
	}
		
	public Room getAdjacentRoom(String direction) {
		if(direction == "north") return north;
		if(direction == "east") return east;
		if(direction == "south") return south;
		if(direction == "west") return west;
		System.out.println("Not a valid direction!\n"
				+ "Please use one of the four following directions: north, east, south, west");;
		return null;
	}

	public void enter() {
		System.out.println("You enter a new room.");
		System.out.println(enterMessage);
		//if (monster) monster.describe();
		System.out.print("There is an exit to the ");
		int adjRoomsPlaced = 0;
		if (north != null) {
			adjRoomsPlaced++;
			System.out.print("north");
			if (adjRoomsPlaced == numAdjRooms) {
				System.out.println(".");
				return;
			}
			System.out.print(", ");
		}
		if (east != null) {
			adjRoomsPlaced++;
			System.out.print("east");
			if (adjRoomsPlaced == numAdjRooms) {
				System.out.println(".");
				return;
			}
			System.out.print(", ");
		}
		if (south != null) {
			adjRoomsPlaced++;
			System.out.print("south");
			if (adjRoomsPlaced == numAdjRooms) {
				System.out.println(".");
				return;
			}
			System.out.print(", ");
		}
		if (west != null) {
			adjRoomsPlaced++;
			System.out.print("west");
			if (adjRoomsPlaced == numAdjRooms) {
				System.out.println(".");
				return;
			}
			System.out.print(", ");
		}
	}
	
	/*
	Treasure search(int ability) {
		trap.search(ability)
	}
	*/
	/*
	void attack(int ability) {
		
	}
	*/

}
