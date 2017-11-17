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
		
		playerPos = (int)(Math.random()*6) + 1;
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
		for(int col = 0; col < 7; col++) {
			if(plots[7][col].isContainsBall()) {
				plots[7][col].setContainBall(false);
			}
		}
		if(move == 1) {
			if(playerPos + 1 < 7) {
				playerPos += 1;
			}
		}
		
		if(move == -1) {
			if((playerPos - 1 > 0)) {
				playerPos -= 1;
			}
		}
	}
	
	
	public void createBalls() {
		//create random balls top row
		for(int i = 1; i < plots[0].length - 1; i++) {
			if(Math.random() < .5) {
				plots[0][i].setContainBall(true);
			}
		}
	}
	
	public void updateBallPos() {
		int[] tempArr = new int[50];
		int tempIdx = 0;
		for(int row = 0; row < plots.length; row++) {
			for(int col = 0; col < plots[row].length; col++) {
				if(plots[row][col].isContainsBall() && row < 7) {
					plots[row][col].setContainBall(false);
					tempArr[tempIdx] = row + 1;
					tempIdx++;
					tempArr[tempIdx] = col;
					tempIdx++;
				}
				
		
			}
		}
		for(int i = 0; i < tempArr.length - 1; i++) {
			if((tempArr[i] > 0)) { //PREVENT INDEX GOING -1 AND BALL RELOOPING TO TOP
				plots[(tempArr[i])][(tempArr[i+1])].setContainBall(true);				
			}
			i++;
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
     