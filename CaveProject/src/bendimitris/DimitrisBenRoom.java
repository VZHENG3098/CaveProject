package bendimitris;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.Inventory;

public class DimitrisBenRoom extends CaveRoom {
	
	BenFrontend game = new BenFrontend();

	public DimitrisBenRoom(){
		super("This is the cafeteria room, play to survive");
		super.setContents("C");
	}
	
	public void enter() {
		if (CaveExplorer.inventory.getContents().indexOf("a Lunch Tray") > -1)
		{
			CaveExplorer.print("This is where you picked up the lunch tray.");
		}
		super.enter();
	}
	
	public String getContents() {
		return "C";
		
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			printValidMoves();
			
			input = CaveExplorer.in.nextLine();
		}
		int direction = validMoves().indexOf(input);
		if (direction < 4) {
			goToRoom(direction);
		}else {
			performAction(direction);
		}
	}
	
	public String validMoves() {
		return "wdsae";
	}
	
	public boolean isValid(String input) {
		return input.length() == 1 && "wsade".indexOf(input) !=-1;
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's','d', or 'e'.");
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			game.startGame(); // if e is selected then the game is run the game
			if(game.wonGame()) {
				//add lunch tray to inventory + remove poison
				CaveExplorer.inventory.poison = false;
				
				CaveExplorer.inventory.addToContents("a Lunch Tray");
			}
			else {
				//reset game + add poison to inventory
				CaveExplorer.inventory.poison = true;
				
				game = new BenFrontend();
			}
			
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	

}
