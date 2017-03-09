package edu.cmu.cs.cs214.hw4;

import java.util.ArrayList;
import java.util.Random;

public class LetterTileBag {
	private ArrayList<LetterTile> tiles;
	public LetterTileBag(){
		tiles = new ArrayList<LetterTile>();
		for (char i = 65; i < 91; i++){
			tiles.add(new LetterTile(i,1));
		}
	}
	public void giveBag(ArrayList<LetterTile> inBag){
		tiles.addAll(inBag);
	}
	public ArrayList<LetterTile> takeBag(int num){
		Random rand = new Random();
		ArrayList<LetterTile> outBag = new ArrayList<>();
		for (int i = 0; i < num; i++){
			int rnd = rand.nextInt(tiles.size());
			outBag.add(tiles.get(rnd));
			tiles.remove(rnd);
			
		}
		return outBag;
	}
	
}
