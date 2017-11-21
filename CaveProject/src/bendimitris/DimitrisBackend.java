package bendimitris;

import caveExplorer.CaveExplorer;

public class DimitrisBackend implements BenSupport {
	
	private int totalSec;
	private String[][] board;
	private int[] playerPosition;
	private int[][] line;
	
	static String playerString = "X";
	static String emptyString = "";
	
	
	
	
	DimitrisSupport frontend;

	public DimitrisBackend(DimitrisSupport frontend) {
		this.frontend = frontend;
	}

	@Override
	public void runGame() {
		//main loop
		
		int maxTurns = 20;
		int cnt = 0;
		
		while(cnt < maxTurns) {//if player takes a long time to decide, then scanner will block using up precious time
			this.frontend.printBoard(); //print the board each turn
			executeTurn(); //then update state
		}
		
	}
	
	public void executeTurn() {
		
		frontend.moveTeacher(); //first ben moves teacher
		board = frontend.getBoard(); //then I get the updated state
		playerPosition = getPlayerPosition(); //get the player posistion for later stages
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
	
	public void moveEnitity(int[] pos, int direction) {
		
	}

	public void movePeople() {
		//people move in a line, occasionally people will leave a hole in the line (ie the person will not move)
		//front of the line is closest to the lunch counter
		

		
	}

	@Override
	public String[][] addLunchCounter(String[][] board) {
		if(board.length != 0 && board[0].length != 0) {
			board[0][board[0].length-1] = ")"; //the bottom left corner is the lunch counter
		}
		return board;
	}

	@Override
	public String[][] populatePeople(String[][] board, int sizeOfLine) {
		line = new int[sizeOfLine][2]; //each person has a coordinate
		int cnt = 0;
		while(hasFreeSpace(board) && sizeOfLine < cnt) {
			cnt++;
		}
		return board;
	}
	
	public boolean hasFreeSpace(String[][] board) {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[row].length; col++) {
				if(board[row][col] == DimitrisBackend.emptyString) {
					return true;
				}
			}
		}
		return false;
	}
	
}
 
 
 
 
 
 
 
