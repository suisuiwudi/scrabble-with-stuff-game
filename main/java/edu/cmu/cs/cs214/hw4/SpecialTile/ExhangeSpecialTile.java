package edu.cmu.cs.cs214.hw4.SpecialTile;

import edu.cmu.cs.cs214.hw4.GameSystem;
import edu.cmu.cs.cs214.hw4.Square;

public class ExhangeSpecialTile extends SpecialTile{
	private static final int PRICE = 30;
	private static final String NAME = "Exchange";
	public ExhangeSpecialTile(){
		super();
	}
	@Override
	public String getSpecialTileName() {
		// TODO Auto-generated method stub
		return NAME;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return PRICE;
	}

	@Override
	public void activeSpecialEffect(GameSystem gameSystem, Square square) {
		// TODO Auto-generated method stub
		gameSystem.setExchange(super.getOwner());
	}
	
}
