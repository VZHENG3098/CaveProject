package raymondDerek;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class DerekFrontEnd implements RaymondSupporter {

	private DerekSupporter backend;
	private static Scanner inputSource = new Scanner(System.in);
	private int playerPos;
	private int a;
	
	public static final void main(String[] args) {
		DerekFrontEnd demo = new DerekFrontEnd();
		demo.play();
	}

	public DerekFrontEnd() {
		backend = new RaymondBackEnd(this);
	}		

	public void play() {
		while (backend.stillPlaying()) {
			userInput();
			displayBoard();
			break;
			
//			updateMap();
		}
	}

	private int userInput() {
		CaveExplorer.print("Please type which box you would like to goto.");
		String answer = getInput();
		for(int i =0;i<answer.length();i++) {
			if(isInteger(answer)) {
				a = i;
			}
		}
		playerPos = a;
		return playerPos;
	}

	public void displayBoard() {
		RaymondDerekPlot[][] plots = backend.getPlots();
		for(int row = 0; row < plots[0].length; row++) {
			for(int col = 0; col < plots[row].length; col++) {
				if(plots[row][col].isContainsBall()) {
					System.out.print(" o ");
				} else {
					System.out.print("   ");
				}
				
				if(row == plots.length - 1 && col == backend.getPlayerPos()) {
					System.out.println(" X ");
				}
			}
			System.out.println("");
		}

	}
	
	public static String getInput(){
		return inputSource.nextLine();
	}

	public static boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	}
	
	public int getPlayerPos() {
		return playerPos;
	}
}
