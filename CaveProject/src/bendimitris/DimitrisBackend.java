package bendimitris;

public class DimitrisBackend implements BenSupport {
	
	int totalSec;
	
	DimitrisSupport frontend;

	public DimitrisBackend(DimitrisSupport frontend) {
		this.frontend = frontend;
	}

	@Override
	public void runGame() {
		startTimer();
		int gameLen = 180;
		while(totalSec < gameLen) {
			executeTurn();
		}
		
		//loop runs every x seconds until the time is larger than gameLen
		
	}
	
	@Override
	public void executeTurn() {
		
		frontend.moveTeacher();
		frontend.getBoard();
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

	@Override
	public boolean outOfTime() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
