package DavidVin;

import caveExplorer.CaveExplorer;
import caveExplorer.CaveRoom;
import caveExplorer.NPCRoom;

public class DavidRoomHiddenWater extends NPCRoom {
	
	public boolean lead;
	
	public DavidRoomHiddenWater(String description) {
		super(description);
		super.setContents("wf");
		double x = (int) Math.floor(Math.random() * 101);
		if(x<50)
		{
			lead = true;
		}
		else
		{
			lead = false;
		}
		
		// TODO Auto-generated constructor stub
	}
	
	public String getContents() {
		return "   ";
		
	}
	
	public void printValidMoves() {
		System.out.println("You can only enter 'w', 'a', 's', or 'd' to move "
				+ "or you can press 'e' to interact.");
	}

	/**
	 * override to add more moves
	 * @return
	 */
	public String validMoves() {
		return "wdsae";
	}

	/**
	 * override to create response to keys other than wdsa
	 * @param direction
	 */ 
	public void performAction(int direction) {
		if(direction == 4 && CaveExplorer.inventory.drinksLeft()>0) {
			if(lead==false)
			{
				CaveExplorer.print("The water you drank was very refreshing. You gain 5 stamina");
				CaveExplorer.inventory.increaseStamina(5);
			}
			else
			{
				CaveExplorer.print("Oh no the water you drank contained lead. You lost 5 stamina.");
				CaveExplorer.inventory.decreaseStamina(5);
			}
				
			 CaveExplorer.inventory.subDrink();
		}
		else {
			CaveExplorer.print("That key does nothing");
			
		}
	}
	public String getDescription() {
		
		if(CaveExplorer.inventory.drinksLeft()<=0)
		{
			return "\nThe fountain is out of water.";
		}
		
		return "\nYou see a water fountain. You can press e to take a drink.";
		
	}
	
}