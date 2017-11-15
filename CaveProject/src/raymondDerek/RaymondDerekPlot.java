package raymondDerek;


public class RaymondDerekPlot{

	private boolean containsBall;
	private int row;
	private int col;
	
	
	public RaymondDerekPlot(int row, int col) {
		containsBall = false;		this.row = row;
		this.col = col;
	}
	
	public boolean isContainsBall() {
		return containsBall;
	}
	
	public void setContainBall(boolean containsBall) {
		this.containsBall = containsBall;
	}

	public void setPoint(int points) {
		points++;
	}
	
	public int getPoint() {
		return points;
	}

	public int getRow() {
		return row;
	}


	public int getCol() {
		return col;
	}



	
}
    