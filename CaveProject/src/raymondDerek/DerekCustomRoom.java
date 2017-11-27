package raymondDerek;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class DerekCustomRoom extends NPCRoom {

	private NPC npc;
	private boolean unlocked;

	public DerekCustomRoom(String description) {
		super(description);
		super.setContents("G");
		this.unlocked = false;
	}

	public void performAction(int direction) {
		if (direction == 4 && CaveExplorer.inventory.isClothes()) {
			CaveExplorer.print("You may only press 'w' or 'd' ");
		} else {
			CaveExplorer.print("You can not do anything without the gym clothes.");
		}
	}

	public String getContents() {
		return "G";

	}

	public String getDescription() {
		if (CaveExplorer.inventory.isClothes()) {
			if (this.unlocked = false) {
				return "The gym is now unlocked! Congrats on finding your clothes. Print 'e' to talk to the teacher";
			} else {
				this.unlocked = true;
				return "Go to the room on the right to play DodgeBall";
			}
		} else {
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

}
