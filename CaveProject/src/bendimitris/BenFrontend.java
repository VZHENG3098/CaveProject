package bendimitris;

import java.util.Scanner;

public class BenFrontend implements DimitrisSupport{
	private static DimitrisBackend realBackend;
	private String[][] board;
	
	public BenFrontend() 
	{
		realBackend = new DimitrisBackend(this);
	}
	
	public static void main(String[] args) 
	{
		BenFrontend realFrontend = new BenFrontend();
		caveExplorer.CaveExplorer.in = new Scanner(System.in); //memory leak - only useful for debugging
		realFrontend.startGame();
	}
	
	public void startGame() { //initialized the game
		board = setUpBoard(5, 5);
		moveTeacher();
		realBackend.runGame();
	}

	public void printBoard()
	{
		for (int y = 0; y < this.board.length; y += 1)
		{
			for (int x = 0; x < this.board[y].length; x += 1)
			{
				System.out.print(this.board[y][x]);
			}
			System.out.println("");
		}
	}

	public String[][] setUpBoard(int length, int width)
	{
		String[][] board = new String[length][width];
		
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[row].length; col++)
			{
				board[row][col] = " ";
			}
		}
		
		realBackend.addLunchCounter(board);
		realBackend.populatePeople(board, 5);
		realBackend.addPlayer(board);
		return board;
	}

	@Override
	public void moveTeacher() 
	{
		int direction = (int)(Math.random() * 4);
		String[] teacher = {"<", "^", ">", "v"};
		board[2][3] = teacher[direction];
	}

	@Override
	public String[][] getBoard() 
	{
		return this.board;
	}

	@Override
	public void setBoard(String[][] board) 
	{
		this.board = board;
	}
	
	public boolean isEnd
	{
		String[] teacher = {"<", "^", ">", "v"};
		return ((board[2][3].equals(teacher[1]) && realBackend.getPlayerPosition()[0] == 0) || (board[2][3].equals(teacher[0]) && realBackend.getPlayerPosition()[0] == 2));
	}
} 
