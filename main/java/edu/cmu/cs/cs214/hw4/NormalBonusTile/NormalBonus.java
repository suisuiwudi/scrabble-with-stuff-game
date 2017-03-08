package edu.cmu.cs.cs214.hw4.NormalBonusTile;

import edu.cmu.cs.cs214.hw4.LetterTile;
import edu.cmu.cs.cs214.hw4.Player;
import edu.cmu.cs.cs214.hw4.Square;
import edu.cmu.cs.cs214.hw4.Word;

public abstract class NormalBonus implements Square {
	private int x;
	private int y;
	public NormalBonus(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX(){
		return x;
	};
	public int getY(){
		return y;
	};
	public abstract String getName();
	public Player getOwner(){
		return new Player("dummy");
	};
	public char getLetter(){
		return '\0';
	};
	public int getValue(){
		return 0;
	};
}
