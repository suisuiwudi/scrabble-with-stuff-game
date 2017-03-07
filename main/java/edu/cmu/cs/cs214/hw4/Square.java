package edu.cmu.cs.cs214.hw4;


public abstract class Square {
	private int x;
	private int y;
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public boolean hasLetterTile(){
		return false;
	}
	public boolean hasSpecialTile() {
		return false;
	}
	public boolean hasNormalTile(){
		return false;
	}

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

}
