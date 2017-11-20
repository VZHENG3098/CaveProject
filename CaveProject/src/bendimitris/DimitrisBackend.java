package bendimitris;

import caveExplorer.CaveExplorer;

public class DimitrisBackend implements BenSupport {
	
	private int totalSec;
	private String[][] board;
	private int[] playerPosition;
	
	static String playerString = "X";
	
	
	
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
		
		int direction = getInput();
		
		
	}
	
	public int[] getPlayerPosition() {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				if(board[row][col] == DimitrisBackend.playerString) {
					int[] pos = {row,col};
					return pos;
				}
			}
		}
		int[] error = {-1,-1};
		return error;
	}
	
	public int[] calculateOpenSides(int[] pos) {
		
		int[] noSides = {-1,-1};
		return noSides;
	}
	
	public int getInput() {
		String input = CaveExplorer.in.nextLine();
		if(input.length() == 1) {
			return "wdsae".indexOf(input);
		}
		return -1;
		
	}

	public void movePeople() {
		// moves all of the people preserving the line
		
	}

	public void startTimer() {
		// starts timer
		
	}
	
}
 
 
 
 
 
 
 
