package raymondDerek;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;
import caveExplorer.Inventory;
 
public class RaymondCustomRoom extends NPCRoom {
	private NPC npc;

	public RaymondCustomRoom(String description) {
		super(description);
		super.setContents("c");
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
				+ "or you can press 'e' to pick up the clothes.");
	}
	
	public String validMoves() {
		return "wdsae";
	}
 
	public String getContents() {
		return "c";
		
	}

	public void performAction(int direction) {
		if(direction == 4 && !CaveExplorer.inventory.isClothes()) {
			CaveExplorer.print("You have picked up the gym clothes. Maybe you can use them later in the gym.");
			CaveExplorer.inventory.setClothes();
		} else if(direction == 4) {
			CaveExplorer.print("There is nothing else to pick up");
		} else {
			CaveExplorer.print("That key does nothing.");
		}
	}
	
	
	
	
	public String getDescription() {
		if(!CaveExplorer.inventory.isClothes()) {
			return "You've stumbled upon a random pile of clothes that have the Tech logo on it.";	
		} else {
			return "This is the place  where you found your gym clothes";
		}
	}
}