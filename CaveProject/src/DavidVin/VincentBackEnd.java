package DavidVin;

import java.util.ArrayList;

import caveExplorer.CaveExplorer;
import caveExplorer.NPCRoom;

public class VincentBackEnd implements davidSupport{
	private static plot[][] memArr;
	private static int arraySize;
	private static int turns;
	private static int points;
	private vincentSupport frontend;
	
	
	public VincentBackEnd(vincentSupport frontend)
	{
/*		arraySize = 4;
		memArr = new plot[arraySize][arraySize];
		this.frontend = frontend;
		
		String[] arr1 = createArray(arraySize+arraySize);
		System.out.println(arr1);
		String [] arr2 = createArray(arraySize+arraySize);
		for(int i=0; i<16; i++)
		{
			
		}*/
	}
	
	public static void startArray() {
		turns = 25;	
		points = 0;
		arraySize = 4;
		memArr = new plot[arraySize][arraySize];
		String[] arr1 = createArray(arraySize+arraySize); // gets letter in random order {a,c,e,g,h} ect
		String [] arr2 = createArray(arraySize+arraySize);
		int count = 0; 
		for(int row = 0; row < memArr.length; row ++) {
			for(int col = 0; col < memArr[row].length; col++) {
				if(count <= 7) {
					memArr[row][col] = new plot(row, col); // create plot
					memArr[row][col].setLetter(arr1[count]); // set the letter for the plot
				}else {
					memArr[row][col] = new plot(row, col);
					memArr[row][col].setLetter(arr2[count-8]);
				}
				count++;
			}
		}
	}
	
	public static plot[][] getPlot(){
		return memArr;		
	}
	
	public static int getTurns(){
		return turns;
	}
	public static int getPoints() {
		return points;
	}
	public static boolean checkAnswer(String a1, String a2) {
		// a1 and a2 = number,number
		int [] coordinate1 = covertToCoordinate(a1);
		int [] coordinate2 = covertToCoordinate(a2); 
		if(memArr[coordinate1[0]][coordinate1[1]].getLetter().equals((memArr[coordinate2[0]][coordinate2[1]].getLetter()))) { // checks the letter are equal
			points = points + 10;
			memArr[coordinate1[0]][coordinate1[1]].reveal();
			memArr[coordinate2[0]][coordinate2[1]].reveal();
			return true;
		}
		turns--;
		memArr[coordinate1[0]][coordinate1[1]].disreveal();
		memArr[coordinate2[0]][coordinate2[1]].disreveal();
		return false;	
	}
	public static int[] covertToCoordinate(String input) { // convert a string of 1,3 to a coordinate
		int number1 = Integer.parseInt(input.substring(0,1));
		int number2 = Integer.parseInt(input.substring(2,3));
		int[] coordinate = {number1,number2};
		return coordinate;
		
	}
	public static boolean isCorrectFormat(String a1,plot[][] arr) { // check front end coordinate
		try{
			if(a1.length() > 4) {
				return false;
			}
			int a = Integer.parseInt(a1.substring(0,1));
			int b = Integer.parseInt(a1.substring(2,3));
			if(	arr[a][b].isRevealed()) { // if the point is already used return false
				return false;
			}
			if (a1.substring(1,2).equals(",")) // need 
			if( a < arr.length && b < arr.length) {
				arr[a][b].reveal();
				return true;
			}
			return false;
		}catch(Exception e){
			return false;
		}
	}
	public static void Victory() {
		CaveExplorer.inventory.essayTrue();
		CaveExplorer.inventory.nextClass();
	}
	public static String[] createArray(int size) { // create an random array of letter
		String[] arr = new String[size];
		
		ArrayList<String> letters = new ArrayList<String>(); // created a arraylist because it is easier to remove letter
		letters.add("A"); // kinda redundant 
		letters.add("B");
		letters.add("C");		
		letters.add("D");
		letters.add("E");
		letters.add("F");
		letters.add("G");
		letters.add("H");
		
		for(int i = 0 ; i<size;i++) {
			int theNumber = (int)(Math.random()*letters.size());
			arr[i] = letters.get(theNumber); // set the letter
			letters.remove(theNumber); // remove the letter from the array so it doesn't repeat.
		}

		return arr;
				
	}
	
}

