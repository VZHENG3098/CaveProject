package bendimitris;

import caveExplorer.CaveRoom;

public class DimitrisBenRoom extends CaveRoom {
	
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
