package DavidVin;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class davidRoom extends CaveRoom {

	public davidRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
				+ "or you can press 'e' to interact.");
	}

	
	public String validMoves() {
		return "wdsae";
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			CaveExplorer.print("You meet a nice student. Press e to get 100 gold.");
			CaveExplorer.inventory.giveGold();
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	public String getDescription() {
		return "You found money on the ground. Press e to obtain it";
	}
}