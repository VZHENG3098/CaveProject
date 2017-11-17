package bendimitris;

public class BenFrontend implements DimitrisSupport{
	static BenSupport backend;
	static DimitrisSupport frontend;
	String[][] board;
	
	public BenFrontend(BenSupport backend) 
	{
		this.backend = backend;
	}
	
	public static void main(String[] args) 
	{
		BenFrontend realFrontend = new BenFrontend(backend);
		DimitrisBackend realBackend = new DimitrisBackend(frontend);
		realFrontend.board = realFrontend.setUpBoard(4, 7);
		realFrontend.moveTeacher();
		realFrontend.printBoard();
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
}  
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
