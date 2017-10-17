/*
 * The virtual square is passed to Move as a parameter to denote the 
 * position of letter tile.
 * A Square can only hold one letter tile at a time but can
 * hold many SP tiles.
 */
package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;

import edu.cmu.cs.cs214.hw4.core.NormalBonusTile.NormalBonus;
import edu.cmu.cs.cs214.hw4.core.NormalBonusTile.OneWord;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.SpecialTile;

/**
 * The Class Square.
 */
public class Square {

	/** The x. */
	private int x;

	/** The y. */
	private int y;

	/** The special tiles. */
	private ArrayList<SpecialTile> specialTiles;

	/** The normal bonus. */
	private NormalBonus normalBonus;

	/** The letter tile. */
	private LetterTile letterTile;

	/**
	 * Instantiates a new square.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public Square(int x, int y) {
		this.x = x;
		this.y = y;
		specialTiles = new ArrayList<>();
		letterTile = null;
		normalBonus = new OneWord();
	}

	/**
	 * Sets the letter tile.
	 *
	 * @param letterTile
	 *            the new letter tile
	 */
	public void setLetterTile(LetterTile letterTile) {
//		LetterTile tmp =new LetterTile(letterTile.getLetter(),letterTile.getValue());
//		this.letterTile = tmp;
		this.letterTile = letterTile;
	}

	/**
	 * Unset letter tile.
	 */
	public void unsetLetterTile() {
		this.letterTile = null;
	}
	
	/**
	 * Unset special tile.
	 */
	public void unsetSpecialTile() {
//		this.specialTiles = null;
		this.specialTiles = new ArrayList<SpecialTile>();
	}

	/**
	 * Sets the normal bonus.
	 *
	 * @param normalBonus
	 *            the new normal bonus
	 */
	public void setNormalBonus(NormalBonus normalBonus) {
		this.normalBonus = normalBonus;
	}

	/**
	 * Sets the special tile.
	 *
	 * @param specialTile
	 *            the new special tile
	 */
	public void setSpecialTile(SpecialTile specialTile) {
		specialTiles.add(specialTile);
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Gets the special tile.
	 *
	 * @return the special tile
	 */
	public ArrayList<SpecialTile> getSpecialTile() {
		return specialTiles;
	}

	/**
	 * Checks for special tile.
	 *
	 * @return true, if successful
	 */
	public boolean hasSpecialTile() {
		return specialTiles.size() > 0;
	}

	/**
	 * Gets the normal bonus.
	 *
	 * @return the normal bonus
	 */
	public NormalBonus getNormalBonus() {
		return normalBonus;
	}

	/**
	 * Checks for normal bonus.
	 *
	 * @return true, if successful
	 */
	public boolean hasNormalBonus() {
		return normalBonus != null;
	}

	/**
	 * Gets the letter tile.
	 *
	 * @return the letter tile
	 */
	public LetterTile getLetterTile() {
		return letterTile;
	}

	/**
	 * Checks for letter tile.
	 *
	 * @return true, if successful
	 */
	public boolean hasLetterTile() {
		return letterTile != null;
//		return letterTile;
	}

}
