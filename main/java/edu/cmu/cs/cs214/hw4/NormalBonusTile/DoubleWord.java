package edu.cmu.cs.cs214.hw4.NormalBonusTile;


import edu.cmu.cs.cs214.hw4.LetterTile;
import edu.cmu.cs.cs214.hw4.Square;
import edu.cmu.cs.cs214.hw4.Word;


public class DoubleWord extends EmptyNormalBonus {
	private final static String DOUBLE_WORD = "2WS";
	public DoubleWord(){
		super();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return DOUBLE_WORD;
	}
	@Override
	public void changeWordValue(Word word, LetterTile letterTile) {
		// TODO Auto-generated method stub
		
	}
	
}
