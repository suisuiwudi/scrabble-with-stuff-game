package edu.cmu.cs.cs214.hw4;

public class BoardLetterTile extends Square{
	private LetterTile letterTile;
	public BoardLetterTile(LetterTile letterTile){
		this.letterTile = letterTile;
	}
	public boolean hasLetterTile(){
		return true;
	}
	public LetterTile getLetterTile(){
		return letterTile;
	}
}
