package caveExplorer;

public class Inventory {

	private String map;
	
	public boolean clothes;
	 
	private String contents;
	private int health;
	private int gold;
	public Inventory() {
		health = 50;
		gold = 0;
		updateMap();
		contents = "";
	}
	
	public void updateMap() {
		map = " ";
		clothes = false;
		//make hor. line across top:
		for(int i = 0; i < CaveExplorer.caves[0].length -1; i++) {
			map+="____";//4 underscores
		}
		map += "___\n";
		for(CaveRoom[] row: CaveExplorer.caves) {
			for(int i = 0; i < 3; i++) {
				String text = "";
				for(CaveRoom cr: row) {
					if(cr.getDoor(CaveRoom.WEST) != null && cr.getDoor(CaveRoom.WEST).isOpen()) {
						text += " ";
					} else {
						text += "|";
					}
					if(i == 0) {
						text += "   ";
					} else if ( i == 1) {
						text += " "+cr.getContents() + " ";
					} else if( i == 2) {
						if(cr.getDoor(CaveRoom.SOUTH) != null && cr.getDoor(CaveRoom.SOUTH).isOpen()) {
							text += "   ";
						} else {
							text += "___"; //closed door or wall
						}
					}
				}//last caveroom
				text += "|";
				map += text + "\n";
			}
		}
	}
	public void setHP() {
		health = 100;
	}
	public String getDescription() {
		return map ;
		//return "h is nothing in your inventory.";
	}
	public String getHealth() {
		return ""+health+"";
	}
	public void giveGold() {
		gold += 100 ;
	}
	public String getGold() {
		return ""+gold+"";
	}
	
	public String getContents()
	{
		return this.contents;
	}
	
	public void addToContents(String contents)
	{
		this.contents += contents +  ", ";
		CaveExplorer.print("You picked up " + contents);
	}
}

