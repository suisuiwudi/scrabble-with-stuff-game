package edu.cmu.cs.cs214.hw4.SpecialTile;

import edu.cmu.cs.cs214.hw4.Decorator;
import edu.cmu.cs.cs214.hw4.GameSystem;
import edu.cmu.cs.cs214.hw4.Player;
import edu.cmu.cs.cs214.hw4.Square;

public abstract class SpecialTile extends Decorator {
	private Player owner;
	private Square square;
	public SpecialTile(Square square, Player player){
		super(square,player);
	}

	public abstract String getName();
	
}
