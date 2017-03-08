package edu.cmu.cs.cs214.hw4.SpecialTile;

import edu.cmu.cs.cs214.hw4.GameSystem;
import edu.cmu.cs.cs214.hw4.Player;
import edu.cmu.cs.cs214.hw4.Square;

public class UnknowSpecialTile extends SpecialTile{
	private Square square;
	private static final int PRICE = 30;
	private static final String NAME = "Unknown";
	
	public UnknowSpecialTile(Square square, Player player) {
		super(square, player);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return square.getName()+NAME;
	}
	
}
