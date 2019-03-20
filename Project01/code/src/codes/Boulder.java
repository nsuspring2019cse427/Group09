package codes;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Boulder {
	private int x,y;
	private String imagePath;
	
	
	public Boulder(int x, int y, String imagePath) {
		
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getimagePath() {
		return imagePath;
	}

	public void setimagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
	
	public void draw(Graphics g){
		
		ImageIcon boulder=new ImageIcon(imagePath);
		g.drawImage(boulder.getImage(), x,y,null);
		
	}
	

}
