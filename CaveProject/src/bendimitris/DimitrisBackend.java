package bendimitris;

public class DimitrisBackend implements BenSupport {
	DimitrisSupport frontend;

	public DimitrisBackend(DimitrisSupport frontend) {
		this.frontend = frontend;
	}

	@Override
	public void runGame() {
		movePeople();
		
	}
	
	@Override
	public void executeTurn() {
		getTeacherMove();
		frontend.getBoard();
	}
	
	public void getTeacherMove() {
		frontend.moveTeacher();
		
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

	@Override
	public void startTimer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean outOfTime() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
