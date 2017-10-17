package edu.cmu.cs.cs214.hw4.gui;

import java.util.ArrayList;

import edu.cmu.cs.cs214.hw4.core.GameSystem;
import edu.cmu.cs.cs214.hw4.core.LetterTile;
import edu.cmu.cs.cs214.hw4.core.Move;
import edu.cmu.cs.cs214.hw4.core.Square;

public class Scrabble {
	private GameSystem game;
	
	private GameWindow gameWindow;
	private ArrayList<GameWindow> gameWindows;
	private WelcomeWindow welcomeWindow;
	private PromptWindow promptWindow;
	private PlaceWindow placeWindow;
	private ShopWindow shopWindow;
	private BaseBoard baseBoard;
	
	private String gameWindowTitle;
	private int placeX;
	private int placeY;
	private ArrayList<Square> submits;
	private Move move;
//	private ArrayList<LetterTile> lettersInPlaceWindow;
	
	
	
	public Scrabble(){
		game = new GameSystem();
		
		gameWindows = new ArrayList<GameWindow>();
		welcomeWindow = new WelcomeWindow(this);
//		lettersInPlaceWindow = new ArrayList<>();
		setSubmits(new ArrayList<>());
	}
	
	public int getGameWindowsNum(){
		return this.gameWindows.size();
		
	}
	
	private void registerGameWindow(GameWindow gw){
		if(!gameWindows.contains(gw)){
			gameWindows.add(gw);
		}
	}
	
	public void updateAllGameWindow(){
		for(GameWindow gw : gameWindows){
			gw.updateMyWindow();
		}
	} 
	
	public void seeSubmits(){
		for(GameWindow gw : gameWindows){
			gw.seeOtherSubmits();
		}
	} 
	
	public void newPromptWindow(String s){
		this.promptWindow = new PromptWindow(s);
	}
	
	public void newPlaceWindow(){
		PlaceWindow placeWindow = new PlaceWindow(this);
	}
	
	public void newShopWindow(){
		//TODO
//		this.shopWindow = new ShopWindow(this);
	}
	
	public void newGameWindow(){
		GameWindow gameWindow = new GameWindow(this);
		this.registerGameWindow(gameWindow);
	}
	
	
	public void newBaseBoard(){
		this.baseBoard = new BaseBoard();
	}
	
	public GameSystem getGameSystem(){
		return this.game;
	}

	public static void main(String args[]){
		Scrabble scrabble = new Scrabble();
	}

	

	

	/**
	 * @return the move
	 */
	public Move getMove() {
		return move;
	}

	/**
	 * @param move the move to set
	 */
	public void setMove(Move move) {
		this.move = move;
	}

	/**
	 * @return the submits
	 */
	public ArrayList<Square> getSubmits() {
		return submits;
	}

	/**
	 * @param submits the submits to set
	 */
	public void setSubmits(ArrayList<Square> submits) {
		this.submits = submits;
	}

	/**
	 * @return the gameWindowTitle
	 */
	public String getGameWindowTitle() {
		return gameWindowTitle;
	}

	/**
	 * @param gameWindowTitle the gameWindowTitle to set
	 */
	public void setGameWindowTitle(String gameWindowTitle) {
		this.gameWindowTitle = gameWindowTitle;
	}

	/**
	 * @return the placeX
	 */
	public int getPlaceX() {
		return placeX;
	}

	/**
	 * @param placeX the placeX to set
	 */
	public void setPlaceX(int placeX) {
		this.placeX = placeX;
	}

	/**
	 * @return the placeY
	 */
	public int getPlaceY() {
		return placeY;
	}

	/**
	 * @param placeY the placeY to set
	 */
	public void setPlaceY(int placeY) {
		this.placeY = placeY;
	}

	public void afterValidApply() {
		game.applyMove(move);
		ArrayList<LetterTile> deleteLetters = new ArrayList<>();
		for(Square square : this.getSubmits()){
			LetterTile letterTile = square.getLetterTile();
			deleteLetters.add(letterTile);
		}
		game.getCurrentPlayer().deleteLetterTile(deleteLetters);
	}

	public void afterPressEndTurn() {
		game.replenish();
		game.nextPlayerReset();
		PromptWindow remainPrompt = new PromptWindow("You have "+game.getCurrentPlayer().getRemainingLetterTiles()+"letter(s) left in your bag");
		setSubmits(new ArrayList<>());
		newPromptWindow("Now Player has changed to : "+game.getCurrentPlayer().getName());
		updateAllGameWindow();
		
	}

}
