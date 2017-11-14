package bendimitris;

public interface DimitrisSupport {
	
	public void printBoard();
	public void setUpBoard();
	public void moveTeacher();
	public void startGame();
	public String[][] getBoard();

	// make sure to add a function to tell the user how to play the game
	// also check for win and lose conditions
}
