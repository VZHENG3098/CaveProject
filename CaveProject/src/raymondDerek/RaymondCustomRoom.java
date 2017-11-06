package raymondDerek;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;
import caveExplorer.Inventory;
 
public class RaymondCustomRoom extends NPCRoom {
	private NPC npc;

	public RaymondCustomRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
				+ "or you can press 'e' to pick up the clothes.");
	}
	
	public String validMoves() {
		return "wdsae";
	}
 

	public void performAction(int direction) {
		if(direction == 4) {
			CaveExplorer.print("You have picked up the gym clothes. Maybe you can use them later in the gym.");
			CaveExplorer.inventory.clothes= true;
		} else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	
	public String getContents() {
		if(containsNPC() && npc.isActive()) {
			return "C"; //clothes
		}else {
			return super.getContents();
		}
	}
	
	public String getDescription() {
		return "You've stumbled upon a random pile of clothes that have the Tech logo on it.";
	}
}
