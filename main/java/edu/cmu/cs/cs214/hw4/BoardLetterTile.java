package edu.cmu.cs.cs214.hw4;

public class BoardLetterTile extends Square{
	private LetterTile letterTile;
	private Square square;
	public BoardLetterTile(Square square, LetterTile letterTile){
		this.letterTile = letterTile;
		this.square = square;
	}
	public LetterTile getLetterTile(){
		return letterTile;
	}
	@Override
	public boolean hasLetterTile(){
		return true;
	}
	@Override
	public char getLetterTileName(){
		return letterTile.getLetter();
	}
	
	
}
