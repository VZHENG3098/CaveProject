package raymondDerek;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class DerekFrontEnd implements RaymondSupporter {

	private DerekSupporter backend;
	private static Scanner inputSource = new Scanner(System.in);
	private int a;
	

	public static final void main(String[] args) {
		DerekFrontEnd demo = new DerekFrontEnd();
		demo.welcome();
	}

	public DerekFrontEnd() {
		backend = new RaymondBackEnd(this);
		a=1;
	}

	public void welcome() {
		CaveExplorer.print(
				"Welcome to Brooklyn Tech Dodgeball! Your goal is to complete and survive all the levels of this game. "
						+ "\nOnce you successfully complete this game, you will gain a gym pass. \nIt will help you throughout your day. ");
		play();
	}

	public void play() {
		int i = 0;
		while (backend.stillPlaying()) {
			CaveExplorer.print("You are on level "+ a);
			printhp(); 
			healthbar();
			displayBoard();
			userInput();
			backend.updateBallPos();
			i++;
			if (i % 3 == 0) {
				backend.createBalls();
			}
			// updateMap();
	//		showLevel();
		}
	}

	private void printhp() {
		CaveExplorer.print(backend.getHp() + " hp");
	}

	private void userInput() {
		CaveExplorer.print("Please type which direction you would like to goto.");
		String move = inputSource.nextLine();
		while (true) {
			if (move.equalsIgnoreCase("a")) {
				backend.userInput(-1);
				break;
			} else if (move.equalsIgnoreCase("d")) {
				backend.userInput(1);
				break;
			} else if (move.equalsIgnoreCase("s")) {
				backend.userInput(2); // 2 so nothing happens
				break;
			}else if(move.equalsIgnoreCase("win")){
				backend.userInput(3);
				break;
			} else {
				System.out.println("You may only press a, d, or s");
				move = inputSource.nextLine();
			}
		}
	}

	public void displayBoard() {
		RaymondDerekPlot[][] plots = backend.getPlots();
		for (int row = 0; row < plots[0].length; row++) {
			for (int col = 0; col < plots[row].length; col++) {
				if (row == 7 && col == backend.getPlayerPos()) {
					System.out.print(" X ");
				} else if (plots[row][col].isContainsBall()) {
					System.out.print(" o ");
				} else {
					if (col == 0 || col == 7) {
						System.out.print("|");
					} else {
						System.out.print("   ");
					}
				}
			}
			System.out.println("");
		}

	}

	public static String getInput() {
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

	// public void showLevel() {
	// if(backend.levelCode()) {
	// a++;
	// }
	// CaveExplorer.print("You are on level "+ a);
	//
	// }

	public void healthbar() {
//		String curr = "[_____]";
//
//		CaveExplorer.print(curr);
//
//		int currHp = backend.getHp();
//		int maxhp = 100;
//
//		if (maxhp == 100) {
//			System.out.println("[_____]");
//		} else if (maxhp == 80) {
//			System.out.println("[____]");
//		}
		int hp = backend.getHp()/20;
		String a = "[";
		for(int i = 0 ;i <= hp;i++) {
			if(i == hp) {
				 a = a+"]";
			}else {
				a = a + "_";
				
			}
		}
		CaveExplorer.print(a);
	}

}
