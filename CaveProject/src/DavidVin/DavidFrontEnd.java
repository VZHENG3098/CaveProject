package DavidVin;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class DavidFrontEnd implements vincentSupport {
	
	private static Scanner inputSource = new Scanner(System.in);

	public static boolean victory;
	public static int row;
	public static int col;
	public static boolean cheatActivated;
	
	public DavidFrontEnd()
	{
		cheatActivated = false;
		victory = false;
		play();	
	}
	public static String getInput(){
		
		return inputSource.nextLine();
	}
	
	public static void rules()
	{
		System.out.println("\nWelcome to English Class.");
		System.out.println("\nYou forgot to do you summer reading assignment.");
		System.out.println("\nYou ask your neighbor for the homework so you can copy it.");
		System.out.println("\nHe said he will only let you copy off him, if you are able to earn 60 points in a matching game.");
		System.out.println("\n"+"The rules are simple flip two cards to see if you have a match.");
		System.out.println("\n"+"Each match is worth 10 points.");
		System.out.println("\n"+"You have 25 turns to find the matching pairs, or else you lose.");
	}
	
	
	public static void play()
	{
		VincentBackEnd.startArray();
		plot[][] plot = VincentBackEnd.getPlot();
		displayBoard(plot,"0,0");
		
		while(victory==false) {
			
	    	String firstCoordinate = getCords(plot); // format is 5,5 , is a string
	    	displayBoard(plot,firstCoordinate); // displays letter in the plot
	    	System.out.println("\nEnter your second coordinate.");                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	    	String SecondCoordinate = getCords(plot);
	    	displayBoard(plot,SecondCoordinate);
	    	
	    	if(VincentBackEnd.checkAnswer(firstCoordinate, SecondCoordinate)==true)
	    	{
	    		System.out.println("\nDing Ding Ding You gain ten points");
	    	}
	    	int turns = VincentBackEnd.getTurns();
	    	if(turns==0)
            {
                System.out.println("YOU LOST! You feint from the stress and lose 5 stamina.");
                CaveExplorer.inventory.decreaseStamina(5);
                victory=true;
            }
	    	System.out.println("\nYou currently have "+VincentBackEnd.getPoints()+" points");
	    	System.out.println("You have "+ turns + " flips left");
	    	
	    	if(VincentBackEnd.getPoints()==60)	
	    	{
	    		System.out.println("Congrats you won. Here is 10 stamina!");
	    		VincentBackEnd.Victory();
	    		CaveExplorer.inventory.increaseStamina(10);
	    		victory=true;
	    	}
		}
	}
	
	public static String getCords(plot[][] arr)
	{
		boolean finish = false;
		String coordinate = getInput();
		while(finish == false) {
			if(coordinate.equals("cheat")) {
				if(cheatActivated == true) {
					System.out.println("You already activated your cheats");
				}
				cheatActivated = true;
				displayBoard(arr,"1,1");
				System.out.println("");
				
				coordinate = getInput();
			}
		else if(VincentBackEnd.isCorrectFormat(coordinate, arr)) {
				finish = true;
				if(VincentBackEnd.checkForSpecialBock(coordinate) && cheatActivated == false){
					System.out.println("THERE IS A SPECIAL BLOCK NEAR YOU!");
				}
				return coordinate;
			}else {
				System.out.println("Please type the coordinate like this example 0,0 and each number is less than " + (arr.length-1));
				coordinate = getInput();
			}
		}
		return coordinate;
	}
	
	public static void displayBoard(plot[][] arr,String coords)
	{
		
		boolean specialBlock = false;
		int[] coordinates = VincentBackEnd.covertToCoordinate(coords);
		int a = coordinates[0];
		int b = coordinates[1];
		
		if(arr[a][b].getSpecialPlot() == true) {
			specialBlock = true;
		}
		System.out.print("   0  1  2  3  4  5"); //displays the col coordinates
		for(int row = 0; row < arr.length; row++){
			System.out.print("\n"+row+" "); //displays the row coordinates
			for(int col = 0; col < arr[row].length; col++)
			{
				if(cheatActivated == true) {
					System.out.print(("["+arr[row][col].getLetter()+"]"));
				}
				else if(checkForAdjacency(coords,row,col) == true && specialBlock == true){
					System.out.print(("["+arr[row][col].getLetter()+"]"));
				}
				else if(arr[row][col].isRevealed()) {
					System.out.print(("["+arr[row][col].getLetter()+"]"));
				}
				else
				{
					System.out.print("[?]");
					if(row == 6 && col == 6)
					{
						System.out.println(""); //when user types something it appears below the grid
					}
				
				}
			}
			if(specialBlock ==true) {
				arr[a][b].usedSpecialPlot();
			}
		}
	}
	
	public static boolean checkForAdjacency(String coords,int a1,int b1) { //adjustment to Vincent's method
		int[] coordinates = VincentBackEnd.covertToCoordinate(coords);
		int a = coordinates[0];
		int b = coordinates[1];
		int startRow =  VincentBackEnd.avoidAIOOBEStart(a);
		int endRow =  VincentBackEnd.avoidAIOOBEEnd(a);
		int startCol =  VincentBackEnd.avoidAIOOBEStart(b);
		int endCol =  VincentBackEnd.avoidAIOOBEEnd(b);
		
		for(int row = startRow; row <=  endRow; row++){
			for(int col = startCol; col <= endCol; col++){
				if(row == a1 && col == b1) {
					return true;
				}
			}
		}		
		return false;
	}
	
	public String setDirections() {
		return "";
	}
	
}