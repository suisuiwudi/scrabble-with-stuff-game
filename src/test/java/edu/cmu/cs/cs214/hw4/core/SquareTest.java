package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class SquareTest.
 */
public class SquareTest {
	
	/** The square. */
	Square square = new Square(7, 7);
	


	/**
	 * Test set letter tile.
	 */
	@Test
	public void testSetLetterTile() {
		square.setLetterTile(new LetterTile('z', 10));
		assertEquals('z',square.getLetterTile().getLetter());
		assertEquals(7,square.getX());
	}


	

	/**
	 * Test get X.
	 */
	@Test
	public void testGetX() {
		assertEquals(7,square.getX());
	}


}
