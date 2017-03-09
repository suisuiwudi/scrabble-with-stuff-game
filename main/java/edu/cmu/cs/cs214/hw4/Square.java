package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;

import edu.cmu.cs.cs214.hw4.NormalBonusTile.NormalBonus;
import edu.cmu.cs.cs214.hw4.NormalBonusTile.OneWord;
import edu.cmu.cs.cs214.hw4.SpecialTile.SpecialTile;

public class Square {
	private int x;
	private int y;
	private ArrayList<SpecialTile> specialTiles;
	private NormalBonus normalBonus;
	private LetterTile letterTile;
	public Square(int x, int y){
		this.x = x;
		this.y = y;
		specialTiles = new ArrayList<>();
		letterTile = null;
		normalBonus = new OneWord();
	}

	public void setLetterTile(LetterTile letterTile){
		this.letterTile = letterTile;
	}
	public void unsetLetterTile(){
		this.letterTile = null;
	}
	public void setNormalBonus(NormalBonus normalBonus){
		this.normalBonus = normalBonus;
	}
	public void setSpecialTile(SpecialTile specialTile){
		specialTiles.add(specialTile);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public ArrayList<SpecialTile> getSpecialTile(){
		return specialTiles;
	}
	public boolean hasSpecialTile(){
		return specialTiles.size() > 0;
	}
	public NormalBonus getNormalBonus(){
		return normalBonus;
	}
	public boolean hasNormalBonus(){
		return normalBonus != null;
	}
	public LetterTile getLetterTile(){
		return letterTile;
	}
	public boolean hasLetterTile(){
		return letterTile != null;
	}
	
}
