package caveExplorer;

public class TwoDArrayPractice {

	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		
		for(String [] row: pic) {
			for(int col = 0;col < row.length; col++) {
				row[col] = " ";
			}
		}
	//	drawHorizontalLine(pic,2);
	//	drawVerticalLine(pic,2);
	//	drawSlot(pic,4,6);
		drawBox(pic,5,8);
		print(pic);
	}

	private static void drawBox(String[][] pic, int i, int j) {
		drawSlot(pic,i,j);
		drawSlot(pic,i+1,j);
		drawAt("_",pic,i-1,j);
		drawAt("_",pic,i-1,j+1);
		drawAt("_",pic,i-1,j-1);
	}

	private static void drawAt(String string, String[][] pic, int row, int col) {
		if(row>=0 && row < pic.length && col >= 0 && col < pic[row].length) {
			pic[row][col] = string;
		}
	}

	private static void drawSlot(String[][] pic, int i, int j) {
		if(i>= 0 && i <pic.length) {
			if(j>0 ) {
				pic[i][j-1] = "|";
			}
			if(j<pic[i].length) {
				pic[i][j+1] = "|";
			}
		}
			
		
	}

	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row = 0; row < pic.length; row++) {
			pic[row][col] = "|";
		}
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int i = 0; i <pic[row].length;i++) {
			pic[row][i] = "-";
			
		}
	}

	private static void print(String[][] pic) {
		for(String[] row:pic) {
			for(String col :row) {
				System.out.print(col);
			}
			System.out.println("");
		}
	}

}

