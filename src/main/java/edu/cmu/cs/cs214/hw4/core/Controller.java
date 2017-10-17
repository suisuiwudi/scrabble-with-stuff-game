package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;

/**
 * The Class Controller.
 */
public class Controller {

	/** The players. */
	private ArrayList<Player> players;

	/** The order. */
	private int order;

	/** The current player. */
	private int currentPlayer;

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		order = 1;
		players = new ArrayList<>();
		currentPlayer = 0;
	}

	/**
	 * Adds the player.
	 *
	 * @param player
	 *            the player
	 */
	public void addPlayer(Player player) {
		players.add(player);
//		if(players.size() > 4) 
//			throw new IllegalArgumentException("TOO MANY PLAYERS");
	}

	/**
	 * Reverse order.
	 */
	public void reverseOrder() {
		order = -1;
	}

	/**
	 * Sets the score.
	 *
	 * @param score
	 *            the score
	 * @param string
	 *            the string
	 */
	public void setScore(int score, String string) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().equals(string)) {
				players.get(i).setScore(score);
			}
		}
	}

	/**
	 * Current player.
	 *
	 * @return the player
	 */
	public Player currentPlayer() {
		return players.get(currentPlayer);
	}

	/**
	 * Next player.
	 */
	public void nextPlayer() {
		currentPlayer += order;
		if (currentPlayer >= players.size())
			currentPlayer = 0;
		if (currentPlayer < 0)
			currentPlayer = players.size() - 1;
	}

	/**
	 * Adds the value in current player.
	 *
	 * @param value
	 *            the value
	 */
	public void addValueInCurrentPlayer(int value) {
		Player player = players.get(currentPlayer);
		player.setScore(player.getScore() + value);
//		players.set(currentPlayer, player);
	}

	/**
	 * Skip.
	 *
	 * @param string
	 *            the string
	 */
	public void skip(String string) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getName().equals(string)) {
				players.get(i).setSkip();
			}
		}
	}

	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

}
