package schach;

import javax.swing.JOptionPane;

import schach.gui.MyFrame;
import schach.gui.MyPanel;
import schach.model.Bauer;
import schach.model.Figuren;
import schach.model.Koenig;
import schach.model.Koenigin;
import schach.model.Laufer;
import schach.model.Springer;
import schach.model.Turm;

public class Schach {
	private static Schach schach;
	private Figuren[][] feld= new Figuren[8][8];
	private boolean player1 = true;
	public Figuren f;
	public boolean firstclick = true;
	public Schach(){
		Schach.schach = this;
		setupFeld();
	}
	
	public void setupFeld(){
		feld= new Figuren[8][8];	
		
		feld[0][0] = new Turm(false); 
		feld[0][7] = new Turm(false);
		
		feld[7][0] = new Turm(); 
		feld[7][7] = new Turm();
		
		feld[0][1] = new Springer(false); 
		feld[0][6] = new Springer(false);
		
		feld[7][1] = new Springer(); 
		feld[7][6] = new Springer();
		
		feld[0][2] = new Laufer(false); 
		feld[0][5] = new Laufer(false);
		
		feld[7][2] = new Laufer(); 
		feld[7][5] = new Laufer();
		
		feld[0][3] = new Koenigin(false); 
		feld[0][4] = new Koenig(false);
		
		feld[7][3] = new Koenigin(); 
		feld[7][4] = new Koenig();
		
		for(int i = 0; i < 8;i++){
			feld[1][i] = new Bauer(false);
			feld[6][i] = new Bauer(); 
		}
		
		player1 = true;
		f = null;
		firstclick = true;
	}
	
	public Figuren[][] getFeld(){
		return feld;
	}
	public void setFeld(Figuren[][] feld){
		this.feld = feld;
	}
	public boolean getPlayer1(){
		return player1;
	}
	public void click(int x, int y){
		if(firstclick){
			MyPanel.removePosibilities();
			f = feld[x][y];
			if(f != null){
				if(f.isWeiss() == player1){
					f.move(x, y);
					firstclick = false;
				}else
					System.out.println("Falsche Figur!");
			}else
				System.out.println("Keine Figur!");
		}else{
//			MyPanel.removePosibilities();
			boolean b = f.move(x, y, feld);
			if(b){
				feld[f.getXStart()][f.getYStart()]=null;
				feld[x][y]=f;
				
				if((x == 0) && (feld[x][y] instanceof Bauer)){
					Figuren[] possibilities = {new Koenigin(feld[x][y].isWeiss()), new Turm(feld[x][y].isWeiss()), new Laufer(feld[x][y].isWeiss()),new Springer(feld[x][y].isWeiss())};
					feld[x][y] = (Figuren)JOptionPane.showInputDialog(
					                    null,
					                    "Was soll Bauer werden :) :",
					                    "Befoerderung",
					                    JOptionPane.PLAIN_MESSAGE,
					                    null,
					                    possibilities,
					                    possibilities[0]);
				}
				
				firstclick=true;
				player1=!player1;
			}else{
				firstclick = true;
				System.out.println("Falscher Zug!");
				MyPanel.removePosibilities();
			}
		}
	}
	
	public boolean underattack(int x, int y, boolean weiss){
		for(int ix = 0; ix < 8;ix++){
			for(int iy = 0; iy < 8; iy++){
				if(feld[ix][iy] != null){
					if(feld[ix][iy].isWeiss() != weiss){
						if(feld[ix][iy].move(ix, iy, x, y, feld)){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public static boolean isunderattack(int x, int y, boolean weiss){
		return schach.underattack(x, y, weiss);
	}
}
