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
	
	public static void play()
	{
		VincentBackEnd.startArray();
		while(victory==false){
			plot[][] plot = VincentBackEnd.getPlot();
	    	System.out.println("Flip two cards to see if you have a match.");
	    	displayBoard(plot);
	    	
	    	String firstCoordinate = getCords(plot); // format is 5,5 , is a string
	    	String SecondCoordinate = getCords(plot);
	    	
	    	
	    	VincentBackEnd.checkAnswer(firstCoordinate, SecondCoordinate);
	    	
	    	
	    	
	    	System.out.println(VincentBackEnd.getPoints());
	    	int turns = VincentBackEnd.getTurns();
	    	System.out.println(turns);
	    	
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
	
	public static void displayBoard(plot[][] plot)
	{
		for(int row = 0; row < plot.length; row++){
			for(int col = 0; col < plot[row].length; col++){
				if(plot[row][col].isRevealed()){

				}else{
					System.out.print(".");
				}
			}
		}
	}
}