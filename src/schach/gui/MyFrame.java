package schach.gui;

import javax.swing.JFrame;

public class MyFrame extends JFrame{

	public MyFrame(){
		this("Schach",null);
	}
	public MyFrame(String title, MyPanel mp){
		this.setTitle(title);
		this.add(mp);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBounds(300, 100, 600, 700);
		this.setResizable(false);
	}
}
