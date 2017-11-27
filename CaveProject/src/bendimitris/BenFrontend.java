package bendimitris;

import java.util.Scanner;

public class BenFrontend implements DimitrisSupport{
	public final DimitrisBackend realBackend;
	private String[][] board;
	private int[] teacherPos = {2, 3};
	
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
		board = setUpBoard(9, 9);
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
		realBackend.populatePeople(board, 18);
		realBackend.addPlayer(board);
		return board;
	}

	@Override
	public void moveTeacher() 
	{
		int direction = (int)(Math.random() * 4);
		String[] teacher = {"<", "^", ">", "v"};
		if (direction == 0 && teacherPos[1] > 0)
		{
			if (!(board[teacherPos[0]][teacherPos[1] - 1].equals(" ")))
			{
				teacherPos[1] -= 1;	    
			}
		}
		else if (direction == 1 && teacherPos[0] > 0)
		{
			if (!(board[teacherPos[0] - 1][teacherPos[1]].equals(" ")))
			{
				teacherPos[0] -= 1;	    
			}	
		}
		else if (direction == 2 && teacherPos[1] < (board[teacherPos[0]].length - 1))
		{
			if (!(board[teacherPos[0]][teacherPos[1] + 1].equals(" ")))
			{
				teacherPos[1] += 1;	    
			}	
		}
		else if (direction == 3 && teacherPos[0] < (board.length - 1))
		{
			if (!(board[teacherPos[0] + 1][teacherPos[1]].equals(" ")))
			{
				teacherPos[0] += 1;	    
			}
		}	
		board[teacherPos[0]][teacherPos[1]] = teacher[direction];
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
	
	public boolean caughtByTeacher()
	{
		String[] teacher = {"<", "^", ">", "v"};
		if (board[teacherPos[0]][teacherPos[1]].equals(teacher[0]))
		{
			return ((realBackend.getPlayerPosition()[0] == teacherPos[0]) && (realBackend.getPlayerPosition()[1] < teacherPos[1]));	    
		}
		else if (board[teacherPos[0]][teacherPos[1]].equals(teacher[1]))
		{
			return ((realBackend.getPlayerPosition()[1] == teacherPos[1]) && (realBackend.getPlayerPosition()[0] < teacherPos[0]));
		}
		else if (board[teacherPos[0]][teacherPos[1]].equals(teacher[2]))
		{
			return ((realBackend.getPlayerPosition()[0] == teacherPos[0]) && (realBackend.getPlayerPosition()[1] > teacherPos[1]));	    
		}
		else if (board[teacherPos[0]][teacherPos[1]].equals(teacher[3]))
		{
			return ((realBackend.getPlayerPosition()[1] == teacherPos[1]) && (realBackend.getPlayerPosition()[0] > teacherPos[0]));
		}
		return false;
	}
} 
