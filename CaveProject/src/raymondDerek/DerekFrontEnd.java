package raymondDerek;

import caveExplorer.CaveExplorer;

public class DerekFrontEnd implements RaymondSupporter {

	private DerekSupporter backend;

	public static final void main(String[] args) {
		DerekFrontEnd demo = new DerekFrontEnd();
		demo.play();
	}

	public DerekFrontEnd() {
		backend = new RaymondBackEnd(this);
	}		

	public void play() {
		while (backend.stillPlaying()) {
			displayBoard();
			break;
//			userInput();
//			updateMap();
		}
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

}
