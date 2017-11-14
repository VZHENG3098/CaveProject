package DavidVin;

import java.util.ArrayList;

import caveExplorer.NPCRoom;

public class VincentBackEnd implements davidSupport{
	private static plot[][] memArr;
	private static int arraySize;
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
		arraySize = 4;
		memArr = new plot[arraySize][arraySize];
		String[] arr1 = createArray(arraySize+arraySize);
		String [] arr2 = createArray(arraySize+arraySize);
		int count = 0;
		for(int row =0; row < memArr.length; row ++) {
			for(int col = 0; col < memArr[row].length; col++) {
				System.out.println(arr1[count]);
				
				if(row <= 2) {
					memArr[row][col].setLetter(arr1[count]);
				}else {
					memArr[row][col].setLetter(arr2[count-8]);
				}
				count++;
			}
		}
		System.out.println(memArr[1][2]);
		System.out.println(memArr[1][3]);
		System.out.println(memArr[1][4]);
		
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

