package caveExplorer;


import raymondDerek.DerekCustomRoom;
import raymondDerek.RaymondCustomRoom;
import raymondDerek.RaymondDerekPlot;
import bendimitris.BenRoom;
import DavidVin.VincentRoomLQS;
import DavidVin.davidRoom;
import DavidVin.vincentRoom;

public class CaveRoom {

	private String description;
	private String directions;//tells you which doors can be used
	private String contents;//a symbol showing you what is in the room... 
	//...('X' when you are in the room)
	private String defaultContents;//what is in the room when you aren't in the room
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//NOTE: Arrays are instantiated with 'null' values
		borderingRooms = new CaveRoom[4];
		doors = new Door[5]; //extra door is used in explorable room
		setDirections();
	}

	
	/**
	 * for every Door in doors[] that is not null,
	 * this method appends a String to "directions" describing the door and where it is. For example:
	 *     There is a (passage) to (the North)
	 *     There is a (passage) to (the East)
	 * If there are no doors that are not null, this sets directions to:
	 *     "There is no way out. You are trapped in this room"
	 */
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "There is a "+doors[i].getDescription()+" to the "+
				toDirection(i)+". "+doors[i].getDetails()+"\n";
			}
		}
		if(!doorFound) {
			directions = "There is no way out. You are trapped in this room";
		}
		//hint: to check if a door is null (or not null), use:
		//doors[0] == null   (OR USE   doors[0] != null)
	}
	
	/**
	 * converts an int to a direction:
	 *    0 -> "the North"
	 *    1 -> "the East"
	 * hint: complete this method without using an if statement
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] direction = {"the North","the East","the South","the West"};
		//NOTE: when I say "no long if-else" statements,
		//this is how you should be thinking
		return direction[dir];
	}
	

	
	public void enter() {
		contents = "YOU";
	}
	
	public void leave() { 
		contents = defaultContents;
	}

	/**
	 * This is how we join rooms together.
	 * It gives this room access to anotherRoom and vice-versa
	 * It also puts the door between both rooms
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}

	public void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();//updates the directions
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
	
	/**
	 * override to create response to keys other than wdsa
	 * @param direction
	 */
	public void performAction(int direction) {
		CaveExplorer.print("That key does nothing.");
	}


	/**
	 * Override to change description of possible moves
	 */
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd'.");
	}

	/**
	 * override to add more moves
	 * @return
	 */
	public String validMoves() {
		return "wdsa";
	}

	/**
	 * returns true if w,a,s, or d is the input (NO IF STATEMENTS)
	 * @param input
	 * @return
	 */
	private boolean isValid(String input) {
		return validMoves().indexOf(input) > -1 && input.length() == 1;
	}

	/**
	 * THIS IS WHERE YOU EDIT YOUR CAVES
	 */
	public static void setUpCaves() {
		//1. Determine size of caves

		CaveExplorer.caves = new CaveRoom[7][10];

		CaveRoom[][] c = CaveExplorer.caves;//create a shortcut for accessing CaveExplorer.caves
		//2. Populate with default caves
		for(int row =0; row < c.length; row ++) {
			for(int col = 0; col < c[row].length; col++) {
				c[row][col] = new NPCRoom("This cave has coordinates "+row+", "+col);
			}
		}
		//3. Replace some default rooms with custom rooms (SAVE FOR LATER)
		//CaveRoom customRoom = new davidRoom("Room");
		//CaveExplorer.caves[1][1] = customRoom;

		
		

		 
		CaveRoom ER = new vincentRoom("Essay");
		CaveExplorer.caves[1][5] = ER;
		
		CaveRoom LQS = new VincentRoomLQS("LQS");
		CaveExplorer.caves[2][2] = LQS;
		
		CaveRoom english = new davidRoom("Money");
		CaveExplorer.caves[2][6] = english;

		CaveRoom DR = new DerekCustomRoom("Room");
		CaveExplorer.caves[0][1] = DR;
		
		CaveRoom R = new RaymondCustomRoom("Clothes");
		CaveExplorer.caves[1][2] = R;
		 
		//CaveRoom V = new vincentRoom("Healer");
		//CaveExplorer.caves[1][3] = V;

		c[1][1] = new BenRoom();

		
		
		
		
		


		//4.set starting room
		CaveExplorer.currentRoom = c[0][1];
		
		CaveExplorer.currentRoom.enter();
		
		//5. Set up doors

		
		for(int row = 0; row < c.length; row++) { // delete all doors
			for(int col = 0; col < c[row].length-1; col++) {
				if(row != 2 && row != 4) {
					c[row][col].setConnection(EAST, c[row][col+1], new Door());
				}				
			}
		}
		for(int row = 0; row < c.length-1; row++) {
			for(int col = 0; col < c[row].length; col++) {
				if((row != 1 && row != 4 && row != 3 && row != 2) || col == 0 || col == c[row].length -1) {	//add rows to remove, this will not affect the first and last collumns
					c[row][col].setConnection(SOUTH, c[row+1][col], new Door());
				}
				
				
				
			}
		}
		

//		c[1][0].setConnection(SOUTH, c[2][0], new Door()); // create the door
//		c[4][0].setConnection(SOUTH, c[5][0], new Door());
//		 
//		c[1][9].setConnection(SOUTH, c[2][9], new Door());
//		c[4][9].setConnection(SOUTH, c[5][9], new Door());


		

		//make doors lock after you walk in
		//teleport to a different room  
		//make map dark
		//make  a boss follow you (spawn after entry)
		//moving up and down (3D array, i.e. make a starway room)
		
		
		
	}
	public static void updatingRoom() {
		CaveRoom[][] c = CaveExplorer.caves;
		if(CaveExplorer.inventory.returnSchedule() == 0) {
			c[3][6].setConnection(NORTH, c[2][6], new Door());		// open door for english class
		}else if(CaveExplorer.inventory.returnSchedule() == 1){
			c[3][2].setConnection(NORTH, c[2][2], new Door());
		}
	}
	public void goToRoom(int direction) {
		//make sure there is a room to go to:
		if(borderingRooms[direction] != null && doors[direction] != null &&
				doors[direction].isOpen()) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}else {
			//print red text
			System.err.println("You can't do that!");
		}
	}

	/**
	 * returns the OPPOSITE direction
	 *   oD(0) returns 2
	 *   oD(1) returns 3
	 * @param dir
	 * @return
	 */
	public static int oppositeDirection(int dir) {
		return (dir + 2) % 4;
	}
	
	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}


	public Door getDoor(int direction) {
		return doors[direction];
	}
}

