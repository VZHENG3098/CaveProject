package DavidVin;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.NPCRoom;

public class vincentRoom extends NPCRoom {
	private boolean active;
	public vincentRoom(String description) {
		super(description);
		active = true;
	}
	
	public boolean getActive() {
		return active;
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
		if(direction == 4 && active == true) {
			CaveExplorer.inventory.essayTrue();
			active = false;
			CaveExplorer.print("You picked up the assignment");
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	public String getDescription() {
		if(active == true) {
			return "You found a Summer Reading assignment on the floor. Press e to pick it up";	
		}else {
			return "";
		}
	}
}
