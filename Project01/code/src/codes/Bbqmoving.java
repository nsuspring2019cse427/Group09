package codes;

import java.awt.Rectangle;

public class Bbqmoving extends Thread{
	
	private GameBoard gb;
	private Bbq bbqMan;

	public Bbqmoving(GameBoard gb, Bbq bbqMan) {
		
		this.gb = gb;
		this.bbqMan = bbqMan;
	}
	
public void run(){
		
		while(bbqMan.getX() > 0){
			
			
			bbqMan.setX(bbqMan.getX() - 1);
		
			
			try {
				Thread.sleep(10);
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
			
			}
			
			
			gb.repaint();
		}
		
		bbqMan.setX(-150);
		
	}


	
}
