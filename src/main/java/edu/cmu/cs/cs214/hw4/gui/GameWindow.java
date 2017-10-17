package edu.cmu.cs.cs214.hw4.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.cmu.cs.cs214.hw4.core.GameSystem;
import edu.cmu.cs.cs214.hw4.core.LetterTile;
import edu.cmu.cs.cs214.hw4.core.Move;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Square;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.SpecialTile;


public class GameWindow {
	private Scrabble scrabble;
	
	
	/**
	 * There are 3 panels in the main window.
	 * Head Panel displays some info: what's in a square which
	 * your mouse hover above,what you have in your rack,all the 
	 * players' scores till now.
	 */
	private JPanel headPanel;
	
	/**
	 * Board Panel display what's real in a board except special
	 * Tiles. Special Tiles are only visible to their owner.
	 */
	private JPanel boardPanel;
	
	/**
	 * Operation Panel:display the operations that a player can
	 * choose from.
	 */
	private JPanel operationPanel;
	private JPanel wholeWindow;
	private JPanel squareInfoPanel;
	private JPanel scoreBoardPanel;
	private JPanel currentPlayerPanel;
	
	
	private ArrayList<Square> submits;

	
	/**
	 * Click on the button to place something on a square.
	 * The button has to be listened so it must be a field
	 */
	private JButton[] squareButtons;
	private JButton resetLetterTileRackButton;
	private JButton playMoveButton;
	private JButton challengeButton;
	private JButton buySpecialTileButton;
	private JButton endTurnButton;
	private JButton showBaseBoardButton;
	
	private Move move;
	private JLabel[] letterPrompt;
	private JLabel[] scores;
	private JLabel squareSpecialTile;
	private JLabel squareLetterTile;
	private JLabel squareNormalBonus;
	private JLabel currentPlayer;
	
	private String windowOwner;
	
