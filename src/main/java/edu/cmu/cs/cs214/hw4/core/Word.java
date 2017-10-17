package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;

/**
 * The Class Word.
 */
public class Word {

	/** The value. */
	private int value;

	/** The x. */
	private int x;

	/** The y. */
	private int y;

	/** The direction. */
	private int direction;

	/** The length. */
	private int length;

	/** The word bonus. */
	private int wordBonus;

	/** The word. */
	private String word;

	/**
	 * Instantiates a new word.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param direction
	 *            the direction
	 * @param word
	 *            the word
	 * @param value
	 *            the value
	 */
	public Word(int x, int y, int direction, String word, int value) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.word = word;
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Adds the value.
	 *
	 * @param tileValue
	 *            the tile value
	 */
	public void addValue(int tileValue) {

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
	 * Gets the string.
	 *
	 * @return the string
	 */
	public String getString() {
		return word;
	}

}
