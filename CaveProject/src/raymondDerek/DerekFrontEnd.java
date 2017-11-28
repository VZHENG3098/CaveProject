package raymondDerek;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class DerekFrontEnd implements RaymondSupporter {

	private static DerekSupporter backend;
	private static Scanner inputSource = new Scanner(System.in);

	public DerekFrontEnd() {
		backend = new RaymondBackEnd(this);
		welcome();
	}

	public void welcome() {
		CaveExplorer.print(
				"Welcome to Brooklyn Tech Dodgeball! Your goal is to complete and survive all the levels of this game. "
						+ "\nOnce you successfully complete this game, you will gain a gym pass. \nIt will help you throughout your day. ");
	}

	public static void play() {

		int i = 0;
		while (backend.stillPlaying()) {
			// shows the current level
			CaveExplorer.print("You are on level " + backend.getLevel());
			// updates how many balls are present in each corresponding level
			backend.updateBallPos();
			healthbar();
			printhp();
			displayBoard();
			// checks user input
			userInput();
			// checks suggestions
			suggestionInput();
			i++;
			if (i % 3 == 0) {
				backend.createBalls();
			}
			// updateMap();
			// showLevel();
		}
		if (backend.getHp() <= 20) {
			// penalty for losing
			CaveExplorer.print("You have lost all your health points and as a result, lost 5 stamina.");
			CaveExplorer.inventory.decreaseStamina(5);
		} else {
			CaveExplorer.print("Today's your lucky day, there are no more dodgeballs");
			CaveExplorer.inventory.increaseStamina(10);
		}

	}

	public static void printhp() {
		CaveExplorer.print(backend.getHp() + " hp");
	}

	public static void userInput() {
		CaveExplorer.print("Please type which direction you would like to goto.");
		String move = inputSource.nextLine();
		while (true) {
			if (move.equalsIgnoreCase("a")) {
				// goes left
				backend.userInput(-1);
				break;
			} else if (move.equalsIgnoreCase("d")) {
				// goes right
				backend.userInput(1);
				break;
			} else if (move.equalsIgnoreCase("s")) {
				// stay still
				backend.userInput(2);
				break;
			} else if (move.equalsIgnoreCase("win")) {
				// win is a cheat code
				backend.userInput(3);
				break;
			} else {
				System.out.println("You may only press a, d, or s");
				move = inputSource.nextLine();
			}
		}
	}

	public static void displayBoard() {
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

	public String getInput() {
		return inputSource.nextLine();
	}

	public static void healthbar() {
		// hp bar
		int hp = backend.getHp() / 5;
		String a = "HP BAR: [";
		for (int i = 0; i <= hp; i++) {
			if (i == hp) {
				a = a + "]";
			} else {
				a = a + "_";

			}
		}
		CaveExplorer.print(a);
	}

	public static void suggestionInput() {
		// suggested moves
		String move = "the suggested move is to not ";
		if (backend.giveSuggestion() == "") {
			CaveExplorer.print("There is no suggested move");
		} else {
			CaveExplorer.print(move + backend.giveSuggestion());
		}
	}

}