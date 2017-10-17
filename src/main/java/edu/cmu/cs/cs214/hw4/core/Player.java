package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;

import edu.cmu.cs.cs214.hw4.core.SpecialTile.SpecialTile;

/**
 * The Class Player.
 */
public class Player {

	/** The score. */
	private int score;

	/** The letter tiles. */
	private ArrayList<LetterTile> letterTiles;

	/** The special tiles. */
	private ArrayList<SpecialTile> specialTiles;

	/** The bag. */
	private LetterTileBag bag;

	/** The name. */
	private String name;

	/** The skip. */
	private boolean skip;

	/** The id. */
	private int id;

	/**
	 * Instantiates a new player.
	 *
	 * @param name
	 *            the name
	 */
	public Player(String name) {
		this.name = name;
		letterTiles = new ArrayList<>();
		specialTiles = new ArrayList<>();
		bag = new LetterTileBag();
		score = 0;
		skip = false;
	}

	/**
	 * Sets the skip.
	 */
	public void setSkip() {
		skip = true;
	}

	/**
	 * Unset skip.
	 */
	public void unsetSkip() {
		skip = false;
	}

	/**
	 * Gets the skip.
	 *
	 * @return the skip
	 */
	public boolean getSkip() {
		return skip;
	}

	/**
	 * Gets the letters.
	 *
	 * @return the letters
	 */
	public ArrayList<LetterTile> getLetters() {
		return letterTiles;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score
	 *            the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Delete letter tile.
	 *
	 * @param letterTiles
	 *            the letter tiles
	 */
	public void deleteLetterTile(ArrayList<LetterTile> letterTiles) {
		ArrayList<LetterTile> tmp = new ArrayList<>();

		for (LetterTile tileGot : this.letterTiles) {
			boolean deleteFlag = false;
			for (LetterTile deleteTile : letterTiles) {
				if (deleteTile.getLetter() == tileGot.getLetter())
					deleteFlag = true;
			}
			if (!deleteFlag)
				tmp.add(tileGot);
		}
		this.letterTiles = tmp;

	}

	/**
	 * Adds the letter tiles.
	 *
	 * @param letterTiles
	 *            the letter tiles
	 */
	public void addLetterTiles(ArrayList<LetterTile> letterTiles) {
		this.letterTiles.addAll(letterTiles);
	}

	/**
	 * Buy special tile.
	 *
	 * @param s
	 *            the s
	 * @return true, if successful
	 */
	public boolean buySpecialTile(SpecialTile s) {
		if (score >= s.getPrice()) {
			score -= s.getPrice();
			specialTiles.add(s);
			return true;
		}
		return false;
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
	 * Checks for money.
	 *
	 * @param s
	 *            the s
	 * @return true, if successful
	 */
	public boolean hasMoney(SpecialTile s) {
		if (this.getScore() > s.getPrice())
			return true;
		else
			return false;
	}

	/**
	 * Replenish.
	 *
	 * @param max
	 *            the max
	 * @return true, if successful
	 */
	public boolean replenish(int max) {
		if (max > bag.getBagNum()){
			addLetterTiles(bag.takeBag(bag.getBagNum()));
			System.out.println("Bag is not enogh");
		}
//			return false;
		int num = letterTiles.size();
		if (num < max){
			addLetterTiles(bag.takeBag(max - num));
			System.out.println("delta NUM is :"+(max-num));
		}
		return true;
	}

	public void resetLetterTileRack() {
		bag.giveBag(letterTiles);
//		deleteLetterTile(letterTiles);
		letterTiles = new ArrayList<>();
		replenish(7);
		
	}
	
	public int getRemainingLetterTiles(){
		return bag.getBagNum();
	}

}
