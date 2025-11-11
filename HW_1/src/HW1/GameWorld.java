package HW1;

public class GameWorld {
private String worldName; //changed to 'worldName' to get more context
private Player[]players;
private Enemy[]enemies;
private int difficulty;

//max player and enemies in game world
private static int MAX_PLAYERS = 20;
private static int MAX_ENEMIES = 20;


//default builder
public GameWorld() {
	this.worldName = "Crystal Path";
	this.difficulty = 1;
	players = new Player[MAX_PLAYERS];
	enemies = new Enemy[MAX_ENEMIES];
	
}

//parameter builder
public GameWorld(String name , int difficulty) {
	this.worldName = worldName;
		
	//check if selected difficulty is between 1 - 3 
	if(difficulty < 1) {
		this.difficulty = 1;
		
		} else if(difficulty > 3) {
			this.difficulty = 3;
		
		} else {
			this.difficulty = difficulty;
		}
		
players = new Player[MAX_PLAYERS];
enemies = new Enemy[MAX_ENEMIES];

}


public boolean addPlayer(Player player) {
	if(player == null) return false;
	
		for(int i = 0 ; i < players.length; i++) {
			if(players[i] == null) {
				players[i] = player;
				return true;
			}
		}
		
		return false; //no room for additional players!
		
}

//prints all player details
public void printAllPlayers() {
	for(int i = 0; i < players.length; i++) {
		if(players[i] !=  null) { //checks if array has players before printing
			System.out.println("Player #" + (i + 1) + players[i].toString());
			System.out.println();
			
		}
	}
}

//calc the total value for every player in game world
public int getTotalValueOfWorld() {
	int total = 0;
	 
		for(int i = 0; i < players.length; i++) {
			if(players[i] == null) { //checking for players in game world
				
				int pValue = players[i].calculateInventory(); //variable for storing each player item value
				total = total + pValue;
			}
		}
		
		
		return total;
}


@Override
//print all world details
public String toString() {
	int pCount = 0;
	
		for(int i = 0; i < players.length; i++) {
			if(players[i] != null) {
				pCount++;
			}
		}
		
		return "World name : " + worldName + "\n" +
				"Difficulty : " + difficulty + "\n" +
				"Number Of Players : " + pCount;
	}

}
