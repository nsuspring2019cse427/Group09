package codes;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;

public class Level4 implements Level {

	Platform[] platform = new Platform[6];
	Spikes[] spike = new Spikes[5];
	Bbq bbqman;
	int bbqCount = 0;
	Door door, door2;
	Chicken chicken;
	private Background bg1;
	GameBoard gb;
	Coins[] coin = new Coins[40];
	Rectangle platRect;

	Rectangle coinRect[] = new Rectangle[40];

	public Level4(GameBoard gb) {
		this.gb = gb;
		
	}

	@Override
	public void init() {
		bg1 = new Background(-300, 0, "images\\background4.png");

		platform[1] = new Platform(320, 400, "images\\slopewood1.png");
		platform[0] = new Platform(525, 356, "images\\monkey.png");
		platform[2] = new Platform(620, 400, "images\\slopewood2.png");
		platform[3] = new Platform(450, 400, "images\\wood1.png");
		platform[4] = new Platform(0, 328, "images\\skate.png");
		platform[5] = new Platform(845, 412, "images\\gold.png");
		spike[0] = new Spikes(80, 440, "images\\spike1.png");
		spike[1] = new Spikes(540, 340, "images\\spike1.png");
		door = new Door(-6, 275, "images\\door2.png");
		door2 = new Door(915, 247, "images\\door.png");
		chicken = new Chicken(0, 280, "images\\chicken_run_short.png");

		int xCoins = 60;
		String path = null;

		for (int i = 3; i < 40; i++) {

			path = "images\\coin.png";
			if (i == 0)
				coin[i] = new Coins((xCoins) * (i + 1), 453, path, true);
			else
				coin[i] = new Coins((xCoins - 30) * (i + 1), 453, path, true);
		}

		for (int i = 0; i < 10; i++) {
			bbqman = new Bbq(900, 445, "images\\bbq.png");
		}

	}

