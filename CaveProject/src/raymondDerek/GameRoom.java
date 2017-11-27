package raymondDerek;


import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class GameRoom extends CaveRoom {

	public GameRoom(String description) {
		super(description);
		super.setContents("D");
	}

	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move " + "or you can press 'e' to interact.");
	}

	public String validMoves() {
		return "wdsae";
	}

	public String getContents() {
		return "D";
		
	}
	
	
	public void performAction(int direction) {

		if(direction == 4) {
				
			startGame();
		}
		else 
		{
			CaveExplorer.print("That key does nothing");
		}
	}
	public void startGame() {
		new DerekFrontEnd().play();

	}

	

	public String getDescription() {
		return "You can play dodgeball here. Press e to play.";
	}

}