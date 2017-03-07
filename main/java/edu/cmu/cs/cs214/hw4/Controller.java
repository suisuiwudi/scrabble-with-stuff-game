package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;

public class Controller {
	private ArrayList<Player> players;
	private int order;
	private int playersNum;
	public Controller(){
		order = 1;
	}
	public void addPlayer(Player player){
		players.add(player);
		playersNum++;
	}
	public void reverseOrder(){
		order = -1;
	}
	public Player nextPlayer(){
		return new Player("1");
	}
}
