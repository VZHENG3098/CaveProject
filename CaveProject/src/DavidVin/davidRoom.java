package DavidVin;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class davidRoom extends CaveRoom {

	public davidRoom(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
				+ "or you can press 'e' to interact.");
	}

	
	public String validMoves() {
		return "wdsae";
	}

	
	public void performAction(int direction) {
		
		
		
		
		if(direction == 4) {
			CaveExplorer.print("Press e to start");
			
			startGame();
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	public void startGame()
	{
		DavidFrontEnd.play();
	}
	
	public String getDescription()
	{
		return"\nWelcome to English Class."+
		"\nYou forgot to do you summer reading assignment."+
		"\nYou ask your neighbor for the homework so you can copy it."+
		"\nHe said he will only let you copy off him, if you are able to earn 60 points in a matching game."+
		"\n"+"The rules are simple flip two cards to see if you have a match."+
		"\n"+"Each match is worth 60 points."+
		"\n"+"You have 20 turns to find the matching pairs, or else you lose.";
	}
	
}