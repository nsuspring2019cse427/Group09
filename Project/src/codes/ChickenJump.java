package codes;


import java.awt.Rectangle;

//import game.GameBoard;

public class ChickenJump extends Thread {
	
	private Chicken chicken;
	private GameBoard gameboard;

	
	
public ChickenJump(Chicken chicken, GameBoard gameboard) {
		
		this.chicken = chicken;
		this.gameboard = gameboard;
	}



public void run(){
		
	
	double velocity =20, angle = 35, acceleration = -12;
	
	int steps = 50;
	
	double xVelocity = velocity/Math.cos(Math.toRadians(angle));
	double yVelocity = velocity/Math.sin(Math.toRadians(angle));
	
	double totalTime = -2 * yVelocity/acceleration;
	
	double timeIncrement = totalTime/steps;
	double xIncrement = xVelocity * timeIncrement;
	
	double x,y,t;
	
	x = chicken.getX();
	y = chicken.getY();
	int original=chicken.getY();
	t = 0;
	
	for(int i = 0; i <= steps; i++){
		
		t = t + timeIncrement;
		if(chicken.getImagePath().equals("images//chicken_run_short_left.png")||
				chicken.getImagePath().equals("images//chicken_run_short2_left.png")){
		x = x - xIncrement;
		}
		else
			x = x + xIncrement;
		
		y = yVelocity * t + 0.5 * acceleration * t * t;
		
		
		//427
		chicken.setX((int)Math.round(x));
	
		//chicken.setY(427 - (int)Math.round(y));
		//if(chicken.getY()<original-4)
		chicken.setY(original - (int)Math.round(y));
		chicken.setY(chicken.getY()-8);

		
		try {
			Thread.sleep(15);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
		
		}
		
		gameboard.repaint();
	}

}

/*public void checkCollision(){
	
	Rectangle chickenRect = new Rectangle(chicken.getX(),chicken.getY(),8,8);
	
	for(int i = 0; i < ghosts.length; i++){
		
		Rectangle ghostRect = new Rectangle(ghosts[i].getX(),ghosts[i].getY(),32,32);
		
		if(chickenRect.intersects(ghostRect) == true)
		{
			ghosts[i].setAlive(false);
			chicken.setX(-50);
			GameSound.chickenHitSound();
		}	
		
		
	}*/
	
	
	
}




