package bendimitris;

public interface DimitrisSupport {
	
	public void printBoard();
	public String[][] setUpBoard(int length, int width);
	public void moveTeacher();
	public String[][] getBoard();
	public void setBoard(String[][] board);
	public boolean caughtByTeacher();

	// make sure to add a function to tell the user how to play the game
	// also check for win and lose conditions
}
