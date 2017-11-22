package raymondDerek;

import caveExplorer.NPCRoom;
import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class GameRoom extends NPCRoom {

	public GameRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move " + "or you can press 'e' to interact.");
	}

	public String validMoves() {
		return "wdsae";
	}

	public void performAction(int direction) {


		if(direction == 4) {
			CaveExplorer.print("Press e to start");
				
			startGame();
		}
		else 
		{
			CaveExplorer.print("That key does nothing");
		}
	}
	public void startGame() {
		DerekFrontEnd.play();
	}

	

	public String getDescription() {
		return "";
	}

}

