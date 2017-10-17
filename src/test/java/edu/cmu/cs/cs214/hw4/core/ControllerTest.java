package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class ControllerTest.
 */
public class ControllerTest {

	
	
	/**
	 * Test.
	 */
	@Test
	public void test() {
		GameSystem game = new GameSystem();
		Player Me = new Player("Me");
		System.out.println(Me.getName());
		Player Can = new Player("Can");
		game.addPlayer(Me);
		game.addPlayer(Can);
		assertEquals(Me,game.getController().currentPlayer());
	}

}
