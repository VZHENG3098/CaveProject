package DavidVin;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.NPCRoom;

public class VincentRoomLQS extends NPCRoom {
	public VincentRoomLQS(String description) {
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
		if(direction == 4 && CaveExplorer.inventory.returnSchedule() == 1) {
			CaveExplorer.inventory.increaseStamina(5);
			CaveExplorer.inventory.nextClass();
		}
		else {
			CaveExplorer.print("That key does nothing");
		}
	}
	public String getDescription() {
		if(CaveExplorer.inventory.returnSchedule() == 1) {
			return "\n You have nothing to do in LQS. You can rest and regain your stamina";
		}else {
			return "Go to your next class "+CaveExplorer.inventory.currentClass();
		}
	}
	public String getContents() {
		return "LQS";
		
	}
}
