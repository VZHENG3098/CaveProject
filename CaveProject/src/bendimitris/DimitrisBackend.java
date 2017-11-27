package bendimitris;


import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class DimitrisBackend implements BenSupport {
	
	private String[][] board;
	
	private boolean wonGame = false;
	private boolean endGame = false;
	
	static String playerString = "X";
	static String emptyString = " ";
	
	
	
	
	DimitrisSupport frontend;

	public DimitrisBackend(DimitrisSupport frontend) {
		this.frontend = frontend;
	}

	@Override
	public void runGame() {		
		while(!endGame) {//if player takes a long time to decide, then scanner will block using up precious time
			this.frontend.printBoard(); //print the board each turn
			executeTurn(); //then update state
		}
		if(wonGame) {
			System.out.println("you won the game");
		}
		else {
			System.out.println("you lost the game");
		}
	}
	
	public void executeTurn() {
		frontend.moveTeacher(); //first ben moves teacher
		board = frontend.getBoard(); //then I get the updated state
		
		
		if(frontend.caughtByTeacher()) {//check if caught
			endGame = true;
			System.out.println("You were caught by the teacher");
			return;
		}
		
		movePeople(); //using this updated state I move p
		movePlayer();
		
		
	}
	
	public void movePlayer() {
		// get user input/movement
		
		
		int direction = getInput();
		boolean[] possiblePlayerMoves = calculateOpenSides(getPlayerPosition());
//		for(boolean bool : possiblePlayerMoves) {
//			System.out.println(bool);
//		}
//		System.out.println(direction);
		if(possiblePlayerMoves[direction]) {
			
			moveEntity(getPlayerPosition(), direction);
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
	
	public int getInput() {
		while(true) {
			String input = CaveExplorer.in.nextLine();
			if(input.length() == 1) {
				if("wdsa".indexOf(input)!= -1) {
					return "wdsa".indexOf(input);
				}
			}
			
			
			frontend.printBoard();
			System.out.println("invalid direction");
			
		}
		
		
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
						if(colOffset == 0) {
							if(row - pos[0] == -1) {
								openSides[CaveRoom.NORTH] = true;
							}
							if(row - pos[0] == 1) {
								openSides[CaveRoom.SOUTH] = true;
							}
						}
						
						if(rowOffset == 0) {
							if(col - pos[1] == -1) {
								openSides[CaveRoom.WEST] = true;
							}
							if(col - pos[1] == 1 ) {
								openSides[CaveRoom.EAST] = true;
							}
						}
						
						
					}
				}
			}
			
		}
		
		return openSides;
	}
	
	public void moveEntity(int[] pos, int direction) {
		//this function assumes that the bounds have been checked, the direction is valid, and the move is valid
		//ie it will throw an out of bounds exception and will overwrite entities that are in the space being moved to
		//the appropriate helper method( calcualteOpenSides does all of this checking and should be used)
		
		
		switch(direction) {
		case(CaveRoom.EAST) :
			board[pos[0]][pos[1]+1] = board[pos[0]][pos[1]];
			break;
		case(CaveRoom.NORTH) :
			board[pos[0]-1][pos[1]] = board[pos[0]][pos[1]];
			break;
		case(CaveRoom.WEST) :
			board[pos[0]][pos[1]-1] = board[pos[0]][pos[1]];
			break;
		case(CaveRoom.SOUTH) :
			board[pos[0]][pos[1]+1] = board[pos[0]][pos[1]];
			break;
		}
		board[pos[0]][pos[1]] = DimitrisBackend.emptyString;
	}
	
	
	public String[][] populatePeople(String[][] board, int sizeOfLine) {
		
		int[] currentPos = new int[2];
		
		//start line to the left of the counter
		currentPos[0] = 0;
		currentPos[1] = board[0].length-3;
		
		//start adding people
		for(int cnt = 0; cnt < sizeOfLine; cnt++) {
			//System.out.println("setup");
			
			
			if(currentPos[0] < board.length-3) {
				if((int)(Math.random()*3) != 1) {
					board[currentPos[0]][currentPos[1]] = "P"; //random chance that a person will be missing in line
				}
				
				currentPos[0]++;
			}
			else {
				if(currentPos[1] > 1) {
					if((int)(Math.random()*3) != 1) {
						board[currentPos[0]][currentPos[1]] = "P"; //random chance that a person will be missing in line
					}
					currentPos[1]--;
				}
				
			}
			
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
	
	public boolean wonGame() {
		return wonGame;
	}
	
	public String[][] addLunchCounter(String[][] board) {
		if(board.length != 0 && board[0].length != 0) {
			board[0][board[0].length-1] = ")"; //the bottom left corner is the lunch counter
		}
		return board;
	}

	public void movePeople() {
		// moves all of the people preserving the line
		//people move left until they are at the column before the counter
		//then they move up until they reach  the  same hight as the counter
		//they are then removed from the line
		
		//line always starts next to the counter
		int[] currentPos = new int[2];
		currentPos[0] = 0;
		currentPos[1] = board[0].length-3;
		
		
		int[] startPos = new int[2];
		startPos[0] = currentPos [0];
		startPos[1] = currentPos[1];
		
		boolean personLeft = false;
				
		while(true) {
			//System.out.println("setup");
			if(currentPos[0] < board.length-2) {
				if(currentPos[0] == startPos[0] && currentPos[1] == startPos[1]) {
					if(board[currentPos[0]][currentPos[1]] == "P") { //add random change not to move person
						board[currentPos[0]][currentPos[1]] = DimitrisBackend.emptyString;
					}
					if(board[currentPos[0]][currentPos[1]] == DimitrisBackend.playerString) {
						//this is the end condition --> getting to the counter before people run out
						wonGame = true;
						endGame = true;
						break;
					}
					
				}else if(board[currentPos[0]][currentPos[1]] == "P") { 
					personLeft = true;
					if(calculateOpenSides(currentPos)[CaveRoom.NORTH] && (int)(Math.random()*3) != 1) {//add random chance not to move person
						moveEntity(currentPos, CaveRoom.NORTH);
						
					}
					
				}
				currentPos[0]++;
			}
			else {
				if(currentPos[1] >= 0) {
					if(board[currentPos[0]-1][currentPos[1]] == "P") {
						personLeft = true;
						if(calculateOpenSides(currentPos)[CaveRoom.EAST] && (int)(Math.random()*3) != 1) {
							//System.out.print("moving");
							int[] movePos = new int[2];
							movePos[0] = currentPos [0]-1; //it wants the deincrement
							movePos[1] = currentPos[1];
							moveEntity(movePos, CaveRoom.EAST);
							
						}
					}
					
					currentPos[1]--;
				}else {
					break;
				}
				
			}
			
		}
		
		this.endGame = this.endGame || !personLeft; //the game is over if there are no people left
		
		
	}

	public void addPlayer(String[][] board) {
		//player starts in upper left corner
		board[3][1] = DimitrisBackend.playerString;
	}
	
}
 
 
 
 
 
 
 
