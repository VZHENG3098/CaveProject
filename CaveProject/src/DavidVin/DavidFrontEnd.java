package DavidVin;

import java.util.Scanner;

public class DavidFrontEnd implements vincentSupport {
	
	private static Scanner inputSource = new Scanner(System.in);

	public static boolean victory;
	public static int row;
	public static int col;
	
	
	public DavidFrontEnd()
	{
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
		System.out.println("\n"+"Each match is worth 60 points.");
		System.out.println("\n"+"You have 20 turns to find the matching pairs, or else you lose.");
	}
	
	public static void play()
	{
		rules();
		VincentBackEnd.startArray();
		plot[][] plot = VincentBackEnd.getPlot();
		displayBoard(plot);
		
		
		while(victory==false) {
			
	    	String firstCoordinate = getCords(plot); // format is 5,5 , is a string
	    	displayBoard(plot); // displays letter in the plot
	    	System.out.println("\nEnter your second coordinate.");                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	    	String SecondCoordinate = getCords(plot);
	    	displayBoard(plot);
	    	
	    	
	    	VincentBackEnd.checkAnswer(firstCoordinate, SecondCoordinate);
	    	
	    	if(VincentBackEnd.checkAnswer(firstCoordinate, SecondCoordinate)==true)
	    	{
	    		System.out.println("\nDing Ding Ding You gain ten points");
	    	}
	    	
	    	
	    	System.out.println("\nYou currently have "+VincentBackEnd.getPoints()+" points");
	    	int turns = VincentBackEnd.getTurns();
	    	System.out.println("You have "+ turns + " flips left");
	    	
	    	
	    	if(VincentBackEnd.getPoints()==60)	
	    	{
	    		System.out.println("Congrats you won.");
	    		victory=true;
	    	}
	    	
	    	
		}
	}
	
	public static String getCords(plot[][] arr)
	{
		boolean finish = false;
		String coordinate = getInput();
		while(finish == false) {
			if(VincentBackEnd.isCorrectFormat(coordinate, arr)) {
				finish = true;
				return coordinate;
			}else {
				System.out.println("Please type the coordinate like this example 0,0 and each number is less than " + (arr.length-1));
				coordinate = getInput();
			}
		}
		return coordinate;
	}
	
	public static void displayBoard(plot[][] arr)
	{
		for(int row = 0; row < arr.length; row++){
			System.out.println("");
			for(int col = 0; col < arr[row].length; col++)
			{
				if(arr[row][col].isRevealed()) {
					System.out.print((arr[row][col].getLetter()));
				}
				else
				{
					System.out.print(".");
				}
			}
		}
	}
	
	
}





