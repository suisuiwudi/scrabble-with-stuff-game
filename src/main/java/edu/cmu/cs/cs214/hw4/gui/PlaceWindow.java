package edu.cmu.cs.cs214.hw4.gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.cmu.cs.cs214.hw4.core.GameSystem;
import edu.cmu.cs.cs214.hw4.core.LetterTile;
import edu.cmu.cs.cs214.hw4.core.Move;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.Square;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.SpecialTile;

public class PlaceWindow {
	Scrabble scrabble;
	Player player;
	ArrayList<Square> submits;
	
	/**
	 * The player is going to d this square;
	 */
	
	Square square;
	/**
	 * Current Player's letterTiles in hand
	 */
	ArrayList<LetterTile> letterTiles;
	
	
	
	/**
	 * The player's specialTiles in hand.
	 */
	ArrayList<SpecialTile> specialTiles;
	
	/**
	 * The player is going to place this special Tile.
	 */
	
	ArrayList<JRadioButton> letterButtons = new ArrayList<JRadioButton>();
	ArrayList<JRadioButton> specialTileButtons = new ArrayList<JRadioButton>();
	
	JFrame frame;
	JPanel panel;
	ButtonGroup group;
	JPanel letterArea;
	GameSystem game;
	JPanel specialTileArea;
	JPanel submitArea;
	JButton submitButton;
	//TODO
	
	public PlaceWindow(Scrabble scrabble) {
		this.scrabble = scrabble;
		this.game = scrabble.getGameSystem();
		this.player = game.getCurrentPlayer();
		
		this.submits = scrabble.getSubmits();
		square =new Square(scrabble.getPlaceX(),scrabble.getPlaceY());
		
		frame = new JFrame("Place Window");
		frame.setSize(500,200);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		initLetterChoise();
		initSpecialTileChoise();
		initSubmit();
		
		frame.add(panel);
		frame.setVisible(true);
	}
	

	private void initSubmit() {
		submitArea = new JPanel();
		submitButton = new JButton("SUBMIT");
		//TODO
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boolean occupiedFlag = false;
				if (square.hasLetterTile()){
					for(Square preSquare:submits){
						if(preSquare.hasLetterTile()){
							if(!(preSquare.getX() != square.getX() || preSquare.getY() != square.getY())){
								occupiedFlag = true;
								scrabble.newPromptWindow("THIS SQUARE HAS ALREADY BEEN SUBMITTED");
							}
						}
					}
					if (!occupiedFlag) {
						submits.add(square);
						scrabble.setSubmits(submits);
					}
				}
				if (square.hasSpecialTile()){
					submits.add(square);
					scrabble.setSubmits(submits);
				}
				scrabble.seeSubmits();
				frame.dispose();
			}
		});
		
	
		submitArea.add(submitButton);
		panel.add(submitArea, BorderLayout.SOUTH);
	}


	private void initSpecialTileChoise() {
		//TODO
		this.specialTiles = player.getSpecialTile();
		group = new ButtonGroup();
		ActionListener al =new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				JRadioButton tmp = (JRadioButton)ae.getSource();
				for(int i = 0;i <specialTileButtons.size();i++){
					if(tmp == specialTileButtons.get(i)){
						square.unsetSpecialTile();
						square.setSpecialTile(specialTiles.get(i));
						System.out.println("getspecial");
						break;
					}
				}
			}

		};
		specialTileArea = new JPanel();
		specialTileArea.setLayout(new FlowLayout());
		
		for(SpecialTile s:specialTiles){
			JRadioButton radio = new JRadioButton(s.getName());
			specialTileButtons.add(radio);
			radio.addActionListener(al);
			specialTileArea.add(radio);
			group.add(radio);
		}
		
		panel.add(specialTileArea, BorderLayout.NORTH);
		
	}

	private void initLetterChoise(){
		//TODO
		this.letterTiles = player.getLetters();
		group = new ButtonGroup();
		letterTiles = scrabble.getGameSystem().getCurrentPlayer().getLetters();
		
		ActionListener al =new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				JRadioButton tmp = (JRadioButton)ae.getSource();
				
				for(int i = 0;i <letterButtons.size();i++){
					if(tmp == letterButtons.get(i)){
						square.setLetterTile(letterTiles.get(i));
						
						break;
					}
				}
				
			}

		};
		letterArea = new JPanel();
		letterArea.setLayout(new FlowLayout());
		
		for(LetterTile l : letterTiles){
			JRadioButton radio =new JRadioButton(l.getLetter()+"");
			letterButtons.add(radio);
			radio.addActionListener(al);
			letterArea.add(radio);
			group.add(radio);
		}
		panel.add(letterArea, BorderLayout.CENTER);
		
	}
	
//	public Square getSquare(){
//		return this.square;
//	}
	

}
