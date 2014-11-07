package schach;

import schach.gui.MyFrame;
import schach.gui.MyPanel;
import schach.model.Figuren;

public class Controller {
	private boolean player1;
	
	public static void main(String [] args) {
		new Controller();
	}
	
	private MyFrame mf;
	private MyPanel mp;
	
	private Schach schach;
	
	public Controller() {
		mp = new MyPanel(this);
		mf = new MyFrame("Schach", mp);
		
		schach = new Schach();
		player1 = true;
		mp.updateFeld(schach.getFeld());		
	}
	
	public void click(int x, int y){
		schach.click(x, y);
		mp.updateFeld(schach.getFeld());
		mp.repaint();
		
		if(schach.getPlayer1() != player1){
			schach.setFeld(rotate(schach.getFeld()));
			player1 =!player1;
			mp.removePosibilities();
		}else{
			if(schach.getFeld()[x][y] != null)
				if(schach.getFeld()[x][y].isWeiss() == player1)
					mp.setPosibilities(schach.getFeld(), x, y);
		}
		mp.updateFeld(schach.getFeld());
		mp.updatePlayerpanel(schach.getPlayer1());
		mp.repaint();
	}
	
	private Figuren[][] rotate(Figuren [][] field) {
		Figuren[][] result = new Figuren[field.length][field[0].length];
		
		for(int i =0; i< field.length; i++) {
			for(int j =0; j < field[i].length; j++) {
				result[j][i] = field[7-j][7-i];
			}
		}
		
		return result;
	}
	
	public void newGame(){
		schach.setupFeld();
		player1 = true;
		mp.updateFeld(schach.getFeld());
		mp.updatePlayerpanel(true);
		mp.removePosibilities();
	}
	
	public void reset(){
		//TODO Reset !!
	}
	
	public void setPosibilities(Figuren[][] feld, int px, int py){
		mp.setPosibilities(feld, px, py);
	}
	
	public void removePosibilities(){
		mp.removePosibilities();
	}
}
