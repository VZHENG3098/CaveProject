package bendimitris;

import caveExplorer.NPCRoom;

public class DimitrisBenRoom extends NPCRoom {
	
	DimitrisBenMinigame game;

	public DimitrisBenRoom(){
		super("This is the cafeteria room, play to survive");
		super.setContents("C");
		game = new DimitrisBenMinigame();
		
	}
	
	public void enter() {
		//set up board before hand
		game.setUpBoard();
		game.runGame();
		super.enter();
	}
	
	public String getContents() {
		return "C";
		
	}
	
	
	
	

}
