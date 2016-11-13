package shittyRPG;

public class Player {
	private Room location;
	
	public Player(Room location) {
		this.location = location;
	}
	
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
