package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Move {

	private static final int BOARD_SIZE = 15;
	private ArrayList<Square> letterTilesList;
	private Word word;
	private boolean specialTileMove;
	private Player player;
	public Move(ArrayList<Square> letterTilesList, Player player){
		this.letterTilesList = letterTilesList;
		this.specialTileMove = false;
		this.player = player;
	}
//	public Move(int[] specialTilePosition, SpecialTile specialTile){
//		this.specialTileMove = true;
//	}
	public boolean isOneLine(){
		int x = -1;
		int y = -1;
		for (Square tile: letterTilesList){
			if (x == -1){
				x = tile.getX();
				y = tile.getY();
			} else{
				boolean flagInOneLine = false;
				if ( x!= tile.getX()) flagInOneLine = !flagInOneLine;
				if ( y!= tile.getY()) flagInOneLine = !flagInOneLine;
				if (!flagInOneLine) return false;
			}
		}
		return true;
	}

	public Player getPlayer(){
		return player;
	}
	public ArrayList<Square> getLetterTiles(){
		return letterTilesList;
	}
}
