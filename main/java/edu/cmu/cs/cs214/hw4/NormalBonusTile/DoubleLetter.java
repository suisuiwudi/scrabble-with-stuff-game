package edu.cmu.cs.cs214.hw4.NormalBonusTile;


import edu.cmu.cs.cs214.hw4.LetterTile;
import edu.cmu.cs.cs214.hw4.Word;


public class DoubleLetter extends EmptyNormalBonus {
	private final static String DOUBLE_LETTER = "2LS";
	public DoubleLetter(){
		super();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return DOUBLE_LETTER;
	}
	@Override
	public void changeWordValue(Word word, LetterTile letterTile) {
		// TODO Auto-generated method stub
		
	}
	
}
