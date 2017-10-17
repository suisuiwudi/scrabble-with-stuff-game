package edu.cmu.cs.cs214.hw4.core.SpecialTile;

import edu.cmu.cs.cs214.hw4.core.GameSystem;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Square;

/**
 * The Interface ActiveSpecialEffect.
 */
public interface ActiveSpecialEffect {
	
	/**
	 * Active special effect.
	 *
	 * @param gameSystem the game system
	 * @param square the square
	 * @param player the player
	 */
	public void activeSpecialEffect(GameSystem gameSystem, Square square, Player player);
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice();

}
