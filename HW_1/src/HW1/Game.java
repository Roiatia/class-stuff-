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
	
	
	//creating game world
	GameWorld gw = new GameWorld("Skyrim" , 2  );
	
	gw.printAllPlayers();
	
	
	
	}
}
