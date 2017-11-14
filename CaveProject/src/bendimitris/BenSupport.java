package bendimitris;

public interface BenSupport 
{
	public void runGame();
	public void movePeople(); // helper method for code already inside rungame
	public void getMove(); // get user input/movement
	public void startTimer();
	public boolean outOfTime();
}
