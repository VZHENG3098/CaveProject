package raymondDerek;


public class RaymondBackEnd implements DerekSupporter{

	private	RaymondSupporter frontend;
	private RaymondDerekPlot[][] plots;
	private int hp;
	private int level; //difficulty
	private int playerPos; //col of player
	
	public RaymondBackEnd(RaymondSupporter frontend) {
		this.frontend = frontend;
		plots = new RaymondDerekPlot[7][7];
		hp = 100; 
		level = 1;
	}
	
	public void createMap() {
		for(int row = 0; row < plots.length; row++) {
			for(int col = 0; col < plots[row].length; col++) {
				plots[row][col] = new RaymondDerekPlot(row,col);
			}
		}
		
	}
	
	public void createBalls() {
		//create random balls top row
		for(int i = 0; i < plots[0].length; i++) {
			double rnd = (Math.random());
			if(rnd <= .25) {
				plots[0][i].setContainBall(true);
			}
		}
	}
	
	public void updateBallPos() {
		for(int row = 0; row < plots[0].length; row++) {
			for(int col = 0; col < plots[row].length; col++) {
				if(plots[row][col].isContainsBall()) {
					plots[row][col].setContainBall(false); //ball moves down
					plots[row + 1][col].setContainBall(true); 
				}
			}
		}
	}
	
	
	public int getHp() {
		return hp;
	}
	
	public int getLevel() {
		return level;
	}

	public boolean stillPlaying() {
		if(hp > 0) {
			return true;
		}
		return false;
	
	}

	public RaymondDerekPlot[][] getPlots() {
		return plots;
	}

}
     