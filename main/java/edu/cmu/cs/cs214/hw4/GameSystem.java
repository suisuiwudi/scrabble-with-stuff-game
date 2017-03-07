package edu.cmu.cs.cs214.hw4;

import java.util.LinkedList;
import java.util.List;


public class GameSystem {
	private static final int BOARD_SIZE = 15;
	private static final String PATH = "aaa";
	private Dictionary dict;
	private boolean firstMove;
	private LinkedList<Player> players;
	private int order;
	private Board board;

	public GameSystem() {
		dict = new Dictionary(PATH);
		firstMove = true;
		board = new Board(dict);

	}

	public void addPlayer(String string) {
		players.add(new Player(string));
	}

	public void playMove(Move move) {
		if (!board.checkInOneLine(move)) {
			return;
			// TO DO
		}
		;
		if (firstMove) {
			if (!board.checkStar(move)) {
				return;
				//TO DO
			}
		} else {
			board.checkMatchBoard(move);
			board.checkJoint(move);
			
			List<Square> specialTiles = board.checkSpecialTile(move);
			activeSpecialTile(specialTiles);
			
		}
	}
	public void activeSpecialTile(List<Square> specialTiles){
		//TO DO
	}
	
	public void chanllege(){
		
	}
	
	public int nextPlayer() {
		return 0;
	}

	public void setBoom(Square square) {

	}

	public void setReverse() {

	}

	public void setNegative() {

	}

	public void setExchange(Player exchangeOwner) {

	}

	public void setUnknown() {

	}
}
