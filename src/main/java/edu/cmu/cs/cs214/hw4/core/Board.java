package edu.cmu.cs.cs214.hw4.core;

import java.util.ArrayList;

import edu.cmu.cs.cs214.hw4.core.NormalBonusTile.DoubleLetter;
import edu.cmu.cs.cs214.hw4.core.NormalBonusTile.DoubleWord;
import edu.cmu.cs.cs214.hw4.core.NormalBonusTile.NormalBonus;
import edu.cmu.cs.cs214.hw4.core.NormalBonusTile.TripleLetter;
import edu.cmu.cs.cs214.hw4.core.NormalBonusTile.TripleWord;


/**
 * The Class Board.
 */
public class Board {

	/** The Constant DX. */
	private static final int[] DX = {  1, -1, 0, 0 };

	/** The Constant DY. */
	private static final int[] DY = {  0, 0, 1, -1 };

	/** The Constant BOARD_SIZE. */
	private static final int BOARD_SIZE = 15;

	/** The Constant BOARD. */
	private static final String[][] BOARD = {
			{ "3WS", ".", ".", "2LS", ".", ".", ".", "3WS", ".", ".", ".", "2LS", ".", ".", "3WS" },
			{ ".", "2WS", ".", ".", ".", "3LS", ".", ".", ".", "3LS", ".", ".", ".", "2WS", "." },
			{ ".", ".", "2WS", ".", ".", ".", "2LS", ".", "2LS", ".", ".", ".", "2WS", ".", "." },
			{ "3LS", ".", ".", "2WS", ".", ".", ".", "2LS", ".", ".", ".", "2WS", ".", ".", "3LS" },
			{ ".", ".", ".", ".", "2WS", ".", ".", ".", ".", ".", "2WS", ".", ".", ".", "." },
			{ ".", "3LS", ".", ".", ".", "3LS", ".", ".", ".", "3LS", ".", ".", ".", "3LS", "." },
			{ ".", ".", "2LS", ".", ".", ".", "2LS", ".", "2LS", ".", ".", ".", "2LS", ".", "." },
			{ "3WS", ".", ".", "2LS", ".", ".", ".", "2LS", ".", ".", ".", "2LS", ".", ".", "3WS" },
			{ ".", ".", "2LS", ".", ".", ".", "2LS", ".", "2LS", ".", ".", ".", "2LS", ".", "." },
			{ ".", "3LS", ".", ".", ".", "3LS", ".", ".", ".", "3LS", ".", ".", ".", "3LS", "." },
			{ ".", ".", ".", ".", "2WS", ".", ".", ".", ".", ".", "2WS", ".", ".", ".", "." },
			{ "3LS", ".", ".", "2WS", ".", ".", ".", "2LS", ".", ".", ".", "2WS", ".", ".", "3LS" },
			{ ".", ".", "2WS", ".", ".", ".", "2LS", ".", "2LS", ".", ".", ".", "2WS", ".", "." },
			{ ".", "2WS", ".", ".", ".", "3LS", ".", ".", ".", "3LS", ".", ".", ".", "2WS", "." },
			{ "3WS", ".", ".", "2LS", ".", ".", ".", "3WS", ".", ".", ".", "2LS", ".", ".", "3WS" } };

	/** The Constant STAR. */
	private static final int[] STAR = { 7, 7 };

	/** The dict. */
//	private Dictionary dict;

	/** The squares. */
	private Square[][] squares;

	/**
	 * Instantiates a new board.
	 */
	public Board() {
		squares = new Square[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++) {
				squares[i][j] = new Square(i, j);
				if (BOARD[i][j].equals("2LS")) {
					squares[i][j].setNormalBonus(new DoubleLetter());
				} else if (BOARD[i][j].equals("2WS")) {
					squares[i][j].setNormalBonus(new DoubleWord());
				} else if (BOARD[i][j].equals("3LS")) {
					squares[i][j].setNormalBonus(new TripleLetter());
				} else if (BOARD[i][j].equals("3WS")) {
					squares[i][j].setNormalBonus(new TripleWord());
				}
			}

	}

	/**
	 * Sets the dict.
	 *
	 * @param dict
	 *            the new dict
	 */
//	public void setDict(Dictionary dict) {
//		this.dict = dict;
//	}

