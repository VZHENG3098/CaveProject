package raymondDerek;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class RaymondCustomRoom extends NPCRoom {
	private NPC npc;

	public RaymondCustomRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
				+ "or you can press 'e' to interact.");
	}
	
	public String validMoves() {
		return "wdsaef";
	}


	public void performAction(int direction) {
		if(direction == 5) {
			
		}else if(direction == 4) {
			super.performAction(direction);
		} else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	public void 
	
	public String getContents() {
		if(containsNPC() && npc.isActive()) {
			return "C"; //clothes
		}else {
			return super.getContents();
		}
	}
	
	public String getDescription() {
		return "This is the locker room. Change your clothes here.";
	}
}
