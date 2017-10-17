/*The game system
 * 
 */
package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;
import java.util.Arrays;

import edu.cmu.cs.cs214.hw4.core.SpecialTile.Boom;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.SpecialTile;
import edu.cmu.cs.cs214.hw4.gui.PromptWindow;

/**
 * The Class GameSystem.
 */
public class GameSystem {

	/** The Constant PLAYER_LETTER_NUMS. */
	private static final int PLAYER_LETTER_NUMS = 7;

	/** The Constant PATH. */
	private static final String PATH = "src/main/resources/words.txt";

	/** The dict. */
	private Dictionary dict;

	/** The first move. */
	private boolean firstMove;
	
//	private boolean challengeFlag;

	/** The board. */
	private Board board;

	/** The controller. */
	private Controller controller;

	/** The boom list. */
	private ArrayList<Square> boomList;

	/** The exchange list. */
	private ArrayList<Player> exchangeList;

	/** The negative. */
	private int negative;

	/** The someone challenge. */
	private Player someoneChallenge;

	/**
	 * Instantiates a new game system.
	 */
	public GameSystem() {
		dict = new Dictionary(PATH);
		firstMove = true;
		board = new Board();
//		board.setDict(dict);
		controller = new Controller();
		boomList = new ArrayList<>();
		exchangeList = new ArrayList<>();
		negative = 1;
//		challengeFlag = false;

	}

	/**
	 * Adds the player.
	 *
	 * @param player
	 *            the player
	 */
	public void addPlayer(Player player) {
		controller.addPlayer(player);
	}

