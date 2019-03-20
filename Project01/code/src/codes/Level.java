package codes;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public interface Level {
	
	public abstract void init();
	public abstract void move(KeyEvent e);
	public abstract void draw(Graphics g);

}
