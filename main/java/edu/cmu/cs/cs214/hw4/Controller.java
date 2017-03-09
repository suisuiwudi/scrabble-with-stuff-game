package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;

public class Controller {
	private ArrayList<Player> players;
	private int order;
	private int currentPlayer;
	public Controller(){
		order = 1;
		players = new ArrayList<>();
	}
	public void addPlayer(Player player){
		players.add(player);
	}
	public void reverseOrder(){
		order = -1;
	}
	
	public void setScore(int score,String string){
		for (int i = 0; i < players.size(); i++){
			if (players.get(i).getName().equals(string)){
				players.get(i).setScore(score);			
			}
		}
	}
	public Player currentPlayer(){
		return players.get(currentPlayer);
	}
	public void nextPlayer(){
		currentPlayer += order;
		if (currentPlayer >= players.size()) currentPlayer = 0;
		if (currentPlayer < 0) currentPlayer = players.size() - 1;
	}
	public void addValueInCurrentPlayer(int value){
		Player player = players.get(currentPlayer);
		player.setScore(player.getScore()+value);
		players.set(currentPlayer, player);
	}
	public void skip(String string){
		for (int i = 0; i < players.size(); i++){
			if (players.get(i).getName().equals(string)){
				players.get(i).setSkip();			
			}
		}
	}
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
}
