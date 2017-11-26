package caveExplorer;

public class ExplorableRoom extends NPCRoom {
	boolean explored = false;

	public ExplorableRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	
	public String getContents() {
		if(!explored) {
			return "?";
		}
		else {
			return super.getContents();
		}
	}
	
	public void enter() {
		explored = true;
		super.enter();
	}
	
	public Door getDoor(int direction) {
			if(!explored) {
				return super.getDoor(4);
			}
			return super.getDoor(direction);
		
	}

}
