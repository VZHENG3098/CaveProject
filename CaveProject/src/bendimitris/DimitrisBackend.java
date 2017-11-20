package bendimitris;

import caveExplorer.CaveExplorer;

public class DimitrisBackend implements BenSupport {
	
	int totalSec;
	String[][] board;
	
	DimitrisSupport frontend;

	public DimitrisBackend(DimitrisSupport frontend) {
		this.frontend = frontend;
	}

	@Override
	public void runGame() {
		//main loop
		
		int gameLen = 180; //Seconds the game will run (180s = 3min)
		
		//initialized timer
		startTimer();
		
		
		while(totalSec < gameLen) {//if player takes a long time to decide, then scanner will block using up precious time
			this.frontend.printBoard(); //print the board each turn
			executeTurn(); //then update state
		}
		
		//loop runs every x seconds until the time is larger than gameLen
		
	}
	
	public void executeTurn() {
		
		frontend.moveTeacher(); //first ben moves teacher
		board = frontend.getBoard(); //then I get the updated state
		movePeople(); //using this updated state I move p
		movePlayer();
		
		
	}
	
	public void movePlayer() {
		// get user input/movement
	}
	
	public int getInput() {
		String input = CaveExplorer.in.nextLine();
		return "wdsae".indexOf(input);
	}

	public void movePeople() {
		// moves all of the people preserving the line
		
	}

	public void startTimer() {
		// starts timer
		
	}
	
}
 
 
 
 
 
 
 
