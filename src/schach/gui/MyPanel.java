package schach.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import schach.Controller;
import schach.model.Figuren;

public class MyPanel extends JPanel{
	private static JButton[][] field = new JButton[8][8];
	private Controller controller;
	private JLabel label= new JLabel(), p1sc = new JLabel("Player 1: 0"), p2sc = new JLabel("Player 2: 0");
	private JButton reset = new JButton("Reset"), newgame = new JButton("Neues Spiel");
	
	public MyPanel(Controller c){
		this.controller = c;
		this.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout( 8, 8,5,5));
		
		for(int i = 0; i <8 ; i++)
			for(int ii = 0; ii < 8 ; ii++){
				field[i][ii] = new JButton();
				p1.add(field[i][ii]);
				field[i][ii].setFont(new Font("Arial", Font.PLAIN, 60));
				field[i][ii].setFocusable(false);
				field[i][ii].setOpaque(true);
				if((i+ii)%2==0)
					field[i][ii].setBackground(Color.WHITE);
				else
					field[i][ii].setBackground(Color.BLACK);
				field[i][ii].setBorderPainted(false);
				field[i][ii].setBorder(BorderFactory.createLineBorder(Color.GREEN));
				field[i][ii].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for(int x = 0 ; x< 8; x++)
							for(int y = 0; y < 8; y++)
								if(e.getSource().equals(field[x][y])){
									controller.click(x, y);
									break;
								}
					}
				});
			}
		
		
		JPanel p2 = new JPanel(new BorderLayout());
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		label.setText("Player 1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(label,BorderLayout.SOUTH);
		
		p1sc.setFont(new Font("Arial", Font.PLAIN, 20));
		p2sc.setFont(new Font("Arial", Font.PLAIN, 20));
		
		p1sc.setHorizontalAlignment(SwingConstants.CENTER);
		p2sc.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel p2_2 = new JPanel(new GridLayout(1,2));
		p2_2.add(p1sc);
		p2_2.add(p2sc);
		p2.add(p2_2,BorderLayout.NORTH);
		
		newgame.setFocusable(false);
		reset.setFocusable(false);
		
		JPanel p3 = new JPanel(new GridLayout(1, 2));
		p3.add(newgame);
		p3.add(reset);
		
		this.add(p3, BorderLayout.SOUTH);
		this.add(p1, BorderLayout.CENTER);
		this.add(p2,BorderLayout.NORTH);
		
		newgame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.newGame();
			}
		});
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.reset();
			}
		});
	}
	
	public void updateFeld(Figuren[][] feld){
		for(int x = 0; x < 8; x ++){
			for(int y = 0; y < 8 ; y++){
				if(feld[x][y] == null)
					this.field[x][y].setIcon(null);
				else{
					//System.out.println(feld[x][y].getImagePath());
					this.field[x][y].setIcon(new ImageIcon(getClass().getResource(feld[x][y].getImagePath()+".png")));
					//System.out.println(feld[x][y].getImagePath());
				}
			}
		}
	}
	
	public void updatePlayerpanel(boolean player1){
		label.setText("Player " + (player1?"1":"2"));
	}
	
	public void setPosibilities(Figuren[][] feld, int px, int py){
		Figuren f = feld[px][py];
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8 ; y++){
				if(f.move(px, py, x, y, feld)){
					field[x][y].setBorderPainted(true);
				}
			}
		}
	}
	
	public static void removePosibilities(){
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8 ; y++){
				field[x][y].setBorderPainted(false);
			}
		}
	}
}
