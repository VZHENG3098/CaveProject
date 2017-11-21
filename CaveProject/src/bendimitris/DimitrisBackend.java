package bendimitris;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class DimitrisBackend implements BenSupport {
	
	private int totalSec;
	private String[][] board;
	private int[] playerPosition;
	
	static String playerString = "X";
	static String emptyString = " ";
	
	
	
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
		boolean[] validMoves = calculateOpenSides(getPlayerPosition());
		
		if(validMoves[direction] == true) {
			
		}
		
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
	
	public boolean[] calculateOpenSides(int[] pos) {
		//returns a bitmap of open sides
		//the index of a direction is the numerical value of the direction in CaveRoom
		boolean[] openSides = new boolean[4];
		
		for(int i = 0; i < openSides.length; i++) {
			openSides[i] = false;
		}
		
		for(int row = pos[0]-1; row <= pos[0]+1; row++) {
			for(int col = pos[1]-1; col <= pos[1]+1; col++) {
				if(row >= 0 && row < board.length && col >= 0 && col < board[row].length) {
					int rowOffset = row - pos[0];
					int colOffset = col - pos[1];
					//offsets cannot be equal, if they are then it is (0,0) or a diagonal, both are illegal moves
					if(board[row][col] == DimitrisBackend.emptyString && rowOffset != colOffset){
						if(row - pos[0] == -1) {
							openSides[CaveRoom.NORTH] = true;
						}
						if(row - pos[0] == 1) {
							openSides[CaveRoom.SOUTH] = true;
						}
						if(col - pos[1] == -1) {
							openSides[CaveRoom.WEST] = true;
						}
						if(col - pos[1] == 1) {
							openSides[CaveRoom.EAST] = true;
						}
					}
				}
			}
			
		}
		
		return openSides;
	}
	
	public void moveEntity(String entityString, int[] pos, int Direction) {
		//this function assumes that the bounds have been checked, the direction is valid, and the move is valid
		//ie it will throw an out of bounds exception and will overwrite entities that are in the space being moved to
		//the appropriate helper method( calcualteOpenSides does all of this checking and should be used)
		
		board[pos[0], pos[1]] = entityString;
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
 
 
 
 
 
 
 
