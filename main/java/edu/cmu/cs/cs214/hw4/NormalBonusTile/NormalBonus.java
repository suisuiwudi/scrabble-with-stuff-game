package edu.cmu.cs.cs214.hw4.NormalBonusTile;

import edu.cmu.cs.cs214.hw4.LetterTile;
import edu.cmu.cs.cs214.hw4.Square;
import edu.cmu.cs.cs214.hw4.Word;

public interface NormalBonus{
	
	public void changeWordValue(Word word, LetterTile letterTile);
	public abstract String getName();
}