	/**
	 * Check star.
	 *
	 * @param move
	 *            the move
	 * @return true, if successful
	 */
	public boolean checkStar(Move move) {
		if (move.getLetterTiles().size() < 2)
			return false;
		for (Square tile : move.getLetterTiles()) {// ??????
			if (tile.getX() == STAR[0] && tile.getY() == STAR[1])
				return true;
		}

		return false;
	}

	/**
	 * Check in one line.
	 *
	 * @param move
	 *            the move
	 * @return true, if successful
	 */
	public boolean checkInOneLine(Move move) {
		return move.isOneLine();
	}

	/**
	 * Check joint.
	 *
	 * @param move
	 *            the move
	 * @return true, if successful
	 */
	public boolean checkJoint(Move move) {
		boolean jointFlag = false;
		for (Square tile : move.getLetterTiles()) {
			for (int k = 0; k < DX.length; k++) {
				int tmpPosX = tile.getX() + DX[k];
				int tmpPosY = tile.getY() + DY[k];
				if (tmpPosX < 0 || tmpPosX >= BOARD_SIZE || tmpPosY < 0 || tmpPosY >= BOARD_SIZE)
					continue;
				if (squares[tmpPosX][tmpPosY].getLetterTile() != null) {// is
																		// occupied
					jointFlag = true;
				}
			}
		}

		return jointFlag;
	}

	/**
	 * Check special tile.
	 *
	 * @param move
	 *            the move
	 * @return the array list
	 */
	public ArrayList<Square> checkSpecialTile(Move move) {
		ArrayList<Square> specialTiles = new ArrayList<>();
		for (Square letterTile : move.getLetterTiles()) {
			if (squares[letterTile.getX()][letterTile.getY()].hasSpecialTile())
				specialTiles.add(squares[letterTile.getX()][letterTile.getY()]);
		}
		return specialTiles;
	}
	
	public void unsetSpecialTile(Square square){
		int x = square.getX();
		int y = square.getY();
		this.squares[x][y].unsetSpecialTile();
	}

	/**
	 * Sets the letter tiles.
	 *
	 * @param move
	 *            the new letter tiles
	 */
	public void setLetterTiles(Move move) {
		for (Square letterTile : move.getLetterTiles()) {
			squares[letterTile.getX()][letterTile.getY()].setLetterTile(letterTile.getLetterTile());
		}
	}

	/**
	 * Sets the special tile.
	 *
	 * @param move
	 *            the new special tile
	 */
	public void setSpecialTile(Move move) {
		squares[move.getSpeicalTileX()][move.getSpecialTileY()].setSpecialTile(move.getSpecialTile());
	}

	/**
	 * Gets the complete word in move.
	 *
	 * @param move
	 *            the move
	 * @return the complete word in move
	 */
	public Word getCompleteWordInMove(Move move) {
		Word word = null;
		if (move.getLetterTiles().size() == 0)
			return word;
		Square[][] tmp = new Square[BOARD_SIZE][BOARD_SIZE];
		boolean[][] letterInMove = new boolean[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++) {
				tmp[i][j] = new Square(i, j);
				tmp[i][j].setLetterTile(squares[i][j].getLetterTile());
				tmp[i][j].setNormalBonus(squares[i][j].getNormalBonus());
				letterInMove[i][j] = false;
			}
		for (Square tile : move.getLetterTiles()) {
			tmp[tile.getX()][tile.getY()].setLetterTile(tile.getLetterTile());
			letterInMove[tile.getX()][tile.getY()] = true;
		}

		word = getColumn(tmp, letterInMove, move);
		if (word == null)
			word = getRow(tmp, letterInMove, move);

		return word;
	}

