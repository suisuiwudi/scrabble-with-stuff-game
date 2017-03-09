package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import edu.cmu.cs.cs214.hw4.NormalBonusTile.*;
import edu.cmu.cs.cs214.hw4.SpecialTile.SpecialTile;

public class Board {
	private static final int[] dx = { 0, 1, -1, 0, 0 };
	private static final int[] dy = { 0, 0, 0, 1, -1 };
	private static final int BOARD_SIZE = 15;
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

	private Dictionary dict;
	private Square[][] squares;
	private int[] star;

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
		star = new int[2];
		star[0] = 7;
		star[1] = 7;
	}

	public void setDict(Dictionary dict) {
		this.dict = dict;
	}

	public boolean checkStar(Move move) {
		if (move.getLetterTiles().size() < 2) return false;
		for (Square tile : move.getLetterTiles()) {
			if (tile.getX() == star[0] && tile.getY() == star[1])
				return true;
		}

		return false;
	}

	public boolean checkInOneLine(Move move) {
		return move.isOneLine();
	}

	public boolean checkJoint(Move move) {
		boolean jointFlag = false;
		for (Square tile : move.getLetterTiles()) {
			for (int k = 0; k < dx.length; k++) {
				int tmpPosX = tile.getX() + dx[k];
				int tmpPosY = tile.getY() + dy[k];
				if (tmpPosX < 0 || tmpPosX >= BOARD_SIZE || tmpPosY < 0 || tmpPosY >= BOARD_SIZE)
					continue;
				if (squares[tmpPosX][tmpPosY].getLetterTile() != null) {
					jointFlag = true;
				}
			}
		}
	
		return jointFlag;
	}

	public ArrayList<Square> checkSpecialTile(Move move) {
		ArrayList<Square> specialTiles = new ArrayList<>();
		for (Square letterTile : move.getLetterTiles()) {
			if (squares[letterTile.getX()][letterTile.getY()].hasSpecialTile())
				specialTiles.add(squares[letterTile.getX()][letterTile.getY()]);
			}
		return specialTiles;
	}

	public void setLetterTiles(Move move) {
		for (Square letterTile : move.getLetterTiles()) {
			squares[letterTile.getX()][letterTile.getY()].setLetterTile(letterTile.getLetterTile());
		}
	}

	public void setSpecialTile(Move move) {
		squares[move.getSpeicalTileX()][move.getSpecialTileY()].setSpecialTile(move.getSpecialTile());
	}

	public Word getCompleteWordInMove(Move move) {
		Word word = null;
		if (move.getLetterTiles().size() == 0) return word;
		Square[][] tmp = new Square[BOARD_SIZE][BOARD_SIZE];
		boolean[][] letterInMove = new boolean[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++) {
				tmp[i][j] = new Square(i,j);
				tmp[i][j].setLetterTile(squares[i][j].getLetterTile());;
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
						value += tmp[x][i].getLetterTile().getValue();
					if (normalBonus.getName().equals("3LS"))
						value += 2 * tmp[x][i].getLetterTile().getValue();
					if (normalBonus.getName().equals("2WS"))
						times *= 2;
					if (normalBonus.getName().equals("3WS"))
						times *= 3;
				}

			}
			word = new Word(x, y, 0, sb.toString(), value * times);
		}
		return word;
	}

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
						value += tmp[i][y].getLetterTile().getValue();
					if (normalBonus.getName().equals("3LS"))
						value += 2 * tmp[i][y].getLetterTile().getValue();
					if (normalBonus.getName().equals("2WS"))
						times *= 2;
					if (normalBonus.getName().equals("3WS"))
						times *= 3;
				}

			}
			word = new Word(x, y, 1, sb.toString(), value * times);
		}
		return word;
	}

	public boolean isInDict(Move move) {
		return true;
	}
	public void boom(Square boomSquare, Move move){
		for (int i = 0; i < BOARD_SIZE; i++)
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (Math.abs(boomSquare.getX()-i) + Math.abs(boomSquare.getY()-j) <= 3 )
				squares[i][j].unsetLetterTile();;
			}
		ArrayList<Square> tmp = new ArrayList<>();
		for (Square square : move.getLetterTiles()){
			if (Math.abs(boomSquare.getX()-square.getX()) + Math.abs(boomSquare.getY()-square.getY()) > 3 ){
				tmp.add(square);
			}
		}
		move.setLetterTiles(tmp);
	}
	public void showBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {

			for (int j = 0; j < BOARD_SIZE; j++) {

				if (squares[i][j].hasLetterTile()) {
					System.out.print(" " + squares[i][j].getLetterTile().getLetter() + " ");
				} else if (squares[i][j].hasNormalBonus())
					System.out.print(squares[i][j].getNormalBonus().getName());
				// if (squares[i][j].hasSpecialTile())
				// System.out.print(squares[i][j].getSpecialTile().getName());
			}
			System.out.println();
		}
	}
}
