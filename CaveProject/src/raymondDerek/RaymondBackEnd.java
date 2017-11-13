package raymondDerek;


public class RaymondBackEnd implements DerekSupporter{

	private	RaymondSupporter frontend;
	private int hp;
	private int level; //difficulty
	
	public RaymondBackEnd(RaymondSupporter frontend) {
		this.frontend = frontend;
	}

}
     