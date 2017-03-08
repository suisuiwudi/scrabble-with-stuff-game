package edu.cmu.cs.cs214.hw4.SpecialTile;

import edu.cmu.cs.cs214.hw4.GameSystem;
import edu.cmu.cs.cs214.hw4.Player;
import edu.cmu.cs.cs214.hw4.Square;

public class NegativeSpecialTile extends SpecialTile{

	private static final int PRICE = 30;
	private static final String NAME = "Negative";
	public NegativeSpecialTile(Square square, Player player) {
		super(square, player);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getSquare().getName()+" "+super.getOwner()+":"+NAME;
	}

}
