package caveExplorer;

public class NPCRoom extends CaveRoom {
	
	private NPC npc;
	
	
	public NPCRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	
	public boolean canEnter() {
		return npc == null;
	}
	
	public void enterNpc(NPC n) {
		this.npc = n;
	}
	
	public void leaveNPC() {
		this.npc = null; 
	}
	
	public boolean containsNPC() {
		return npc != null;
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(npc != null && npc.isActive()) {
				 npc.interact();
			}else {
				CaveExplorer.print("There is nothing to react to");
			}
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}


	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move or you can press 'e' to interact.");
	}
	
	public String validMoves() {
		return "wdsae";
	}
	
	public String getContents() {
		if(containsNPC() && npc.isActive()) {
			return npc.getSymbol();
		}else {
			return super.getDescription();
		}
	}
	public String getDesciption() {
		if(containsNPC() && npc.isActive()) {
			return super.getDescription()+"\n"+npc. getDescription();
		}else if(containsNPC() && !npc.isActive()) {
			return super.getDescription()+"\n"+npc.getInactiveDescription();
		}else {
			return super.getDescription();
		}
		
	}
}
