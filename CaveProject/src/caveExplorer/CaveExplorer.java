package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][] caves;
	public static Scanner in;//for user input
	public static CaveRoom currentRoom;//changes as the user moves
	public static Inventory inventory;
	public static boolean playing = true;
	public static NPC[] npcs;
	
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();//creates caves and starting room
		inventory = new Inventory();
		startExploring();
	}

	public static void print(String s) {
		System.out.println(s);//LATER: consider replacing with the more sophistocated "printMultiLine"
	}
	
	private static void startExploring() {
		while(playing) {
			//moveNPCs(); --causing program to terminate early
			print(inventory.getDescription());
			print("You have "+inventory.getStamina()+" Stamina left.");
			inventory.decreaseStamina(1); // decrease stamina each time you move 
			print(currentRoom.getDescription());
			print(currentRoom.getDirections());
			print("What would you like to do?");
			currentRoom.interpretInput(in.nextLine());
			CaveRoom.updatingRoom();
            if(inventory.getIntStamina() <= 0) {
            	System.out.println("You have 0 Stamina left and taken to the hospital");
                playing = false;
            }
		}
	}

//	private static void moveNPCs() {
//		for(NPC n: npcs) {
//			n.autoMove();
//		}
//		inventory.updateMap();
//	}

}