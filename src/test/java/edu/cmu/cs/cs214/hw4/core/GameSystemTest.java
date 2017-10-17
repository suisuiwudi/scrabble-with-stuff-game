package edu.cmu.cs.cs214.hw4.core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.cmu.cs.cs214.hw4.core.SpecialTile.Boom;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.Exchange;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.SpecialTile;

/**
 * The Class GameSystemTest.
 */
public class GameSystemTest {
	
	
	GameSystem game = new GameSystem();
	Player Me = new Player("Me");
	Player Can = new Player("Can");
	
	

	
	/**
	 * Test game system.
	 */
	@Test
	public void testGameSystem() {
	}

	/**
	 * Test add player.
	 */
	@Test
	public void testAddPlayer() {
		game.addPlayer(Me);
		game.addPlayer(Can);
		assertEquals(2,game.getController().getPlayers().size());
	}

	/**
	 * Test the main function of the game system.
	 */
	@Test
	public void testMainFunctionOfGameSystem() {
			Me.replenish(90);
			Can.replenish(90);
			Can.setScore(100);
			Can.buySpecialTile(new SpecialTile(new Boom(), Can));
			game.addPlayer(Me);
			game.addPlayer(Can);
			ArrayList<Square> letterTiles = new ArrayList<>();
			Square square = new Square(7, 7);
			square.setLetterTile(new LetterTile('z', 10));// creating z
			letterTiles.add(square);
			square = new Square(7, 8);
			square.setLetterTile(new LetterTile('o', 1));// can be replaced by enum
			letterTiles.add(square);
			square = new Square(7, 9);
			square.setLetterTile(new LetterTile('o', 1));
			letterTiles.add(square);
			Move move = new Move(letterTiles, game.getCurrentPlayer());
			System.out.println(game.checkMatchBoard(move));
			if (game.checkMatchBoard(move))
				game.applyMove(move);
			game.showBoard();
			game.replenish();
			game.nextPlayerReset();

			letterTiles = new ArrayList<>();
			square = new Square(8, 8);
			square.setLetterTile(new LetterTile('z', 10));
			letterTiles.add(square);
			square = new Square(8, 9);
			square.setLetterTile(new LetterTile('o', 1));
			letterTiles.add(square);
			square = new Square(8, 10);
			square.setLetterTile(new LetterTile('o', 1));
			letterTiles.add(square);
			move = new Move(letterTiles, game.getCurrentPlayer());
			move.setSpecialTile(10, 10, new SpecialTile(new Boom(), game.getCurrentPlayer()));

			if (game.checkMatchBoard(move))
				game.applyMove(move);
			game.showBoard();
			game.replenish();
			game.nextPlayerReset();

			letterTiles = new ArrayList<>();
			square = new Square(9, 10);
			square.setLetterTile(new LetterTile('d', 2));
			letterTiles.add(square);
			square = new Square(10, 10);
			square.setLetterTile(new LetterTile('d', 2));
			letterTiles.add(square);

			assertNull(game.getBoard().getSquares()[9][10].getLetterTile());
			move = new Move(letterTiles, game.getCurrentPlayer());
			if (game.checkMatchBoard(move))
				game.applyMove(move);
			game.replenish();
			game.showBoard();
	}

	/**
	 * Test apply move.
	 */
	@Test
	public void testApplyMove() {
		Me.replenish(90);
		Can.replenish(90);
		Can.setScore(100);
		Can.buySpecialTile(new SpecialTile(new Boom(), Can));
		game.addPlayer(Me);
		game.addPlayer(Can);
		ArrayList<Square> letterTiles = new ArrayList<>();
		Square square = new Square(7, 7);
		square.setLetterTile(new LetterTile('z', 10));// creating z
		letterTiles.add(square);
		square = new Square(7, 8);
		square.setLetterTile(new LetterTile('o', 1));// can be replaced by enum
		letterTiles.add(square);
		square = new Square(7, 9);
		square.setLetterTile(new LetterTile('o', 1));
		letterTiles.add(square);
		Move move = new Move(letterTiles, game.getCurrentPlayer());
		System.out.println(game.checkMatchBoard(move));
		if (game.checkMatchBoard(move))
			game.applyMove(move);
		assertEquals('o',game.getBoard().getSquares()[7][8].getLetterTile().getLetter());
		
	}

	/**
	 * Test next player reset.
	 */
	@Test
	public void testNextPlayerReset() {
		Me.replenish(90);
		Can.replenish(90);
		Can.setScore(100);
		Can.buySpecialTile(new SpecialTile(new Boom(), Can));
		game.addPlayer(Me);
		game.addPlayer(Can);
		ArrayList<Square> letterTiles = new ArrayList<>();
		Square square = new Square(7, 7);
		square.setLetterTile(new LetterTile('z', 10));// creating z
		letterTiles.add(square);
		square = new Square(7, 8);
		square.setLetterTile(new LetterTile('o', 1));// can be replaced by enum
		letterTiles.add(square);
		square = new Square(7, 9);
		square.setLetterTile(new LetterTile('o', 1));
		letterTiles.add(square);
		Move move = new Move(letterTiles, game.getCurrentPlayer());
		System.out.println(game.checkMatchBoard(move));
		if (game.checkMatchBoard(move))
			game.applyMove(move);
		game.showBoard();
		game.replenish();
		game.nextPlayerReset();
		assertEquals(Can,game.getController().currentPlayer());
	}



	/**
	 * Test add boom.
	 */
	@Test
	public void testAddBoom() {
		Me.replenish(90);
		Can.replenish(90);
		Can.setScore(100);
		Can.buySpecialTile(new SpecialTile(new Boom(), Can));
		game.addPlayer(Me);
		game.addPlayer(Can);
		ArrayList<Square> letterTiles = new ArrayList<>();
		Square square = new Square(7, 7);
		square.setLetterTile(new LetterTile('z', 10));// creating z
		letterTiles.add(square);
		square = new Square(7, 8);
		square.setLetterTile(new LetterTile('o', 1));// can be replaced by enum
		letterTiles.add(square);
		square = new Square(7, 9);
		square.setLetterTile(new LetterTile('o', 1));
		letterTiles.add(square);
		Move move = new Move(letterTiles, game.getCurrentPlayer());
		System.out.println(game.checkMatchBoard(move));
		if (game.checkMatchBoard(move))
			game.applyMove(move);
		game.showBoard();
		game.replenish();
		game.nextPlayerReset();

		letterTiles = new ArrayList<>();
		square = new Square(8, 8);
		square.setLetterTile(new LetterTile('z', 10));
		letterTiles.add(square);
		square = new Square(8, 9);
		square.setLetterTile(new LetterTile('o', 1));
		letterTiles.add(square);
		square = new Square(8, 10);
		square.setLetterTile(new LetterTile('o', 1));
		letterTiles.add(square);
		move = new Move(letterTiles, game.getCurrentPlayer());
		move.setSpecialTile(10, 10, new SpecialTile(new Boom(), game.getCurrentPlayer()));

		if (game.checkMatchBoard(move))
			game.applyMove(move);
		game.showBoard();
		game.replenish();
		game.nextPlayerReset();

		letterTiles = new ArrayList<>();
		square = new Square(9, 10);
		square.setLetterTile(new LetterTile('d', 2));
		letterTiles.add(square);
		square = new Square(10, 10);
		square.setLetterTile(new LetterTile('d', 2));
		letterTiles.add(square);

		assertNull(game.getBoard().getSquares()[9][10].getLetterTile());
	}


	

	

}
