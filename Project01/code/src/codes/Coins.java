package codes;


import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Coins {

	private int x,y;
	private String imagePath;
	private boolean isAlive;
	public static int num=0;
	public Coins(int x, int y, String imagePath, boolean isAlive) {
		super();
		this.x = x;
		this.y = y;
		this.imagePath = imagePath;
		this.isAlive = isAlive;
		num++;
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
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public void draw(Graphics g){
		
		ImageIcon egg=new ImageIcon(imagePath);
		g.drawImage(egg.getImage(),x,y,null);
	}
	

	
}
