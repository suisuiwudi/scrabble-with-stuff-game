package edu.cmu.cs.cs214.hw4.NormalBonusTile;

import edu.cmu.cs.cs214.hw4.LetterTile;
import edu.cmu.cs.cs214.hw4.Word;

public abstract class EmptyNormalBonus implements NormalBonus{
	public EmptyNormalBonus(){
	}
	public abstract String getName();
	public abstract void changeWordValue(Word word, LetterTile letterTile);

}
