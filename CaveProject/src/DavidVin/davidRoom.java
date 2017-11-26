package DavidVin;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class davidRoom extends CaveRoom {

	public davidRoom(String description) {
		super(description);
		super.setContents("E");
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
			if(CaveExplorer.inventory.getEssay() == true) {
				
			}else {
				DavidFrontEnd.play();
			}
		}
		else 
		{
			CaveExplorer.print("That key does nothing");
		}
			
	
	}
	

	
	public void startGame()
	{
		DavidFrontEnd.play();
	}
	
	public String getDescription()
	{
		if(CaveExplorer.inventory.getEssay() == true) {
			return "\n You came prepare to english class today. So you can recover your stamina by sleeping";
		}else
			
		return"\nWelcome to English Class."+
		"\nYou forgot to do you summer reading assignment."+
		"\nYou ask your neighbor for the homework so you can copy it."+
		"\nHe said he will only let you copy off him, if you are able to earn 60 points in a matching game."+
		"\n"+"The rules are simple flip two cards to see if you have a match."+
		"\n"+"Each match is worth 10 points."+
		"\n"+"You have 25 turns to find the matching pairs, or else you lose."+
		"\n"+"Press E to start!";
	}
	public String getContents() {
		return "ENG";
		
	}
}