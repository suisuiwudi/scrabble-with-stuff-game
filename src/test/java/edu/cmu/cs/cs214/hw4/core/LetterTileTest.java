package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class LetterTileTest.
 */
public class LetterTileTest {
	
	/** The a. */
	LetterTile A = new LetterTile('a',9);


	/**
	 * Test get letter.
	 */
	@Test
	public void testGetLetter() {
		assertEquals('a',A.getLetter());
	}


}
