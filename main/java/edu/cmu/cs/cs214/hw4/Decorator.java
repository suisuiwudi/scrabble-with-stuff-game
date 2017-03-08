package edu.cmu.cs.cs214.hw4;

public abstract class Decorator implements Square{
	private Player owner;
	private Square square;
	public Decorator(Square square, Player player){
		this.square = square;
		this.owner = player;
	}

	public abstract String getName();
	public Player getOwner(){
		return owner;
	}
	public int getX(){
		return square.getX();
	}
	public int getY(){
		return square.getY();
	}
	public Square getSquare(){
		return square;
	}
	public Player getPlayer(){
		return owner;
	}
	public char getLetter(){
		return '\0';
	};
	public int getValue(){
		return 0;
	};
}

