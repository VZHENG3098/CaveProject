package bendimitris;

import java.util.Scanner;

public class DimitrisBenMinigame 
{
	private String[][] board;
	private boolean playing;
	private int roundNumber;
	private Scanner in = new Scanner(System.in);
	
	public DimitrisBenMinigame()
	{
		board = new String[4][7];
		playing = true;
	}
	
	public void runGame() 
	{
		// generate random place in line to open a space every other turn, have the teacher
		// face a random direction every turn, add one to skip for every person you skip
		
		// only get opening every other round
		if (roundNumber % 2 == 0)
		{
			int openingY = (int)(Math.random() * board.length);
			int openingX;
			if (openingY > 0)
			{
				openingX = 1;
			}
			else
			{
				openingX = (int)(Math.random() * board[openingY].length);
			}
			
			if (board[openingY][openingX].equals("X") || board[openingY][openingX].equals("^") || board[openingY][openingX].equals(" "))
			{
				runGame();
			}
			else
			{
				board[openingY][openingX] = " ";
				board[openingY][board[openingY].length - 1] = "P";
			}
		}
		
		getMove();
		
		printBoard();
		
		playing = false;
	}

	private void getMove() 
	{
		
	}

	public void printBoard()
	{
		for (int y = 0; y < board.length; y += 1)
		{
			for (int x = 0; x < board[y].length; x += 1)
			{
				System.out.print(board[y][x]);
			}
			System.out.println("");
		}
	}
	
	public void setUpBoard()
	{
		for (int y = 0; y < board.length; y += 1)
		{
			for (int x = 0; x < board[y].length; x += 1)
			{
				if (x == 0)
				{
					board[y][x] = "P";
				}
				else if (y == 0)
				{
					if (x < 6)
					{
						board[y][x] = "P";
					}
					else
					{
						board[y][x] = " ";
					}
				}
				else if (y == 1)
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
				else if (y == 3)
				{
					board[y][x] = " ";
				}
				else
				{
					if (x == 3)
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
	}
	
	public void startGame()
	{
		setUpBoard();
		
		roundNumber = 0;
		while (playing)
		{
			runGame();
		}
	}
}

