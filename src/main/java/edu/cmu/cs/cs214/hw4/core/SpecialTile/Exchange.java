package edu.cmu.cs.cs214.hw4.core.SpecialTile;

import edu.cmu.cs.cs214.hw4.core.GameSystem;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Square;

/**
 * The Class Exchange.
 */
public class Exchange implements ActiveSpecialEffect {
	
	/** The Constant PRICE. */
	private static final int PRICE = 0;
	
	/** The Constant NAME. */
	private static final String NAME = "Exchange";
	
	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.SpecialTile.ActiveSpecialEffect#activeSpecialEffect(edu.cmu.cs.cs214.hw4.core.GameSystem, edu.cmu.cs.cs214.hw4.core.Square, edu.cmu.cs.cs214.hw4.core.Player)
	 */
	public void activeSpecialEffect(GameSystem gameSystem, Square square, Player player) {
		gameSystem.addExchange(player);
	}
	
	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.SpecialTile.ActiveSpecialEffect#getName()
	 */
	public String getName(){
		return NAME;
	}
	
	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.SpecialTile.ActiveSpecialEffect#getPrice()
	 */
	public int getPrice(){
		return PRICE;
	}

}
