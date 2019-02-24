package codes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameFrame extends JFrame {

		GameBoard board;	
	
		public void makeWindow(){
			
			board = new GameBoard();
			board.setFocusable(true);
			super.add(board);
		super.setTitle("Chicky Mario");
			super.setLocation(250, 100);
			//super.setResizable(false);
			super.setSize(1000, 600);
			super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);
			super.setVisible(true);
	
			while(Chicken.isAlive == true){
			if(Chicken.end==true){
				JOptionPane.showMessageDialog(null, "YOU WON!!!\nPOINTS:"+board.points);
				super.dispose();
					break;
				}
				
			}
			if(Chicken.isAlive != true){
			GameSound.gameOverSound();
			JOptionPane.showMessageDialog(null, "YOU DIED!!!\nPOINTS:"+board.points);
			super.dispose();
			}
			
			
		}
	
		
		
	
}
