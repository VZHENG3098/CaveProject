package DavidVin;

public class plot {


	private boolean revealed;
	private int row;
	private int col;
	private String letter;
	private boolean specialPlot;
	
	public plot(int row, int col) {
		specialPlot = false;
		revealed = false;
		this.row = row;
		this.col = col;
	}
	
	public void setSpecialPlot(){
		specialPlot = true;
	}
	public void usedSpecialPlot(){
		specialPlot = false;
	}
	
	public boolean getSpecialPlot() {
		return specialPlot;
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