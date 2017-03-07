package edu.cmu.cs.cs214.hw4.NormalBonusTile;


import edu.cmu.cs.cs214.hw4.Square;


public class TripleWord extends EmptyNormalBonus {
	private final static String TRIPLE_WORD= "3TW";
	private Square square;
	public TripleWord(Square square){
		this.square = square;
	}
	@Override
	public boolean hasNormalTile() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String getNormalTileType() {
		// TODO Auto-generated method stub
		return TRIPLE_WORD;
	}
	
}
