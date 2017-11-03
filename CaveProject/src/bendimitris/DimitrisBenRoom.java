package bendimitris;

import caveExplorer.NPCRoom;

public class DimitrisBenRoom extends NPCRoom {
	
	DimitrisBenMinigame game;

	public DimitrisBenRoom(){
		super("This is the cafeteria room, play to survive");
		game = new DimitrisBenMinigame();
		
	}
	
	

}
