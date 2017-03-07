package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Board {
	private static final int[] dx = {0,1,-1,0,0};
	private static final int[] dy = {0,0,0,1,-1};
	private static final int BOARD_SIZE = 15;
	private Dictionary dict;
	private Square[][]  squares;
	private int[] star;
	public Board(Dictionary dict){
		this.dict = dict;
		squares = new Square[BOARD_SIZE][BOARD_SIZE];
	}
	public boolean checkStar(Move move){
		for (Square tile : move.getLetterTiles()){
			if ( tile.getX() == star[0] && tile.getY() == star[1] )
				return true;
		};
		return false;
	}
	public boolean checkInOneLine(Move move){
		return move.isOneLine();
	}
	//checkMatchBoard
	public boolean checkMatchBoard(Move move){

		
//		player.getLetters();
		return true;
	}
	public boolean checkJoint(Move move){
		boolean jointFlag = false;
		for (Square tile: move.getLetterTiles()){
			for (int k = 0; k < dx.length; k++){
				int tmpPosX = tile.getX()+dx[k];
				int tmpPosY = tile.getY()+dy[k];
				if (tmpPosX< 0 || tmpPosX >= BOARD_SIZE || tmpPosY  < 0 || tmpPosY  >=BOARD_SIZE)
					continue;
				if (squares[tmpPosX][tmpPosY].hasLetterTile()){
					jointFlag = true;
				}
			}
		}
		return jointFlag;
	}
	public ArrayList<Square> checkSpecialTile(Move move){
		ArrayList<Square> specialTiles = new ArrayList<>();
		for (Square letterTile: move.getLetterTiles()){
			if (squares[letterTile.getX()][letterTile.getY()].hasSpecialTile()){
				specialTiles.add(squares[letterTile.getX()][letterTile.getY()]);
			}
		}
		return specialTiles;
	}
	
}