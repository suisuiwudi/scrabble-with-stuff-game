package edu.cmu.cs.cs214.hw4.core.SpecialTile;

import edu.cmu.cs.cs214.hw4.core.GameSystem;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Square;


/**
 * The Class SpecialTile.
 */
public class SpecialTile {
	
	/** The owner. */
	private Player owner;
	
	/** The active special effect. */
	private ActiveSpecialEffect activeSpecialEffect;
	
	/**
	 * Instantiates a new special tile.
	 *
	 * @param activeSpecialEffect the active special effect
	 * @param player the player
	 */
	public SpecialTile(ActiveSpecialEffect activeSpecialEffect, Player player){
		this.activeSpecialEffect = activeSpecialEffect;
		this.owner = player;
	}
	
	/**
	 * Sets the owner.
	 *
	 * @param player the new owner
	 */
	public void setOwner(Player player){
		this.owner = player;
	}
	
	/**
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	public Player getOwner(){
		return owner;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public int getPrice(){
		return activeSpecialEffect.getPrice();
	}
	
	/**
	 * Active special effect.
	 *
	 * @param gameSystem the game system
	 * @param square the square
	 * @param player the player
	 */
	public void activeSpecialEffect(GameSystem gameSystem, Square square, Player player){
		activeSpecialEffect.activeSpecialEffect(gameSystem, square, player);
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return activeSpecialEffect.getName();
	}

}
