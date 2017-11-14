package bendimitris;

public class DimitrisBackend implements BenSupport {
	DimitrisSupport frontend;

	public DimitrisBackend(DimitrisSupport frontend) {
		this.frontend = frontend;
	}
	
}
