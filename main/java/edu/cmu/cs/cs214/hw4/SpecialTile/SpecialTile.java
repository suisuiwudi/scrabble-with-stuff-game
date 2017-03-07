package edu.cmu.cs.cs214.hw4.SpecialTile;

import edu.cmu.cs.cs214.hw4.GameSystem;
import edu.cmu.cs.cs214.hw4.Player;
import edu.cmu.cs.cs214.hw4.Square;

public abstract class SpecialTile extends Square {
	private Player owner;
	public void setOwner(Player player){
		this.owner = player;
	}
	public abstract String getSpecialTileName();
	public abstract int getPrice();
	public Player getOwner(){
		return owner;
	}
	public abstract void activeSpecialEffect(GameSystem gameSystem, Square square);
}
