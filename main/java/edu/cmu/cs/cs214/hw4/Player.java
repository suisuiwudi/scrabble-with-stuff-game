package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;

public class Player {
	private int score;
	private ArrayList<LetterTile> tiles;
	private String name;

	public Player(String name) {
		this.name = name;
	}

	public ArrayList<LetterTile> getLetters() {
		return tiles;
	}

	public String getName() {
		return name;
	}

}
