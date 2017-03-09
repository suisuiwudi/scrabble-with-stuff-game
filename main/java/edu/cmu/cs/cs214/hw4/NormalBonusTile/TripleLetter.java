package edu.cmu.cs.cs214.hw4.NormalBonusTile;


import edu.cmu.cs.cs214.hw4.LetterTile;
import edu.cmu.cs.cs214.hw4.Word;


public class TripleLetter extends EmptyNormalBonus {
	private final static String TRIPLE_LETTER = "3LS";

	public TripleLetter(){
		super();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return TRIPLE_LETTER;
	}
	@Override
	public void changeWordValue(Word word, LetterTile letterTile) {
		// TODO Auto-generated method stub
		
	}
	
}
