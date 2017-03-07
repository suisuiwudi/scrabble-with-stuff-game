package edu.cmu.cs.cs214.hw4.NormalBonusTile;


import edu.cmu.cs.cs214.hw4.Square;


public class DoubleWord extends EmptyNormalBonus {
	private final static String DOUBLE_WORD = "2LW";
	private Square square;
	public DoubleWord(Square square){
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
		return DOUBLE_WORD;
	}
	
}
