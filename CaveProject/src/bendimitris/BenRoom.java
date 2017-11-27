package bendimitris;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
//import caveExplorer.Inventory;

public class BenRoom extends CaveRoom {
	
	BenFrontend game = new BenFrontend();

	public BenRoom(){
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
		return "CAF";
		
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
			if(game.realBackend.wonGame()) {
				System.out.println("You already won the game");
			}
			else {
				game.startGame(); //starts game
				if(game.realBackend.wonGame()) {
					CaveExplorer.inventory.poisened = false;
					CaveExplorer.inventory.addToContents("a Lunch Tray"); //they cannot play twice so no chance of duplicates
					System.out.println("a tray has been added to your inventory");
					CaveExplorer.inventory.nextClass();
				}else {
					CaveExplorer.inventory.poisened = true;
					System.out.println("you have been poisened and will loose stamina");
					System.out.println("Play agian to remove poison");
				}
			}
			
			
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	

}
