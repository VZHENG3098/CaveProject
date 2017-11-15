package bendimitris;

public interface BenSupport 
{
	public void runGame();
	public void executeTurn(); // helper method for code already inside rungame
	public void startTimer();
	public boolean outOfTime();
}
