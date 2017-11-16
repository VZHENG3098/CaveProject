package raymondDerek;

import java.util.Scanner;

public class RaymondBackEnd implements DerekSupporter{

	private static Scanner r = new Scanner(System.in);
	private	RaymondSupporter frontend;
	private RaymondDerekPlot[][] plots;
	private int hp;
	private int level; //difficulty
	private int playerPos; //col of player
	private int points;
	
	public RaymondBackEnd(RaymondSupporter frontend) {
		this.frontend = frontend;
		plots = new RaymondDerekPlot[8][8];
		createMap();
		hp = 100; 
		level = 1;
		points = 0;
	}
	
	public void createMap() {
		for(int row = 0; row < plots.length; row++) {
			for(int col = 0; col < plots[row].length; col++) {
				plots[row][col] = new RaymondDerekPlot(row,col);
			
			}
		}
		
		playerPos = (int)(Math.random()*7) + 1;
		createBalls();
//		updateBallPos();
		 
	}
	
	public int getPlayerPos() {
		return playerPos;
	}
	
	// use to move player
	//-1 to move left
	// 1 to move right
	public void userInput(int move) {
		if(move == 1) {
			if(playerPos + 1 < 7) {
				playerPos += 1;
			}
		}
		
		if(move == -1) {
			if((playerPos - 1 >= 0)) {
				playerPos -= 1;
			}
		}
	}
	
	
	public void createBalls() {
		//create random balls top row
		for(int i = 1; i < plots[0].length; i++) {
			if(Math.random() < .5) {
				plots[0][i].setContainBall(true);
			}
		}
	}
	
	public void updateBallPos() {
		for(int row = 0; row < plots[0].length; row++) {
			for(int col = 0; col < plots[row].length; col++) {
				if(plots[row][col].isContainsBall()) {
					plots[row][col].setContainBall(false); //ball moves down
					if(row != plots.length -1) {
						plots[row + 1][col].setContainBall(true); 
					}
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
     