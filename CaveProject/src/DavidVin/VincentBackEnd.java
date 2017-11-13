package DavidVin;

public class VincentBackEnd implements davidSupport{
	private plot[][] memArr;
	private int arraySize;
	private vincentSupport frontend;
	
	
	public VincentBackEnd(vincentSupport frontend)
	{
		arraySize = 4;
		memArr = new plot[arraySize][arraySize];
		this.frontend = frontend;
		
		String[] arr1 = createArray(arraySize);
		String [] arr2 = createArray(arraySize);
		for(int i=0; i<16; i++)
		{
			
		}
	}


	private String[] createArray(int size) {
		String[] arr = new String[size];
		
		String[] letters = {"A","B","C","D","E","F","G","H"};
		for (int i = 0;i<arr.length ; i++) {
			arr[i] = letters[i];
		}
		return arr;
				
	}
	
}

