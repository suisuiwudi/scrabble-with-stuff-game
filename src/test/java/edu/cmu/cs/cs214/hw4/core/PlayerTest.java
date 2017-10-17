package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.cmu.cs.cs214.hw4.core.SpecialTile.SpecialTile;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerTest.
 */
/*
 * This test may take a while to give the output.Please be patient.
 *  
 */
public class PlayerTest {
	
	/** The game. */
	GameSystem game = new GameSystem();
	
	/** The Me. */
	Player Me = new Player("Me");
	
	/** The l. */
	ArrayList<LetterTile> l = new ArrayList<LetterTile>();
	

	/**
	 * Test player.
	 */
	@Test
	public void testPlayer() {
		assertEquals(0,Me.getScore());
	}


	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() {
		assertEquals("Me",Me.getName());
	}


	/**
	 * Test set score.
	 */
	@Test
	public void testSetScore() {
		Me.setScore(12);
		assertEquals(12,Me.getScore());
	}


	/**
	 * Test add letter tiles.
	 */
	@Test
	public void testAddLetterTiles() {
		l.add(new LetterTile('A',1));
		Me.addLetterTiles(l);
		assertEquals(l,Me.getLetters());
		Me.deleteLetterTile(l);
		assertEquals(0,Me.getLetters().size());
	}

}