	@Override
	public void move(KeyEvent e) {

		bbqCollision();

		if (e.getKeyCode() == e.VK_RIGHT) {

			platform[4].setX(chicken.getX() - 25);
			platform[4].setY(chicken.getY() + 41);
			door.setX(door.getX() - 1);
			for (int i = 3; i < 40; i++) {
				coin[i].setX(coin[i].getX() - 1);

			}

			if ((chicken.getX() / 4) % 2 == 0)
				chicken.setImagePath("images//chicken_run_short.png");
			else if ((chicken.getX() / 4) % 2 != 0)
				chicken.setImagePath("images//chicken_run_short2.png");

			
			if (chicken.getX() >= 220 && chicken.getX() <= 390
					&& chicken.getY() >= 340) {
				chicken.setX(chicken.getX() + 5);
				chicken.setY(chicken.getY() - 2);
				System.out.println("1. x:" + chicken.getX() + "y:"
						+ chicken.getY());
			}

			else if ((chicken.getX() >= 590 && chicken.getX() <= 755
					&& chicken.getY() >= 335 && chicken.getY() < 414)) {
				chicken.setX(chicken.getX() + 5);
				chicken.setY(chicken.getY() + 2);

				System.out.println("2. x:" + chicken.getX() + "y:"
						+ chicken.getY());
			} 
			
			else if (chicken.getX() >= 10 && chicken.getX() < 140
					&& chicken.getY() < 416) {
				chicken.setX(chicken.getX() + 5);
				chicken.setY(chicken.getY() + 5);
				System.out.println("1. x:" + chicken.getX() + "y:"
						+ chicken.getY());
			}

			else {

				chicken.setX(chicken.getX() + 5);

				System.out.println("3. x:" + chicken.getX() + "y:"
						+ chicken.getY());
			}
			if (chicken.getX() % 50 == 0) {

				Bbqmoving bbqMove = new Bbqmoving(gb, bbqman);
				bbqMove.start();


			}

			if (chicken.getX() == 815) {

				Chicken.end = true;
				
			}

		}// right ends

		if (e.getKeyCode() == e.VK_LEFT) {
			
			platform[4].setX(chicken.getX() - 25);
			platform[4].setY(chicken.getY() + 41);
			door.setX(door.getX() + 1);
			for (int i = 3; i < 40; i++) {
				coin[i].setX(coin[i].getX() + 1);

			}

			if ((chicken.getX() / 4) % 2 == 0)
				chicken.setImagePath("images//chicken_run_short_left.png");
			else if ((chicken.getX() / 4) % 2 != 0)
				chicken.setImagePath("images//chicken_run_short2_left.png");

			if (chicken.getX() >= 220 && chicken.getX() < 440
					&& chicken.getY() <= 414) {
				chicken.setX(chicken.getX() - 5);
				chicken.setY(chicken.getY() + 2);
				System.out.println("1. x:" + chicken.getX() + "y:"
						+ chicken.getY());
			}

			// up
			else if ((chicken.getX() >= 590 && chicken.getX() < 740 && chicken
					.getY() >= 335)) {
				chicken.setX(chicken.getX() - 5);
				chicken.setY(chicken.getY() - 2);

				System.out.println("2. x:" + chicken.getX() + "y:"
						+ chicken.getY());
			} else {
				chicken.setX(chicken.getX() - 5);
				System.out.println("4. x:" + chicken.getX() + "y:"
						+ chicken.getY());
			}

		}// left ends

		// Chicky Climbs down
		if (e.getKeyCode() == e.VK_DOWN) {
			if ((chicken.getY() / 10) % 2 == 0)
				chicken.setImagePath("images\\chickback1.png");
			else if ((chicken.getY() / 10) % 2 != 0)
				chicken.setImagePath("images\\chickback2.png");

			if ((chicken.getX() >= 100 && chicken.getX() <= 120 && chicken
					.getY() <= 392)
					|| (chicken.getX() >= 840 && chicken.getX() <= 860
							&& chicken.getY() <= 392 && chicken.getY() >= 262)) {
				chicken.setY(chicken.getY() + 10);
				System.out.println("5. x:" + chicken.getX() + "y:"
						+ chicken.getY());
			}
		}

		// Chicky Climbs up
		if (e.getKeyCode() == e.VK_UP) {
			if ((chicken.getY() / 10) % 2 == 0)
				chicken.setImagePath("images\\chickback1.png");
			else if ((chicken.getY() / 10) % 2 != 0)
				chicken.setImagePath("images\\chickback2.png");

			if ((chicken.getX() >= 100 && chicken.getX() <= 120 && chicken
					.getY() <= 402)
					|| (chicken.getX() >= 840 && chicken.getX() <= 860
							&& chicken.getY() <= 402 && chicken.getY() >= 272)) {
				chicken.setY(chicken.getY() - 10);
				System.out.println("6. x:" + chicken.getX() + "y:"
						+ chicken.getY());
			}
		}
		if (e.getKeyCode() == e.VK_SPACE) {

			chicken.setX(chicken.getX());
			chicken.setY(chicken.getY());
			gb.repaint();

			ChickenJump jump = new ChickenJump(chicken, gb);
			jump.start();

		}

		gb.repaint();

	}

	@Override
	public void draw(Graphics g) {

		
		bg1.draw(g);

		for (int i = 0; i < 81; i++) {
			if (GameBoard.points == i) {
				String path = "images\\" + i + ".png";
				ImageIcon num = new ImageIcon(path);
				g.drawImage(num.getImage(), 443, 6, null);
			}
		}

		platform[1].draw(g);

		platform[2].draw(g);
		platform[3].draw(g);
		platform[4].draw(g);
		platform[5].draw(g);
		platform[0].draw(g);
		chicken.draw(g);
		

		platRect = new Rectangle(platform[1].getX(), platform[1].getY(), 100,
				70);
		
		bbqman.draw(g);
	}

	public void eatCoins() {

		Rectangle chickenRect = new Rectangle(chicken.getX(), chicken.getY(),
				45, 47);

		for (int i = 3; i < 40; i++) {

			Rectangle coinRect = new Rectangle(coin[i].getX(), coin[i].getY(),
					20, 20);

			if (chickenRect.intersects(coinRect) == true
					&& coin[i].isAlive() == true) {
				GameSound.eatEggSound();
				GameBoard.points++;
				coin[i].setAlive(false);
			}
		}

	}

	public void bbqCollision() {

		Rectangle chickenRect = new Rectangle(chicken.getX(), chicken.getY(),
				45, 47);

		Rectangle bbqRect = new Rectangle(bbqman.getX(), bbqman.getY(), 90, 79);

		if (chickenRect.intersects(bbqRect) == true) {

			chicken.isAlive = false;
		}

	}

}
