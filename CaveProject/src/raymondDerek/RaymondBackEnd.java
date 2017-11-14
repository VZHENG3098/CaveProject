package raymondDerek;


public class RaymondBackEnd implements DerekSupporter{

	private	RaymondSupporter frontend;
	private RaymondDerekPlot[][] plots;
	private int hp;
	private int level; //difficulty
	
	public RaymondBackEnd(RaymondSupporter frontend) {
		this.frontend = frontend;
		plots = new RaymondDerekPlot[7][7];
		hp = 100; 
		level = 1;
	}
	
	public void setMap() {
		for(int row = 0; row < plots.length; row++) {
			for(int col = 0; col < plots[row].length; col++) {
				plots[row][col] = new RaymondDerekPlot(row,col);
			}
		}
		
		
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getLevel() {
		return level;
	}

}
     