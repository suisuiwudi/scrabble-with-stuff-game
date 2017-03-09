package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import edu.cmu.cs.cs214.hw4.SpecialTile.SpecialTile;

public class Move {

	private static final int BOARD_SIZE = 15;
	private ArrayList<Square> letterTilesList;
	private Word word;
	private Player player;
	private SpecialTile specialTile;
	private int specialTileX;
	private int specialTileY;
	public Move(ArrayList<Square> letterTilesList, Player player){
		this.letterTilesList = letterTilesList;
		this.specialTile = null;
		this.player = player;
	}
	public void setSpecialTile(int x, int y, SpecialTile specialTile){
		specialTileX = x;
		specialTileY = y;
		this.specialTile = specialTile;
	}
	public void setLetterTiles(ArrayList<Square> letterTilesList){
		this.letterTilesList = letterTilesList;
	}
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
	public boolean hasSpecialTile(){
		return specialTile != null;
	}
	public SpecialTile getSpecialTile(){
		return specialTile;
	}
	public int getSpeicalTileX(){
		return specialTileX;
	}
	public int getSpecialTileY(){
		return specialTileY;
	}
}
