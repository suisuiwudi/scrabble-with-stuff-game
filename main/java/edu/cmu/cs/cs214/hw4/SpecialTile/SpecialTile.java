package edu.cmu.cs.cs214.hw4.SpecialTile;

import edu.cmu.cs.cs214.hw4.GameSystem;
import edu.cmu.cs.cs214.hw4.Player;
import edu.cmu.cs.cs214.hw4.Square;

public interface SpecialTile {
	public void setOwner(Player player);
	public abstract String getName();
	public abstract int getPrice();
	public Player getOwner();
	public abstract void activeSpecialEffect(GameSystem gameSystem, Square square);
}
