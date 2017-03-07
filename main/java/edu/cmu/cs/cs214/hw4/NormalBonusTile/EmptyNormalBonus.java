package edu.cmu.cs.cs214.hw4.NormalBonusTile;

import edu.cmu.cs.cs214.hw4.LetterTile;
import edu.cmu.cs.cs214.hw4.Square;
import edu.cmu.cs.cs214.hw4.Word;

public abstract class EmptyNormalBonus extends Square {

	public abstract boolean hasNormalTile();
	public abstract String getNormalTileType();
}
