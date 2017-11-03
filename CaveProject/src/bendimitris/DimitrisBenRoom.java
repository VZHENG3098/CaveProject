package bendimitris;

import caveExplorer.CaveRoom;

public class DimitrisBenRoom extends CaveRoom {
	
	DimitrisBenMinigame game;

	public DimitrisBenRoom(){
		super("This is the cafeteria room, play to survive");
		game = new DimitrisBenMinigame();
		
	}
	
	public void enter() {
		game.runGame();
		super.enter();
	}
	
	

}
