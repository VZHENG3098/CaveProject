package DavidVin;

public class plot {


	private boolean revealed;
	private int row;
	private int col;
	private String letter;
	
	public plot(int row, int col) {
		revealed = false;
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
		
	}

	public void reveal(){
		revealed = true;
	}
	
	public void disreveal(){
		revealed = false;
	}

	
	public boolean isRevealed() {
		return revealed;
	}
	
	public String getLetter()
	{
		return letter;
	}
	public void setLetter(String a) {
		letter = a;
	}
	
	
}