	//TODO
	public GameWindow(Scrabble scrabble){
		this.scrabble = scrabble;
		windowOwner =  new String(scrabble.getGameWindowTitle()) ;
		
		JFrame frame = new JFrame(windowOwner + "'s Scrabble Game Window");
		
		submits = new ArrayList<Square>();
		letterPrompt = new JLabel[7];
		squareSpecialTile = new JLabel();
		squareLetterTile = new JLabel();
		squareNormalBonus = new JLabel();
		currentPlayer = new JLabel();
//		scores = new JLabel[scrabble.getGameSystem().getController().getPlayers().size()];
		
		wholeWindow = new JPanel();
		operationPanel = new JPanel();
		headPanel = new JPanel();
		boardPanel = new JPanel();
		squareInfoPanel = new JPanel();
		scoreBoardPanel = new JPanel();
		currentPlayerPanel = new JPanel();
		
		frame.setSize(1100, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		wholeWindow.setLayout(new BorderLayout());
		frame.add(wholeWindow);

		this.initBoardPanel();
		
	
		this.initOperationPanel();
		this.initHeadPanel();

		frame.setVisible(true);
	}
	

	public String getWindowOwner(){
		return windowOwner;
	}
	
	private void initOperationPanel() {
		operationPanel.setLayout(new BoxLayout(operationPanel,BoxLayout.Y_AXIS));
		resetLetterTileRackButton = new JButton("Reset your letters");
		playMoveButton = new JButton("Play Your Move");
		challengeButton = new JButton("Challenge");
		buySpecialTileButton = new JButton("Shop");
		endTurnButton = new JButton("End this turn");
		showBaseBoardButton = new JButton("Show Base Board");
		operationPanel.add(resetLetterTileRackButton);
		operationPanel.add(playMoveButton);
		operationPanel.add(challengeButton);
		operationPanel.add(buySpecialTileButton);
		operationPanel.add(endTurnButton);
		operationPanel.add(showBaseBoardButton);
		
		this.initPlayMoveButton();
		this.initChallengeButton();
		this.initShopButton();
		this.initEndButton();
		this.initShowBaseBoardButton();
		resetLetterTileRackButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(scrabble.getGameSystem().getCurrentPlayer().getName().equals(windowOwner)){
					scrabble.getGameSystem().resetLetterTileRack();
					for(int i = 0; i < 7;i++){
						letterPrompt[i].setText(scrabble.getGameSystem().getCurrentPlayer().getLetters().get(i).getLetter() + "");
					}
				}
				else{
					PromptWindow pw = new PromptWindow("this is not your turn");
				}
			}
			
		});
		
		wholeWindow.add(operationPanel, BorderLayout.EAST);
		
	}

	private void initShowBaseBoardButton() {
		showBaseBoardButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BaseBoard bb = new BaseBoard();
			}
		});
	}

	private void initEndButton() {
		endTurnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(scrabble.getGameSystem().getCurrentPlayer().getName().equals(windowOwner)){
					if(scrabble.getGameSystem().getChallenger() == null){
						PromptWindow pw = new PromptWindow("No one challenges OR challenges fails. Your move is applyed to board.");
					}
					else{
						PromptWindow pw = new PromptWindow("Someone has challenged. See the board for challenge result");
					}
//				PromptWindow remainPrompt = new PromptWindow("You have "+scrabble.getGameSystem().getCurrentPlayer().getRemainingLetterTiles()+"letter(s) left in your bag");
					
					scrabble.afterPressEndTurn();
				}
				else{
					PromptWindow pw = new PromptWindow("this is not your turn");
				}
					
			}
		});
		
		
	}

	private void initShopButton() {
		buySpecialTileButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(scrabble.getGameSystem().getCurrentPlayer().getName().equals(windowOwner)){
					ShopWindow sw = new ShopWindow(scrabble.getGameSystem());
				}
				else{
					PromptWindow pw = new PromptWindow("this is not your turn");
				}
			}
		});
	}

	private void initChallengeButton() {
		//TODO
		challengeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Player player : scrabble.getGameSystem().getController().getPlayers() ){
					if(player.getName().equals(windowOwner)){
						PromptWindow pw = new PromptWindow(windowOwner +" challenges!");
						scrabble.getGameSystem().setChallenger(player);
						break;
					}
				}
				
			}
		});
	}

	private void initPlayMoveButton() {
		playMoveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(scrabble.getGameSystem().getCurrentPlayer().getName().equals(windowOwner)){
					move = new Move(scrabble.getSubmits(),scrabble.getGameSystem().getCurrentPlayer());
					scrabble.setMove(move);
					if (scrabble.getGameSystem().checkMatchBoard(move)){
						scrabble.newPromptWindow("The move pass the validation");
						scrabble.afterValidApply();
					}
					else{
						scrabble.setSubmits(new ArrayList<>());
						move = new Move(scrabble.getSubmits(),scrabble.getGameSystem().getCurrentPlayer());
						scrabble.setMove(move);
						scrabble.updateAllGameWindow();
						scrabble.newPromptWindow("The move didn't pass the validation");
					}
					
				}
				else{
					PromptWindow pw = new PromptWindow("this is not your turn");
				}
			}
		});
		
	}
	
	private void initHeadPanel() {
		// TODO Auto-generated method stub
		headPanel.setLayout(new BorderLayout());
		
		squareInfoPanel.setLayout(new BoxLayout(squareInfoPanel,BoxLayout.Y_AXIS));
		scoreBoardPanel.setLayout(new BoxLayout(scoreBoardPanel,BoxLayout.Y_AXIS));
		currentPlayerPanel.setLayout(new BoxLayout(currentPlayerPanel,BoxLayout.Y_AXIS));
		
		headPanel.add(squareInfoPanel, BorderLayout.WEST);
		headPanel.add(scoreBoardPanel, BorderLayout.CENTER);
		headPanel.add(currentPlayerPanel, BorderLayout.EAST);
		
		squareInfoPanel.add(squareLetterTile);
		squareInfoPanel.add(squareSpecialTile);
		squareInfoPanel.add(squareNormalBonus);

		currentPlayer.setText("Current Player is : "+scrabble.getGameSystem().getCurrentPlayer().getName());
		currentPlayerPanel.add(currentPlayer);
		
		wholeWindow.add(headPanel, BorderLayout.NORTH);
	}


	private void initBoardPanel(){
		wholeWindow.add(boardPanel,BorderLayout.CENTER);
		//TODO
		boardPanel.setLayout(new GridLayout(16,16));
		squareButtons = new JButton[256];

		ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	if(scrabble.getGameSystem().getCurrentPlayer().getName().equals(windowOwner)){
            		JButton button = (JButton) ae.getSource();
            		for(int index = 0;index < 256;index++){
            			if(button == squareButtons[index]){
            				int x = index/16;
            				int y = index%16;
            				if (scrabble.getGameSystem().getBoard().getSquares()[x-1][y-1].hasLetterTile()){
            					PromptWindow pw = new PromptWindow("this square ("+(x-1)+","+(y-1)+") has a lettiletile");
            				}else if(x != 0 && y != 0){
            					scrabble.setPlaceX(x-1);
            					scrabble.setPlaceY(y-1);
            					scrabble.newPlaceWindow();
            				}
            			}
            		}
            		
            	}
       
            	else{
            		PromptWindow pw = new PromptWindow("this is not your turn");
            	}
            }
        };
		
        
        //This is to initialize the whole board interface
		int index = 0;
		for(int x = 0;x<16;x++){
			for(int y = 0; y < 16;y++){
				index = x*16 + y;
				if(x == 0){
					squareButtons[index] = new JButton(y-1+"");
				}
				if(y == 0){
					squareButtons[index] = new JButton(x-1+"");
				}
				if(x !=0 && y!= 0){
					squareButtons[index] = new JButton(scrabble.getGameSystem().getBoard().getSquares()[x-1][y-1].getNormalBonus().getName());
					String normalBonusName = squareButtons[index].getText();
					switch (normalBonusName) {
					case "3WS" : {
						squareButtons[index].setForeground(Color.RED);
						break;
					}
					case "3LS" : {
						squareButtons[index].setForeground(Color.BLUE);
						break;
					}
					case "2LS" : {
						squareButtons[index].setForeground(Color.CYAN);
						break;
					}
					case "2WS" : {
						squareButtons[index].setForeground(Color.PINK);
						break;
					}
					
					}
				
					//When you click the button,there should be a new window
					//designed to prompt you to place letters and special tiles. 
					squareButtons[index].addActionListener(al);
					
					//When you hover over the button,the related info should be 
					//displayed on the Head Panel.
					squareButtons[index].addMouseListener(new MouseAdapter(){
						public void mouseEntered(MouseEvent me){
							JButton button = (JButton) me.getSource();
							int x = 0,y = 0;
			                for(int index = 0;index < 256;index++){
			                		if(button == squareButtons[index]){
			                			x = index/16;
			                			y = index%16;
			                		}
			                }
			                if(scrabble.getGameSystem().getBoard().getSquares()[x-1][y-1].hasSpecialTile()){
			                		String specialTileInfo = " ";
			                		for(SpecialTile sp : scrabble.getGameSystem().getBoard().getSquares()[x-1][y-1].getSpecialTile()){
			                			if(sp.getOwner().getName().equals(windowOwner)){
			                				specialTileInfo += sp.getName();
			                			}
			                		}
			                		squareSpecialTile.setText("[special tiles are : "+ specialTileInfo +" ]");
			                }
			                else {
			                		squareSpecialTile.setText("[special tiles are : "+"NULL"+" ]");
			                }
			                
			                
			                if(scrabble.getGameSystem().getBoard().getSquares()[x-1][y-1].hasLetterTile()){
			                		squareLetterTile.setText("[letter tiles is : "+scrabble.getGameSystem().getBoard().getSquares()[x-1][y-1].getLetterTile().getLetter()+" ]");
			                }
			                else{
				                	squareLetterTile.setText("[letter tiles is : NULL ]");
			                }
			                	
			                squareNormalBonus.setText("[normal bonus is : "+ scrabble.getGameSystem().getBoard().getSquares()[x-1][y-1].getNormalBonus().getName() +" ]");
						}
					});
				}
				
				boardPanel.add(squareButtons[index]);
				
				
			}
		}
	}
	
	public static void main(String args[]){
		GameSystem game = new GameSystem();
		Player player = new Player("Can Liu");
		game.addPlayer(player);
		game.replenish();
	}

	public void updateMyWindow() {
		for(int i = 0; i<256 ; i++){
			int x = i/16;
			int y = i%16;
			if(x != 0 && y != 0){
				if(scrabble.getGameSystem().getBoard().getSquares()[x-1][y-1].hasLetterTile()){
					squareButtons[i].setText(scrabble.getGameSystem().getBoard().getSquares()[x-1][y-1].getLetterTile().getLetter() + "");
				}
				else{
					squareButtons[i].setText(scrabble.getGameSystem().getBoard().getSquares()[x-1][y-1].getNormalBonus().getName());
					
				}
			}
		}

		currentPlayer.setText("Current Player is : "+scrabble.getGameSystem().getCurrentPlayer().getName());
	}

	public void seeOtherSubmits() {
		submits = scrabble.getSubmits();
		System.out.println(submits.size());
		for(Square square :submits){
		if (square.hasLetterTile()){
			int x = square.getX();
			int y = square.getY();
			int index = (x+1)*16 + (y+1);
//			System.out.println(squa);
			squareButtons[index].setText(square.getLetterTile().getLetter() + "");
		}
		}
		
	}
	
}
