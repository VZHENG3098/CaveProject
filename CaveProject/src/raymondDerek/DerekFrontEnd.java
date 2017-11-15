package raymondDerek;

import caveExplorer.CaveExplorer;

public class DerekFrontEnd implements RaymondSupporter {

	private DerekSupporter backend;
	private int points;

	public static final void main(String[] args) {
		DerekFrontEnd demo = new DerekFrontEnd();
		demo.play();

	}

	public DerekFrontEnd() {
		backend = new RaymondBackEnd(this);
		points = 0;
	}		

	public void play() {
		while (backend.stillPlaying()) {
			displayBoard();
			
			userInput();
			updateMap();
			updatePoints();
		}
	}

	public void displayBoard() {
		RaymondDerekPlot[][] plots = backend.getPlots();
		

	}

}
