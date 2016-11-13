package shittyRPG;

/**
 * The Room class contains and handles all information about a room.
 * It contains a counter of adjacent rooms, pointers to other rooms in the four cardinal directions,
 *     and a message that gets printed when the player enters the room.
 * @author NaturalLogZ
 *
 */
public class Room {
	//Adjacent Rooms
	private int numAdjRooms;
	private Room north, east, south, west;
	//Monster monster;
	//Trap trap;
	//Treasure treasure[];
	private String enterMessage;
	
	//Methods
	/**
	 * Constructor for Room class.
	 * Initializes the room with an enterMessage which is printed when the user enters this room.
	 * @param enterMessage
	 */
	public Room(String enterMessage) {
		this.enterMessage = enterMessage;
		north = east = south = west = null;
	}

	/**
	 * Sets the given other to be a neighbour of this to the given direction
	 *     then calls the function in reverse so that this is a neighbour of
	 *     other to the opposite direction.
	 * @param other The other room that will become this rooms neighbour
	 * @param direction The direction in which the other room will be connected to this.
	 *                    Therefore if direction is n, other will be to the north of this.
	 * @param recurse Boolean used to tell if this is the second part of the function.
	 *                  Avoids infinite recursion.
	 */
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
		
	/**
	 * Returns the room that is to the given direction of this.
	 * (Recall that if there is no room to a direction that direction's value will be null)
	 * If the given direction is not a valid direction, returns null.
	 * @param direction The direction in which we are looking for an adjacent room.
	 * @return A Room class (the room in the given direction) or null (if no room or invalid direction).
	 */
	public Room getAdjacentRoom(String direction) {
		if(direction == "north") return north;
		if(direction == "east") return east;
		if(direction == "south") return south;
		if(direction == "west") return west;
		System.out.println("Not a valid direction!\n"
				+ "Please use one of the four following directions: north, east, south, west");;
		return null;
	}

	/**
	 * The function that is called when the player moves into this room.
	 * It prints information that might be useful to the player, the enterMessage.
	 */
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
