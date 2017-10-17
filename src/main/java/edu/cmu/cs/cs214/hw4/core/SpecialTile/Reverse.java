package edu.cmu.cs.cs214.hw4.core.SpecialTile;

import edu.cmu.cs.cs214.hw4.core.GameSystem;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Square;

/**
 * The Class Reverse.
 */
public class Reverse implements ActiveSpecialEffect {
	
	/** The Constant PRICE. */
	private static final int PRICE = 0;
	
	/** The Constant NAME. */
	private static final String NAME = "Reverse";
	
	/* (non-Javadoc)
	 * @see edu.cmu.cs.cs214.hw4.core.SpecialTile.ActiveSpecialEffect#activeSpecialEffect(edu.cmu.cs.cs214.hw4.core.GameSystem, edu.cmu.cs.cs214.hw4.core.Square, edu.cmu.cs.cs214.hw4.core.Player)
	 */
	public void activeSpecialEffect(GameSystem gameSystem, Square square, Player player) {
		gameSystem.addReverse();
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
