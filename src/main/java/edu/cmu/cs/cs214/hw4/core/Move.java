/*
 * The Move is a move made by the player and I allow the player
 * to buy at most one SP Tile.
 */
package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import edu.cmu.cs.cs214.hw4.core.SpecialTile.SpecialTile;

/**
 * The Class Move. NOTICE:the letterTileList is a list of Squares,not
 * LetterTiles.
 */
public class Move {

	/** The Constant BOARD_SIZE. */
	private static final int BOARD_SIZE = 15;

	/** The letter tiles list. */
	private ArrayList<Square> letterTilesList;

	/** The word. */
	private Word word;

	/** The player. */
	private Player player;

	/** The special tile. */
	private SpecialTile specialTile;

	/** The special tile X. */
	private int specialTileX;

	/** The special tile Y. */
	private int specialTileY;

	/**
	 * Instantiates a new move.
	 *
	 * @param letterTilesList
	 *            the SQUARE list
	 * @param player
	 *            the player
	 */
	public Move(ArrayList<Square> letterTilesList, Player player) {
		this.letterTilesList = letterTilesList;
		this.specialTile = null;
		this.player = player;
	}

	/**
	 * Sets the special tile.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param specialTile
	 *            the special tile
	 */
	public void setSpecialTile(int x, int y, SpecialTile specialTile) {
		specialTileX = x;
		specialTileY = y;
		this.specialTile = specialTile;
	}

	/**
	 * Sets the letter tiles.
	 *
	 * @param letterTilesList
	 *            the new letter tiles
	 */
	public void setLetterTiles(ArrayList<Square> letterTilesList) {
		this.letterTilesList = letterTilesList;
	}

	/**
	 * Checks if is one line.(i.e. If the player plays a diagonal shape)
	 *
	 * @return true, if is one line
	 */
	public boolean isOneLine() {
		int x = -1;
		int y = -1;
		for (Square tile : letterTilesList) {
			if (x == -1) {
				x = tile.getX();
				y = tile.getY();
			} else {
				boolean flagInOneLine = false;
				if (x != tile.getX())
					flagInOneLine = !flagInOneLine;
				if (y != tile.getY())
					flagInOneLine = !flagInOneLine;
				if (!flagInOneLine)
					return false;
			}
		}
		return true;
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Gets the letter tiles.
	 *
	 * @return the letter tiles
	 */
	public ArrayList<Square> getLetterTiles() {
		return letterTilesList;
	}

	/**
	 * Checks for special tile.
	 *
	 * @return true, if successful
	 */
	public boolean hasSpecialTile() {
		return specialTile != null;
	}

	/**
	 * Gets the special tile.
	 *
	 * @return the special tile
	 */
	public SpecialTile getSpecialTile() {
		return specialTile;
	}

	/**
	 * Gets the speical tile X.
	 *
	 * @return the speical tile X
	 */
	public int getSpeicalTileX() {
		return specialTileX;
	}

	/**
	 * Gets the special tile Y.
	 *
	 * @return the special tile Y
	 */
	public int getSpecialTileY() {
		return specialTileY;
	}
}
