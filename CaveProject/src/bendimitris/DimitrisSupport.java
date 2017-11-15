package bendimitris;

public interface DimitrisSupport {
	
	public void printBoard();
	public void setUpBoard(int width, int hieght);
	public void moveTeacher();
	public void startGame();
	public String[][] getBoard();
	public void setBoard(String[][] board);

	// make sure to add a function to tell the user how to play the game
	// also check for win and lose conditions
}
