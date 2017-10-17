package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Class LetterTileBag.
 */
public class LetterTileBag {

	/** The tiles. */
	private ArrayList<LetterTile> tiles;

	/** The cnt. */
	private int[] cnt = { 9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1 };

	/** The score. */
	private int[] score = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

	/**
	 * Instantiates a new letter tile bag. Use ASCII 65-91 to represent A-Z.
	 */
	public LetterTileBag() {
		tiles = new ArrayList<LetterTile>();
		for (char i = 'a'; i <= 'z'; i++) {
			for (int j = 0; j < cnt[i - 'a']; j++) {
				tiles.add(new LetterTile(i, score[i - 'a']));
			}

		}
	}

	/**
	 * Give tiles to bag what the player has in his hand.
	 *
	 * @param inBag
	 *            the in bag
	 */
	public void giveBag(ArrayList<LetterTile> inBag) {
		tiles.addAll(inBag);
	}

	/**
	 * Take certain numbers of tiles from bag to the player's hand.
	 *
	 * @param num
	 *            the certain number
	 * @return the array list
	 */
	public ArrayList<LetterTile> takeBag(int num) {
		Random rand = new Random();
		ArrayList<LetterTile> outBag = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			int rnd = rand.nextInt(tiles.size());
			outBag.add(tiles.get(rnd));
			tiles.remove(rnd);

		}
		return outBag;
	}

	/**
	 * Gets the bag num.
	 *
	 * @return the bag num
	 */
	public int getBagNum() {
		return tiles.size();
	}

	/**
	 * Gets the bag.
	 *
	 * @return the bag
	 */
	public ArrayList<LetterTile> getBag() {
		return tiles;
	}

}
