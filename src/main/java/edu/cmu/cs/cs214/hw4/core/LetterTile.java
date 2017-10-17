
package edu.cmu.cs.cs214.hw4.core;

/**
 * The Class LetterTile.
 */

public class LetterTile {

	/** The letter. */
	private char letter;

	/** The value. */
	private int value;

	/**
	 * Instantiates a new letter tile. Use ASCII 65-91 to represent A-Z.
	 *
	 * @param letter
	 *            the letter
	 * @param value
	 *            the value
	 */
	public LetterTile(char letter, int value) {
		this.letter = letter;
		this.value = value;
	}

	/**
	 * Gets the letter.
	 *
	 * @return the letter
	 */
	public char getLetter() {
		return letter;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
}
