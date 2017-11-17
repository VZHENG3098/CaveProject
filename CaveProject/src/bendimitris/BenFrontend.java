package bendimitris;

public class BenFrontend implements DimitrisSupport{
	static BenSupport backend;
	String[][] board;
	
	public BenFrontend(BenSupport backend) 
	{
		this.backend = backend;
	}
	
	public static void main(String[] args) 
	{
		BenFrontend frontend = new BenFrontend(backend);
		frontend.board = frontend.setUpBoard(4, 7);
		frontend.printBoard();
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
	public void moveTeacher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[][] getBoard() 
	{
		return this.board;
	}
} 