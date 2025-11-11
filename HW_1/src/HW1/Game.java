package HW1;


//this is the Main program of the assignment
// another comments are welcome below..

public class Game {
public static void main(String[] args) {
	//creating new items
	item[]items = new item[5];
	items[0] = new item("Exculiber" , 150 , true);
	items[1] = new item ("Elder Wand" , 350 , true);
	items[2] = new item ("Great sword" , 50 , false);
	items[3] = new item ("Hunter's Bow" , 20 , false);
	items[4] = new item ("Assassin's Dagger" , 15 , false);
	
	
	//creating new players
	Player[] players = new Player[5];
	players[0]= new Player("MonsterHunt3r" , 10 , 1);
	players[1] = new Player("AlbusDumbeld0r" , 10 , 1);
	players[2] = new Player("Warrior1212" , 10 , 1);
	
	//adding items to each player
	players[0].addItem(items[2]);
	players[1].addItem(items[1]);
	players[2].addItem(items[4]);
	
	//creating enemies
	//*** to be implemented *** 
	Enemy goblin = new Enemy("Goblin" , 1  );
	Enemy zombie = new Enemy("Undead warrior" , 2);
	Enemy troll = new Enemy("Troll" , 3) ;
	
	//creating game world
	GameWorld gw = new GameWorld("Skyrim" , 2  );
	
	//adding players to game world
	gw.addPlayer(players[0]);
	gw.addPlayer(players[1]);
	gw.addPlayer(players[2]);
	
	//printing all players in the game world
	gw.printAllPlayers();
	
	//printing all player inventory value
	System.out.println("===== Player inventory list : =====");
	System.out.println();

	int totalValueP1 = players[0].calculateInventory();
	System.out.println(players[0].getName() + " - " + totalValueP1 );
	
	int totalValueP2 = players[1].calculateInventory();
	System.out.println(players[1].getName() + " - " + totalValueP1 );
	
	int totalValueP3 = players[2].calculateInventory();
	System.out.println(players[2].getName() + " - " + totalValueP1 );
	
	


	}


// Battle simulation 
public static void battleSim (Player player , Enemy enemy) {
	System.out.println(player.getName() + " - level -  " + player.getLevel() + 
						"VS . " + enemy.getName() + " - level - ");
	
	if(player.getLevel() > enemy.getLevel() ) {
		System.out.println(player.getName() + " Wins!!!");
		player.setLevel(player.getLevel() + 1);
		
	} else if (player.getLevel() < enemy.getLevel()) {
		 System.out.println(enemy.getName() + " Wins!!!");
		 enemy.setLevel(enemy.getLevel() + 1);
	
	} else {
		System.out.println("It's a draw!!!!");
		
	}
	




}
}
