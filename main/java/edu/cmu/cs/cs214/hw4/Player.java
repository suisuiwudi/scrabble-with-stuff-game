package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;

import edu.cmu.cs.cs214.hw4.SpecialTile.SpecialTile;

public class Player {
	private int score;
	private ArrayList<LetterTile> letterTiles;
	private ArrayList<SpecialTile> specialTiles;
	private String name;
	private boolean skip;
	private int id;

	public Player(String name) {
		this.name = name;
		letterTiles = new ArrayList<>();
		specialTiles = new ArrayList<>();
		score = 0;
		skip = false;
	}
	public void setSkip(){
		skip = true;
	}
	public void unsetSkip(){
		skip = false;
	}
	public boolean getSkip(){
		return skip;
	}
	public ArrayList<LetterTile> getLetters() {
		return letterTiles;
	}

	public String getName() {
		return name;
	}
	
	public int getScore(){
		return score;
	}
	public void setScore(int score){
		this.score = score;
	}
	public void deleteLetterTile(ArrayList<LetterTile> letterTiles){
		ArrayList<LetterTile> tmp = new ArrayList<>();
	
			for (LetterTile tileGot: this.letterTiles){
				boolean deleteFlag = false;
				for (LetterTile deleteTile : letterTiles){
					if (deleteTile.getLetter() == tileGot.getLetter())
						deleteFlag = true;
				}
				if (!deleteFlag) tmp.add(tileGot);
			}
			this.letterTiles = tmp;
		
	}
	public void addLetterTiles(ArrayList<LetterTile> letterTiles){
		this.letterTiles.addAll(letterTiles);
	}
	

}
