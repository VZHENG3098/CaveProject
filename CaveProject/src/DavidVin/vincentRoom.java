package DavidVin;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class vincentRoom extends CaveRoom {

	public vincentRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
				+ "or you can press 'e' to interact.");
	}

	/**
	 * override to add more moves
	 * @return
	 */
	public String validMoves() {
		return "wdsae";
	}

	/**
	 * override to create response to keys other than wdsa
	 * @param direction
	 */ 
	public void performAction(int direction) {
		if(direction == 4) {
			CaveExplorer.inventory.setHP();
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	public String getDescription() {
		return "You've enter a room with a fountain. Would you like to press e to heal.";
	}
}
