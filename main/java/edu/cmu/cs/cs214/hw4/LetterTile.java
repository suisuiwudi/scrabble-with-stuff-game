package edu.cmu.cs.cs214.hw4;


public class LetterTile extends Decorator{
	private char letter;
	private int value;
	private Square square;
	private Player player;
	public LetterTile(Square square, Player player){
		super(square,player);
	}
	@Override
	public char getLetter(){
		return letter;
	}
	public int getValue(){
		return value;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return super.getSquare().getName()+"|"+value+" "+letter;
	}
}
