package raymondDerek;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;
import caveExplorer.Inventory;

public class DerekCustomRoom extends NPCRoom {
	
	private NPC npc;
	
	public DerekCustomRoom(String description) {
			super(description);
		// TODO Auto-generated constructor stub
	}
	
	public void performAction1(int direction) {
		if(direction == 4 && CaveExplorer.inventory.clothes == true) {
			CaveExplorer.print("Print 'e' again to talk to the teacher");
			talkTeacher();
		} else {
			CaveExplorer.print("You can not do anything without the gym clothes.");
		}
	}
	
	private void talkTeacher() {
		// TODO Auto-generated method stub
		
	}

	public String getContents() {
		if(containsNPC() && npc.isActive()) {
			return "G";
		}else {
			return super.getContents();
		}
	}
	
	public String getDescription() {
			return "This is the gym room. You need your clothes ";
		}
		

	public void printValidMoves() {
			System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
					+ "or you can press 'e' to talk to the gym teacher.");
		}
	
	public String validMoves() {
		return "wdsae";
	}
}

	