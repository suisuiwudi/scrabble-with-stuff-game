package edu.cmu.cs.cs214.hw4.NormalBonusTile;


import edu.cmu.cs.cs214.hw4.Square;


public class DoubleLetter extends NormalBonus {
	private final static String DOUBLE_LETTER = "2LS";
	private Square square;
	public DoubleLetter(Square square){
		this.square = square;
	}
	@Override
	public boolean hasNormalTile() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String getNormalTileName() {
		// TODO Auto-generated method stub
		return DOUBLE_LETTER;
	}
	
}
