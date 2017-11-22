package raymondDerek;

public interface DerekSupporter {

	void createBalls();

	boolean stillPlaying();

	RaymondDerekPlot[][] getPlots();

	int getPlayerPos();

	void userInput(int i);

	void updateBallPos();

	int getHp();

	int getLevel();

	//boolean levelCode();

}

