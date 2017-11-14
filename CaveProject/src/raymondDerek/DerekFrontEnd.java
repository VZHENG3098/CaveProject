package raymondDerek;


public class DerekFrontEnd implements RaymondSupporter {

	private DerekSupporter backend;
	
	public static final void main(String[] args) {
		DerekFrontEnd demo = new DerekFrontEnd();
		demo.play();
		
	}
	
	public DerekFrontEnd() {
		backend = new RaymondBackEnd(this);
		
	}
	
	public void play() {
		displayPoints();
	}
	
	public void displayPoints() {
		
	}
	
	
}
 