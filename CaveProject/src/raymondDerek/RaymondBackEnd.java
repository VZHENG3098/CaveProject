package raymondDerek;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class RaymondBackEnd implements DerekSupporter{

	private static Scanner r = new Scanner(System.in);
	private	RaymondSupporter frontend;
	private RaymondDerekPlot[][] plots;
	private int hp;
	private int level; //difficulty
	private int playerPos; //col of player
	private int points;
	private int moves;
	private boolean skip;
	private int  numBalls; //how dodgeballs per round
	
	public RaymondBackEnd(RaymondSupporter frontend) {
		this.frontend = frontend;
		plots = new RaymondDerekPlot[8][8];
		createMap();
		hp = 100; 
		level = 1;
		points = 0;
		skip = false;
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
	// 2 to stay in same position
	// 3 for the cheat code
	public void userInput(int move) {
		if(plots[7][playerPos].isContainsBall()) {
			System.out.println("You were hit by a ball!");
			setHp();
		}
		
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
		 
		if(move == 3) {
			setSkip(true);
		}
		
		moves++; //used to level
		
	}
	
	
	public void createBalls() {
		//create random balls top row
		int x = 0;
		for (int i = 1; i < plots[0].length - 1; i++) {
			if (Math.random() < .5) {
				if (x < getNumBalls()) {
					plots[0][i].setContainBall(true);
					x++;
				} else {
					break;
				}
			}
		}
		
		
		
		//fill remaining col with balls if not enough for the level
		if(x != getNumBalls()) {
			for(int i = 1; i < plots[0].length - 1; i++) {
				if(plots[0][i].isContainsBall() == false) {
					plots[0][i].setContainBall(true);
					x ++;
				}
				if(x == getNumBalls()) {
					break;
				}
			}
		}
		
		
		
		
		 
	}
	
	public void updateBallPos() {
		int[] tempArr = new int[100];
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
	
	public String giveSuggestion() {
		String suggestion = "";
		if(plots[6][getPlayerPos() + 1].isContainsBall()) {
			suggestion += "move to the right,";
		}
		if(plots[6][getPlayerPos() - 1].isContainsBall()) {
			suggestion += "move to the left";
		}
		return suggestion;
	}
	
	
	public void setHp() {
		hp -= 20;
	}
	 
	public int getHp() {
		return hp;
	}
	
	
	//level initially at 1
	public int getLevel() {
		if(moves > 20) {
			level = 3;
		} else if (moves > 10) {
			level = 2;
		} else {
			level = 1;
		}
		
		return level;
	}

	public void setSkip(boolean a) {
		skip = a;
	}
	
	public boolean getSkip() {
		return skip;
	}
	
	public int getNumBalls() {
		int l = getLevel();
		if(l == 1) {
			return 3;
		} else if (l == 2) {
			return 4;
		} else {
			return 5;
		}
		
	}
	
	
	public boolean stillPlaying() {
		
		//40 moves to win
		if(moves == 40) {
			return false;
		}
		
		if(getSkip()) {
			return false;
		}
		
		if(hp > 0) {
			return true;
		} 
		return false;
	
	}
 
	public RaymondDerekPlot[][] getPlots() {
		return plots;
	}


	

}