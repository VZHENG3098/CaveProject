package bendimitris;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class DimitrisBenRoom extends CaveRoom {
	
	DimitrisBenMinigame game;

	public DimitrisBenRoom(){
		super("This is the cafeteria room, play to survive");
		super.setContents("C");
		game = new DimitrisBenMinigame();
		
	}
	
	public void enter() {
		
		super.enter();
	}
	
	public String getContents() {
		return "C";
		
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			//set up board before hand
			game.setUpBoard();
			game.runGame();
			
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	

}
