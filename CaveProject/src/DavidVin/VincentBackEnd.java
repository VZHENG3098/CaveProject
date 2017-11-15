package DavidVin;

import java.util.ArrayList;

import caveExplorer.NPCRoom;

public class VincentBackEnd implements davidSupport{
	private static plot[][] memArr;
	private static int arraySize;
	private static int turns;
	private static int points;
	private vincentSupport frontend;
	
	
	public VincentBackEnd(vincentSupport frontend)
	{
		turns = 25;	
		points = 0;
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
		arraySize = 4;
		memArr = new plot[arraySize][arraySize];
		String[] arr1 = createArray(arraySize+arraySize);
		String [] arr2 = createArray(arraySize+arraySize);
		int count = 0;
		for(int row = 0; row < memArr.length; row ++) {
			for(int col = 0; col < memArr[row].length; col++) {
				if(count <= 7) {
					memArr[row][col] = new plot(row, col);
					memArr[row][col].setLetter(arr1[count]);
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
	
	public int getTurns(){
		return turns;
	}
	
	public static boolean checkAnswer(String a1, String a2) {
		// a1 and a2 = number,number
		int [] coordinate1 = covertToCoordinate(a1);
		int [] coordinate2 = covertToCoordinate(a2);
		turns--;
		if(memArr[coordinate1[0]][coordinate1[1]].getLetter().equals((memArr[coordinate2[0]][coordinate2[1]].getLetter()))) { // checks the letter are equal
			points = points + 10;
			return true;
		}
		return false;	
	}
	public static int[] covertToCoordinate(String input) {
		int number1 = Integer.parseInt(input.substring(0,1));
		int number2 = Integer.parseInt(input.substring(2,3));
		int[] coordinate = {number1,number2};
		return coordinate;
		
	}
	public static boolean isCorrectFormat(String a1,plot[][] arr) {
		try{
			int a = Integer.parseInt(a1.substring(0,1));
			int b = Integer.parseInt(a1.substring(2,3));
			
			if( a < arr.length && b < arr.length) {
				return true;
			}
			return false;
		}catch(Exception e){
			return false;
		}
	}
	public static String[] createArray(int size) {
		String[] arr = new String[size];
		
		ArrayList<String> letters = new ArrayList<String>();
		letters.add("A");
		letters.add("B");
		letters.add("C");		
		letters.add("D");
		letters.add("E");
		letters.add("F");
		letters.add("G");
		letters.add("H");
		
		for(int i = 0 ; i<size;i++) {
			int theNumber = (int)(Math.random()*letters.size());
			arr[i] = letters.get(theNumber);
			letters.remove(theNumber);
		}

		return arr;
				
	}
	
}

