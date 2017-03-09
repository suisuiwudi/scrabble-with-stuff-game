package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.cmu.cs.cs214.hw4.SpecialTile.*;


public class GameSystem {
	private static final int BOARD_SIZE = 15;
	private static final int PLAYER_TILES_NUMS = 7;
	private static final String PATH = "assets/words.txt";
	private Dictionary dict;
	private boolean firstMove;
	private Board board;
	private Controller controller;
	private LetterTileBag letterTileBag;
	private ArrayList<Square> boomList;
	private ArrayList<Player> exchangeList;
	private int negative;
	private Player someoneChallenge;

	public GameSystem() {
		dict = new Dictionary(PATH);
		firstMove = true;
		board = new Board();
		board.setDict(dict);
		controller = new Controller();
		letterTileBag = new LetterTileBag();
		boomList = new ArrayList<>();
		exchangeList = new ArrayList<>();
		negative = 1;
		
	}

	public void addPlayer(Player player) {
		player.addLetterTiles(letterTileBag.takeBag(PLAYER_TILES_NUMS));
		controller.addPlayer(player);
	}
	//can get retry
	public boolean checkMatchBoard(Move move) {
		if (!board.checkInOneLine(move)) {
			return false;
			// TO DO
		}
		
		if (firstMove) {
			if (!board.checkStar(move)) {
				return false;
			}
		} else {
			if (!board.checkJoint(move)) {
				return false;
			
			}
			
		}
		return true;
	}
	
	public void applyMove(Move move){
		boolean challengeFlag = true;
		Word word = board.getCompleteWordInMove(move);
		// show the word and get what if someone challenge 
		// showWord()
		//
		if (someoneChallenge != null) {
			if (!dict.in(word.getString()))
				challengeFlag= false;
			else{
				controller.skip(someoneChallenge.getName());
				
			}
				
		}
		if (challengeFlag) {
			firstMove = false;
			collectSpecialTile(move);
			activeSpecialTile(move);
			board.setLetterTiles(move);
			word = board.getCompleteWordInMove(move);
			if (word != null)
				controller.addValueInCurrentPlayer(word.getValue()*negative);
		}
		board.setSpecialTile(move);
		
		showLetter(word);
		showScore();
		
	}
	public void nextPlayerReset() {
		controller.nextPlayer();
		boomList = new ArrayList<>();
		exchangeList = new ArrayList<>();
		negative = 1;
		someoneChallenge = null;
	}

	public void collectSpecialTile(Move move) {
		// TO DO
		ArrayList<Square> specialTiles = board.checkSpecialTile(move);

		for (Square tile : specialTiles) {
			if (tile.hasSpecialTile()) {
				for (SpecialTile specialTile : tile.getSpecialTile())
					specialTile.activeSpecialEffect(this, tile);
			}
		}
	}

	public void activeSpecialTile(Move move) {
		activeBoom(move);
		activeExchange();
	}

	public void activeBoom(Move move) {
		for (Square boomSquare : boomList) {
			System.out.println("Boom");
			board.boom(boomSquare, move);
		}
	}

	public void activeExchange() {
		for (Player player : exchangeList) {
			System.out.println("Exchange");
			int tmp1 = player.getScore();
			int tmp2 = controller.currentPlayer().getScore();
			controller.setScore(tmp1, controller.currentPlayer().getName());
			controller.setScore(tmp2, player.getName());
		}
	}

	public void setLetterTile(Move move) {
		board.setLetterTiles(move);
	}

	public void setSpecialTile(Move move) {
		board.setSpecialTile(move);
	}

	public void addBoom(Square square) {
		boomList.add(square);
	}

	public void addExchange(Player exchangeOwner) {
		exchangeList.add(exchangeOwner);
	}

	public void addReverse() {
		controller.reverseOrder();
	}

	public void addNegative() {
		negative = -negative;
	}

	public void addUnknown() {

	}

	public void showLetter(Word word) {
		if (word == null) {
			System.out.println("");
			System.out.println(0);
		} else {
			System.out.println(word.getString());
			System.out.println(word.getValue());
		}

	}

	public void showBoard() {
		board.showBoard();
	}
	public void showScore(){
		for (Player player: controller.getPlayers()){
			System.out.println(player.getName()+":"+player.getScore());
		}
	}
	public static void main(String args[]) {
		GameSystem game = new GameSystem();
		Player Me = new Player("Me");
		System.out.println(Me.getName());
		Player Can = new Player("Can");
		game.addPlayer(Me);
		game.addPlayer(Can);
		ArrayList<Square> letterTiles = new ArrayList<>();
		Square square = new Square(7, 7);
		square.setLetterTile(new LetterTile('z', 3));
		letterTiles.add(square);
		square = new Square(7, 8);
		square.setLetterTile(new LetterTile('o', 3));
		letterTiles.add(square);
		square = new Square(7, 9);
		square.setLetterTile(new LetterTile('o', 3));
		letterTiles.add(square);
		Move move = new Move(letterTiles, Me);
		SpecialTile specialTile = new ExhangeSpecialTile();
		specialTile.setOwner(Me);
		move.setSpecialTile(8, 9, specialTile);
		if (game.checkMatchBoard(move))
			game.applyMove(move);
		game.showBoard();
		game.nextPlayerReset();

		letterTiles = new ArrayList<>();
		square = new Square(8, 8);
		square.setLetterTile(new LetterTile('z', 3));
		letterTiles.add(square);
		square = new Square(8, 9);
		square.setLetterTile(new LetterTile('o', 3));
		letterTiles.add(square);
		square = new Square(8, 10);
		square.setLetterTile(new LetterTile('o', 3));
		letterTiles.add(square);
		move = new Move(letterTiles, Can);
		if (game.checkMatchBoard(move))
			game.applyMove(move);
		game.showBoard();
		game.nextPlayerReset();
		
		letterTiles = new ArrayList<>();
		square = new Square(9, 10);
		square.setLetterTile(new LetterTile('d', 3));
		letterTiles.add(square);
		square = new Square(10, 10);
		square.setLetterTile(new LetterTile('d', 3));
		letterTiles.add(square);
		move = new Move(letterTiles, Me);
		if (game.checkMatchBoard(move))
			game.applyMove(move);
		game.showBoard();
	}
}
