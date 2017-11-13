package raymondDerek;


public class RaymondBackEnd implements DerekSupporter{

	private	RaymondSupporter frontend;
	private int hp;
	private int level; //difficulty
	private int balls;
	
	public RaymondBackEnd(RaymondSupporter frontend) {
		this.frontend = frontend;
		hp = 100; 
		level = 1;
	}
	
	private int getHp() {
		return hp;
	}
	
	private int getLevel() {
		return level;
	}

}
     