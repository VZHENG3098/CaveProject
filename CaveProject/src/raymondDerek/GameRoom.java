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

		if (direction == 4 && CaveExplorer.inventory.returnSchedule() == 1) {

			startGame();
		} else {
			CaveExplorer.print("That key does nothing");
		}
	}

	public void startGame() {
		new DerekFrontEnd().play();
		CaveExplorer.inventory.nextClass();
	}

	public String getDescription() {
		if(CaveExplorer.inventory.returnSchedule() == 1) {
			return "You can play dodgeball here. Press e to play.";
		}else {
			return "Go to your next class " + CaveExplorer.inventory.currentClass();
		}
	}

}