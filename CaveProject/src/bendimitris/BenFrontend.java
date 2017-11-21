package bendimitris;

import java.util.Scanner;

import caveExplorer.CaveExplorer;

public class BenFrontend implements DimitrisSupport{
	private static DimitrisBackend realBackend;
	private String[][] board;
	
	public BenFrontend() 
	{
		realBackend = new DimitrisBackend((DimitrisSupport)this);
	}
	
	public static void main(String[] args) 
	{
		BenFrontend realFrontend = new BenFrontend();
		caveExplorer.CaveExplorer.in = new Scanner(System.in);
		realFrontend.board = realFrontend.setUpBoard(4, 7);
		realBackend.addLunchCounter(realFrontend.board);
		realBackend.populatePeople(realFrontend.board, 7);
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
		for (int y = 0; y < board.length; y += 1)
		{
			for (int x = 0; x < board[y].length; x += 1)
			{
				if (y == 1)
				{
					if (x == 5)
					{
						board[y][x] = "X";
					}
					else
					{
						board[y][x] = " ";
					}
				}
				else
				{
					if (x == 3 && y == 2)
					{
						board[y][x] = "^";
					}
					else
					{
						board[y][x] = " ";
					}
				}
			}
		}
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
} 
