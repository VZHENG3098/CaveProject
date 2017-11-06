package bendimitris;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class DimitrisBenRoom extends CaveRoom {
	
	DimitrisBenMinigame game = new DimitrisBenMinigame();

	public DimitrisBenRoom(){
		super("This is the cafeteria room, play to survive");
		super.setContents("C");
		
	}
	
	public void enter() {
		
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
			//set up board before hand
			game.startGame();
			
		}else {
			CaveExplorer.print("That key does nothing");
		}
	}
	
	

}
