package bendimitris;

	
	
public class DimitrisBenMinigame 
{
	private String[][] board;
	
	public DimitrisBenMinigame()
	{
		board = new String[3][7];
		setUpBoard();
		printBoard();
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
}

