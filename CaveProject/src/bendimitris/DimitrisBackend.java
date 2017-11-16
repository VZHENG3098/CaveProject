package bendimitris;

public class DimitrisBackend implements BenSupport {
	
	int totalSec;
	String[][] board;
	
	DimitrisSupport frontend;

	public DimitrisBackend(DimitrisSupport frontend) {
		this.frontend = frontend;
	}

	@Override
	public void runGame() {
		startTimer();
		int gameLen = 180;
		while(totalSec < gameLen) {
			this.frontend.printBoard();
			executeTurn();
		}
		
		//loop runs every x seconds until the time is larger than gameLen
		
	}
	
	public void executeTurn() {
		
		frontend.moveTeacher();
		board = frontend.getBoard();
		movePeople();
		movePlayer();
		
		
	}
	
	public void movePlayer() {
		// get user input/movement
	}
	
	public int getInput() {
		return -1;
	}

	public void movePeople() {
		// TODO Auto-generated method stub
		
	}

	public void startTimer() {
		// TODO Auto-generated method stub
		
	}
	
}
