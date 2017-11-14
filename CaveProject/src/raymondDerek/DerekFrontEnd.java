package raymondDerek;


public class DerekFrontEnd implements RaymondSupporter {

	private DerekSupporter backend;
	
	public static final void main(String[] args) {
		DerekFrontEnd demo = new DerekFrontEnd();
		
	}
	
	public DerekFrontEnd() {
		backend = new RaymondBackEnd(this);
		
	}
	
	public void play() {
		
	}
	
	public void displayPoints() {
		System.out.println(RaymondDerekPlot.getPoint());
	}
	
	
}
  