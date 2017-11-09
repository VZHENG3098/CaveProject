package raymondDerek;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;
import caveExplorer.Inventory;

public class DerekCustomRoom extends NPCRoom {
	
	private NPC npc;
	
	public DerekCustomRoom(String description) {
			super(description);
			super.setContents("G");
		// TODO Auto-generated constructor stub
	}
	
	public void performAction1(int direction) {
		if(direction == 4 && CaveExplorer.inventory.clothes == true) {
			talkTeacher();
		} else {
			CaveExplorer.print("You can not do anything without the gym clothes.");
		}
	}
	
	public String getContents() {
		if(containsNPC() && npc.isActive()) {
			return "G";
		}else {
			return super.getContents();
		}
	}
	 
	public String getDescription() {
		if(CaveExplorer.inventory.clothes == true) {
			return "The gym is now unlocked! Congrats on finding your clothes. Print 'e' to talk to the teacher";
		}
		else {
			return "This is the gym room. You need your clothes";
		}
		}
		

	public void printValidMoves() {
			System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
					+ "or you can press 'e' to talk to the gym teacher.");
		}
	
	public String validMoves() {
		return "wdsae";
	}
	
	public void talkTeacher() {
		System.out.println("You may now play the minigame");
		playMinigame();
	}

	private void playMinigame() {
		// TODO Auto-generated method stub
		
	}
	
}

	