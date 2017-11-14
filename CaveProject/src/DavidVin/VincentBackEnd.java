package DavidVin;

import java.util.ArrayList;

public class VincentBackEnd implements davidSupport{
	private plot[][] memArr;
	private int arraySize;
	private vincentSupport frontend;
	
	
	public VincentBackEnd(vincentSupport frontend)
	{
		arraySize = 4;
		memArr = new plot[arraySize][arraySize];
		this.frontend = frontend;
		
		String[] arr1 = createArray(arraySize+arraySize);
		String [] arr2 = createArray(arraySize+arraySize);
		for(int i=0; i<16; i++)
		{
			
		}
	}


	private String[] createArray(int size) {
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
		
		int count = 0;
		while(count < size) {
			count++;
			int theNumber = (int)(Math.random()*letters.size());
			arr[count] = letters.get(theNumber);
			letters.remove(theNumber);
		}
		return arr;
				
	}
	
}

