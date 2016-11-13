package shittyRPG;

/**
 * The Player class represents the player.
 * It contains the Room that the player is currently in
 * @author NaturalLogZ
 *
 */
public class Player {
	private Room location;
	
	/**
	 * Constructor for Player class.
	 * @param location Room that the player will start in
	 */
	public Player(Room location) {
		this.location = location;
	}
	
	/**
	 * Attempts to move the player to the room to the given direction.
	 * First it is asserted that the current room has a neighbour to the given direction.
	 * If it does not print a message and do nothing.
	 * If it does, move the player into that room.
	 * @param direction String that indicates which of the 4 cardinal directions that the player 
	 *                      wishes to go
	 */
	public void move(String direction) {
		Room destination = location.getAdjacentRoom(direction);
		if (destination == null) {
			System.out.println("The room you are in doesn't have an exit to the " + direction + ".");
		}
		else {
			location = destination;
			location.enter();
		}
	}
}