	/**
	 * Check match board. First to ensure the placement are all in one one line
	 * and do not in a diagonal position. Then if it is the first move we should
	 * check whether cover the star. Last if it was not the first move, we
	 * should check whether the move is placed near the existing letter tiles.
	 *
	 * @param move
	 *            the move
	 * @return true, if successful
	 */
	public boolean checkMatchBoard(Move move) {
		if (!board.checkInOneLine(move)) {
			PromptWindow pw1 = new PromptWindow("is not in one line");
			return false;
		}

		if (!hasLetterTile(move)) {
			PromptWindow pw2 = new PromptWindow("don't have this letter");
			return false;
		}

		if (!hasSpecialTile(move)) {
			PromptWindow pw3 = new PromptWindow("don't have this SP");
			return false;
		}

		if (firstMove) {
			PromptWindow pw4 = new PromptWindow("this is the first move");
			if (!board.checkStar(move)) {
				PromptWindow pw5 = new PromptWindow("first move doesn't cover star");
				return false;
			}
		} else {
			if (!board.checkJoint(move)) {
				PromptWindow pw6 = new PromptWindow("doesn't join others");
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks for letter tile.
	 *
	 * @param move
	 *            the move
	 * @return true, if successful
	 */
	private boolean hasLetterTile(Move move) {
		System.out.println(move.getLetterTiles().size());
		for (Square letterTileInMove : move.getLetterTiles()) {
			boolean thisLetterFlag = false;
			boolean[] letterUse = new boolean[move.getPlayer().getLetters().size()];
			Arrays.fill(letterUse, false);
			int num = 0;
			for (LetterTile letterTileInPlayer : move.getPlayer().getLetters())

				if (letterTileInMove.getLetterTile().getLetter() == letterTileInPlayer.getLetter() && !letterUse[num]) {
					thisLetterFlag = true;
					letterUse[num] = true;
				}
			num++;
			if (!thisLetterFlag)
				return false;
		}
		return true;
	}

	/**
	 * Checks for special tile.
	 *
	 * @param move
	 *            the move
	 * @return true, if successful
	 */
	private boolean hasSpecialTile(Move move) {
		if (move.getSpecialTile() == null)
			return true;
		for (SpecialTile specialTile : move.getPlayer().getSpecialTile()) {
			if (specialTile.getName().equals(move.getSpecialTile().getName()))
				return true;
		}
		return false;
	}

	/**
	 * Before apply move,all the players can see what letter tiles are going to
	 * be placed on the board so they have the last chance to challenge.
	 * 
	 * If someone challenged and then the system response to the challenge but
	 * if no one challenged the move is going to be on the board and no one can
	 * challenge at all. The challengeFlag is true if the challenge successes.
	 * 
	 * If challenge successes,we do not do the sequence of activate SP/update
	 * scores/add letter tiles to the board. We only place the SP to the board
	 * as usual.
	 * 
	 * If challenge fails,we will activate SP,add letter tiles to board,change
	 * the score of the player.
	 * 
	 *
	 * @param move
	 *            the move
	 */
	public void applyMove(Move move) {
		boolean challengeFlag = false;
		Word word = board.getCompleteWordInMove(move);

		if (someoneChallenge != null) {
			if (!dict.in(word.getString()))
				challengeFlag = true;
			else {
				controller.skip(someoneChallenge.getName());
			}
		}
		if (!challengeFlag) {
			firstMove = false;
			collectSpecialTile(move);
			activeSpecialTile(move);
			board.setLetterTiles(move);
			word = board.getCompleteWordInMove(move);
			if (word != null)
				controller.addValueInCurrentPlayer(word.getValue() * negative);
		}
		board.setSpecialTile(move);
		showLetter(word);
		showScore();

	}
	
	public Player getChallenger(){
		return someoneChallenge;
//		return challengeFlag;
	}

	/**
	 * Next player reset.
	 */
	public void nextPlayerReset() {
		controller.nextPlayer();
		boomList = new ArrayList<>();
		exchangeList = new ArrayList<>();
		negative = 1;
		someoneChallenge = null;
//		challengeFlag = false;
	}

	/**
	 * Collect special tile.
	 *
	 * @param move
	 *            the move
	 */
	private void collectSpecialTile(Move move) {
		ArrayList<Square> specialTiles = board.checkSpecialTile(move);

		for (Square tile : specialTiles) {
			if (tile.hasSpecialTile()) {
				for (SpecialTile specialTile : tile.getSpecialTile())
					specialTile.activeSpecialEffect(this, tile, specialTile.getOwner());
					board.unsetSpecialTile(tile);
			}
		}
	}

	/**
	 * Active special tile.
	 *
	 * @param move
	 *            the move
	 */
	private void activeSpecialTile(Move move) {
		activeBoom(move);
		activeExchange();
	}

	/**
	 * Active boom.
	 *
	 * @param move
	 *            the move
	 */
	private void activeBoom(Move move) {
		for (Square boomSquare : boomList) {
			System.out.println("Boom");
			board.boom(boomSquare, move);
		}
	}

	/**
	 * Active exchange.
	 */
	private void activeExchange() {
		for (Player player : exchangeList) {
			System.out.println("Exchange");
			int tmp1 = player.getScore();
			int tmp2 = controller.currentPlayer().getScore();
			controller.setScore(tmp1, controller.currentPlayer().getName());
			controller.setScore(tmp2, player.getName());
		}
	}

	/**
	 * Sets the letter tile.
	 *
	 * @param move
	 *            the new letter tile
	 */
	public void setLetterTile(Move move) {
		board.setLetterTiles(move);
	}

	/**
	 * Sets the special tile.
	 *
	 * @param move
	 *            the new special tile
	 */
	public void setSpecialTile(Move move) {
		board.setSpecialTile(move);
	}

	/**
	 * Adds the boom.
	 *
	 * @param square
	 *            the square
	 */
	public void addSkipTurn(Player player) {
		controller.skip(player.getName());
	}
	
	/**
	 * Adds the boom.
	 *
	 * @param square
	 *            the square
	 */
	public void addBoom(Square square) {
		boomList.add(square);
	}

	/**
	 * Adds the exchange.
	 *
	 * @param exchangeOwner
	 *            the exchange owner
	 */
	public void addExchange(Player exchangeOwner) {
		exchangeList.add(exchangeOwner);
	}

	/**
	 * Adds the reverse.
	 */
	public void addReverse() {
		controller.reverseOrder();
	}

	/**
	 * Adds the negative.
	 */
	public void addNegative() {
		negative = -negative;
	}

	/**
	 * Adds the unknown special tiles influence.
	 */
	public void addUnknown() {

	}

	/**
	 * Gets the current player.
	 *
	 * @return the current player
	 */
	public Player getCurrentPlayer() {
		return controller.currentPlayer();
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}

	/**
	 * Show letter.
	 *
	 * @param word
	 *            the word
	 */
	public void showLetter(Word word) {
		if (word == null) {
			System.out.println("");
			System.out.println(0);
		} else {
			System.out.println(word.getString());
			System.out.println(word.getValue());
		}

	}

	/**
	 * Show board.
	 */
	public void showBoard() {
		board.showBoard();
	}

	/**
	 * Show score.
	 */
	public void showScore() {
		for (Player player : controller.getPlayers()) {
			System.out.println(player.getName() + ":" + player.getScore());
		}
	}

	/**
	 * Replenish.
	 */
	public void replenish() {
		controller.currentPlayer().replenish(PLAYER_LETTER_NUMS);
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}
	
	/**
	 * Someone challenges.
	 *
	 * @return void
	 */
	public void setChallenger(Player player){
		this.someoneChallenge = player;
	}
	
	public void resetLetterTileRack(){
		Player player = this.getCurrentPlayer();
		player.resetLetterTileRack();
		
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String args[]) {
		GameSystem game = new GameSystem();
		Player Me = new Player("Me");
		Me.replenish(98);
		System.out.println(Me.getName());
		
		Player Can = new Player("Can");
		Can.replenish(98);
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
		move = new Move(letterTiles, game.getCurrentPlayer());
		if (game.checkMatchBoard(move))
			game.applyMove(move);
		game.replenish();
		game.showBoard();
	}
}
