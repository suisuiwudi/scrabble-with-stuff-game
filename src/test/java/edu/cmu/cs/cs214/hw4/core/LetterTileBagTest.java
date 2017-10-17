package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class LetterTileBagTest.
 */
public class LetterTileBagTest {

	/** The bag. */
	LetterTileBag bag = new LetterTileBag();
	
	/** The test. */
	List<LetterTile> test = new ArrayList<LetterTile>();
	
	/**
	 * Test letter tile bag.
	 */
	@Test
	public void testLetterTileBag() {
		assertEquals(98,bag.getBag().size());
		for(LetterTile l: bag.getBag())
			System.out.println(l.getLetter());
		System.out.println(bag.getBag());
	}

	/**
	 * Test give bag.
	 */
	@Test
	public void testGiveBag() {
	}

	/**
	 * Test take bag.
	 */
	@Test
	public void testTakeBag() {
		test = bag.takeBag(3);
		assertEquals(3,test.size());
	}

}
