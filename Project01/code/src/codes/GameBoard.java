package codes;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GameBoard extends JPanel implements KeyListener {


	Boulder boulder;
	Chicken chicken;
	Platform[] platform;
	Spikes[] spikes = new Spikes[3];
	Spikes[] spikes2;
	Island island;
	Door door;
	Coins[] coins1 = new Coins[40];
	static int points = 0;
	static int level = 1;
	Background bg1;
	Level1 l1;
	Level2 l2;
	Level3 l3;
	Level4 l4;

	public GameBoard() {
		l2 = new Level2(this);
		l3 = new Level3(this);
		l4 = new Level4(this);
		if (level == 1) {
			l1 = new Level1(boulder, spikes, island, chicken, bg1, this,
					coins1, door);
			l1.init();
		}
		l2.init();
		l3.init();
		l4.init();
		super.addKeyListener(this);
		super.setFocusable(true);

	}

	public void paint(Graphics g) {

		if (level == 1)
			l1.draw(g);
		else if (l2 != null && level == 2) {
			l2.draw(g);
		} else if (l3 != null && level == 3) {

			l3.draw(g);
		}
	
	
	else if (l4 != null && level == 4) {

		l4.draw(g);
	}

		String l = "level" + level;
		String path = "images\\" + l + ".png";
		ImageIcon lev = new ImageIcon(path);
		g.drawImage(lev.getImage(), 0, 0, null);

		ImageIcon point = new ImageIcon("images\\point.png");
		g.drawImage(point.getImage(), 350, 0, null);

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (level == 1)
			l1.move(e);
		
		if (level == 2) 
			l2.move(e);

		if (level == 3)
			l3.move(e);
		
		if (level == 4)
			l4.move(e);

		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
