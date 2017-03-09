package edu.cmu.cs.cs214.hw4.NormalBonusTile;


import edu.cmu.cs.cs214.hw4.LetterTile;
import edu.cmu.cs.cs214.hw4.Word;


public class OneWord extends EmptyNormalBonus {
	private final static String ONE_WORD = " . ";

	public OneWord(){
		super();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return ONE_WORD;
	}
	@Override
	public void changeWordValue(Word word, LetterTile letterTile) {
		// TODO Auto-generated method stub
		
	}
	
}
