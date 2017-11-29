package bendimitris;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;

public class DimitrisRoom extends CaveRoom {

	public DimitrisRoom() {
		super("EXIT");
	}
	
	public String getContents() {
		return "EXT";
		
	}
	
	public void enter() {
		if(CaveExplorer.inventory.returnSchedule() == CaveExplorer.inventory.scheduleLen() -1) {
			if(CaveExplorer.inventory.getIntStamina() > 10) {
				System.out.println("WOW you did really well in school today");
			} else {
				System.out.println("Welcome to tech! :) we serve cake tommorow!"); //portal reference
				System.out.println("You will do better tommorow...");
			}
			
			System.out.println("play agian? (y/n)");
			String response = CaveExplorer.in.nextLine();
			if(response.toLowerCase() == "y") {
				CaveExplorer.main(null);
			}
			else {
				System.out.println("Thanks for playing");
			}
			System.exit(0); //exits JVM no matter how nested
		}
		else {
			System.out.println("you have not yet completed your day");
			System.out.println("A security gard glares at you and prevents you from leaving");
		}
		
		super.enter();
	}

}
