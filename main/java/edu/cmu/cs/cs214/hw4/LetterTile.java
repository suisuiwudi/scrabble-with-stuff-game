package edu.cmu.cs.cs214.hw4;


public class LetterTile {
	private char letter;
	private int value;
	public LetterTile(char letter, int value){
		this.letter = letter;
		this.value = value;
	}
	
	public char getLetter(){
		return letter;
	}
	public int getValue(){
		return value;
	}
}
