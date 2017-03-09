package edu.cmu.cs.cs214.hw4.NormalBonusTile;


import edu.cmu.cs.cs214.hw4.LetterTile;
import edu.cmu.cs.cs214.hw4.Square;
import edu.cmu.cs.cs214.hw4.Word;


public class TripleWord extends EmptyNormalBonus {
	private final static String TRIPLE_WORD= "3WS";
	public TripleWord(){
		super();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return TRIPLE_WORD;
	}
	@Override
	public void changeWordValue(Word word, LetterTile letterTile) {
		// TODO Auto-generated method stub
		
	}
	
}