	/**
	 * Gets the row.
	 *
	 * @param tmp
	 *            the tmp
	 * @param letterInMove
	 *            the letter in move
	 * @param move
	 *            the move
	 * @return the row
	 */
	private Word getRow(Square[][] tmp, boolean[][] letterInMove, Move move) {
		Word word = null;
		Square aLetterInMove = move.getLetterTiles().get(0);
		int x = aLetterInMove.getX();
		int y = aLetterInMove.getY();
		while (y > 0 && tmp[x][y - 1].getLetterTile() != null)
			y--;
		int yi = y;
		int findLetterInMove = 0;
		while (yi < BOARD_SIZE) {
			if (tmp[x][yi].getLetterTile() == null)
				break;
			if (letterInMove[x][yi])
				findLetterInMove++;
			yi++;
		}
		if (findLetterInMove == move.getLetterTiles().size()) {
			StringBuilder sb = new StringBuilder();
			int value = 0;
			int times = 1;
			for (int i = y; i < yi; i++) {

				sb.append(tmp[x][i].getLetterTile().getLetter());
				value += tmp[x][i].getLetterTile().getValue();

				if (letterInMove[x][i] && tmp[x][i].getNormalBonus() != null) {
					NormalBonus normalBonus = tmp[x][i].getNormalBonus();
					if (normalBonus.getName().equals("2LS"))
						value += (normalBonus.getTimes()-1) * tmp[i][y].getLetterTile().getValue();
					if (normalBonus.getName().equals("3LS"))
						value += (normalBonus.getTimes()-1) * tmp[i][y].getLetterTile().getValue();
					if (normalBonus.getName().equals("2WS"))
						times *= normalBonus.getTimes();
					if (normalBonus.getName().equals("3WS"))
						times *= normalBonus.getTimes();
				}

			}
			word = new Word(x, y, 0, sb.toString(), value * times);
		}
		return word;
	}

	/**
	 * Gets the column.
	 *
	 * @param tmp
	 *            the tmp
	 * @param letterInMove
	 *            the letter in move
	 * @param move
	 *            the move
	 * @return the column
	 */
	private Word getColumn(Square[][] tmp, boolean[][] letterInMove, Move move) {

		Word word = null;
		Square aLetterInMove = move.getLetterTiles().get(0);
		int x = aLetterInMove.getX();
		int y = aLetterInMove.getY();
		while (x > 0 && tmp[x - 1][y].getLetterTile() != null)
			x--;
		int xi = x;
		int findLetterInMove = 0;
		while (xi < BOARD_SIZE) {
			if (tmp[xi][y].getLetterTile() == null)
				break;
			if (letterInMove[xi][y])
				findLetterInMove++;
			xi++;
		}

		if (findLetterInMove == move.getLetterTiles().size()) {
			StringBuilder sb = new StringBuilder();
			int value = 0;
			int times = 1;
			for (int i = x; i < xi; i++) {
				sb.append(tmp[i][y].getLetterTile().getLetter());
				value += tmp[i][y].getLetterTile().getValue();
				if (letterInMove[i][y] && tmp[i][y].getNormalBonus() != null) {
					NormalBonus normalBonus = tmp[i][y].getNormalBonus();
					if (normalBonus.getName().equals("2LS"))
						value += (normalBonus.getTimes()-1)*tmp[i][y].getLetterTile().getValue();
					if (normalBonus.getName().equals("3LS"))
						value += (normalBonus.getTimes()-1) * tmp[i][y].getLetterTile().getValue();
					if (normalBonus.getName().equals("2WS"))
						times *= normalBonus.getTimes();
					if (normalBonus.getName().equals("3WS"))
						times *= normalBonus.getTimes();
				}

			}
			word = new Word(x, y, 1, sb.toString(), value * times);
		}
		return word;
	}

	/**
	 * Checks if is in dict.
	 *
	 * @param move
	 *            the move
	 * @return true, if is in dict
	 */
	public boolean isInDict(Move move) {
		return true;
	}

	/**
	 * Gets the squares.
	 *
	 * @return the squares
	 */
	public Square[][] getSquares() {
		return squares;
	}

	/**
	 * Boom.
	 *
	 * @param boomSquare
	 *            the boom square
	 * @param move
	 *            the move
	 */
	public void boom(Square boomSquare, Move move) {
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (Math.abs(boomSquare.getX() - i) + Math.abs(boomSquare.getY() - j) <= 3)
					squares[i][j].unsetLetterTile();
			}
		ArrayList<Square> tmp = new ArrayList<>();
		for (Square square : move.getLetterTiles()) {
			if (Math.abs(boomSquare.getX() - square.getX()) + Math.abs(boomSquare.getY() - square.getY()) > 3) {
				tmp.add(square);
			}
		}
		move.setLetterTiles(tmp);
	}

	/**
	 * Show board.
	 */
	public void showBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {

			for (int j = 0; j < BOARD_SIZE; j++) {

				if (squares[i][j].hasLetterTile()) {
					System.out.print(" " + squares[i][j].getLetterTile().getLetter() + " ");
				} else if (squares[i][j].hasNormalBonus())
					System.out.print(squares[i][j].getNormalBonus().getName());
			}
			System.out.println();
		}
	}
}
