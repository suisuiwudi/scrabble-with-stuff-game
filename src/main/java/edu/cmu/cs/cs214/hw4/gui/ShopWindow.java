package edu.cmu.cs.cs214.hw4.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import edu.cmu.cs.cs214.hw4.core.GameSystem;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.Boom;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.Exchange;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.Negative;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.Reverse;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.SkipTurn;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.SpecialTile;

public class ShopWindow {
	
	private ArrayList<SpecialTile> specialTiles;
	private SpecialTile boom;
	private SpecialTile exchange;
	private SpecialTile negative;
	private SpecialTile reverse;
	private SpecialTile skipTurn;
	private JLabel lable;
	
	
	public ShopWindow(GameSystem game){
		boom = new SpecialTile(new Boom(),game.getCurrentPlayer());
		exchange = new SpecialTile(new Exchange(),game.getCurrentPlayer());
		negative = new SpecialTile(new Negative(),game.getCurrentPlayer());
		reverse = new SpecialTile(new Reverse(),game.getCurrentPlayer());
		skipTurn = new SpecialTile(new SkipTurn(),game.getCurrentPlayer());
		
		specialTiles = new ArrayList<>();
		specialTiles.add(boom);
		specialTiles.add(exchange);
		specialTiles.add(negative);
		specialTiles.add(reverse);
		specialTiles.add(skipTurn);
		
		JFrame frame = new JFrame("Welcome to the shop");
		frame.setSize(400, 200);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		frame.add(panel);
		
		lable = new JLabel("Each item worths 30 pts. Your current points is " + game.getCurrentPlayer().getScore() );
		panel.add(lable);
		
		ButtonGroup group = new ButtonGroup();
		
		ActionListener al = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String itemName = ( (JRadioButton)e.getSource() ).getText();
				for(int i = 0; i < specialTiles.size(); i++){
					if(specialTiles.get(i).getName() == itemName){
						if( !game.getCurrentPlayer().buySpecialTile(specialTiles.get(i))){
							PromptWindow pw = new PromptWindow("You don't have enough points");
						};
						lable.setText("Each item worths 30 pts. Your current points is " + game.getCurrentPlayer().getScore());
						
					}
				}
			}
		};
		
		
		String[] itemNames = {"Boom","Exchange","Negative","Reverse","SkipTurn"};
		for(int i = 0; i< itemNames.length; i++){
			JRadioButton itemButton = new JRadioButton(itemNames[i]);
			itemButton.addActionListener(al);
			group.add(itemButton);
			panel.add(itemButton);
		}
		
			
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		GameSystem game = new GameSystem();
		Player player = new Player("Can Liu");
		game.addPlayer(player);
		game.replenish();
		player.setScore(100);
		ShopWindow sw = new ShopWindow(game);
	}

}
