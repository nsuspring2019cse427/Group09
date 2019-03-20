package codes;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Level1 implements Level{
	
	
	private Boulder boulder;
	private Spikes[] spikes;
	private Island island;
	private Chicken chicken;
	private Background bg1;
	GameBoard gb;
	Coins[] coins1=new Coins[40];
	Door door;
	Rectangle coinRect[]=new Rectangle[40];
	

	public Level1(Boulder boulder, Spikes[] spikes, Island island,
			Chicken chicken, Background background, GameBoard gb, Coins[] coins1,Door door) {
		GameSound.tribal();
		this.boulder = boulder;
		this.spikes = spikes;
		this.island = island;
		this.chicken = chicken;
		this.bg1 = background;
		this.gb = gb;
		this.coins1 = coins1;
		this.door=door;
	}

	public Background getBackground() {
		return bg1;
	}

	public void setBackground(Background background) {
		this.bg1 = background;
	}

	public Boulder getBoulder() {
		return boulder;
	}

	public void setBoulder(Boulder boulder) {
		this.boulder = boulder;
	}

	public Spikes[] getSpikes() {
		return spikes;
	}

	public void setSpikes(Spikes[] spikes) {
		this.spikes = spikes;
	}

	public Island getIsland() {
		return island;
	}

	public void setIsland(Island island) {
		this.island = island;
	}

	public Chicken getChicken() {
		return chicken;
	}

	public void setChicken(Chicken chicken) {
		this.chicken = chicken;
	}
	
	public void init(){
		
		
		boulder=new Boulder(250,434,"images\\boulder.png");
		bg1 = new Background(0,0,"images\\background1.png");
		
		
		for(int i=0;i<3;i++){
			
			spikes[i]=new Spikes(120+((i+1)*300),446,"images\\spikes.png");
			
		}
		
		int xCoins=60;
		String path=null;
		
		for(int i=0;i<40;i++){
			
				path="images\\coin.png";
				if(i==0)
					coins1[i]=new Coins((xCoins)*(i+1),458,path,true);
				else	
			        coins1[i]=new Coins((xCoins-30)*(i+1),458,path,true);
		}
		
		chicken=new Chicken(0,432,"images\\chicken_run_short.png");
			
		island=new Island(510,0,"images\\island.png");
		door=new Door(914,117,"images\\door.png");
		
	}
	
	public void draw(Graphics g){
		
		bg1.draw(g);
		
		for(int i=0;i<80;i++){
			if(GameBoard.points==i){
				String path="images\\"+i+".png";
				ImageIcon num= new ImageIcon(path);
				g.drawImage(num.getImage(), 443, 6, null);
			}
		}
		
		
		boulder.draw(g);
		for(int i=0;i<3;i++){
			spikes[i].draw(g);
		}
		island.draw(g);

		
		for(int i=0;i<40;i++){
		coinRect[i] = new Rectangle(coins1[i].getX(),coins1[i].getY(),20,20);
			}
		
		Rectangle bouldRect=new Rectangle(boulder.getX(),boulder.getY(),332,79);
		
		chicken.draw(g);
		for(int i=0;i<40;i++){
			for(int j=0;j<3;j++){
			eatCoins();
			if(coins1[i].isAlive()==true){
			Rectangle spikeRect = new Rectangle(spikes[j].getX(),spikes[j].getY(),52,30);
				if(coinRect[i].intersects(bouldRect)==false&&coinRect[i].intersects(spikeRect)==false){
					coins1[i].draw(g);
					
					}
				}
			}
		}
		door.draw(g);
	}
	
	
	public void move(KeyEvent e){
     spikeCollision();
		
		
	    if(e.getKeyCode()==e.VK_RIGHT){
	    	
	    		
	    		if((chicken.getX()/4)%2==0)
	    			chicken.setImagePath("images//chicken_run_short.png"); 
	    		else if((chicken.getX()/4)%2!=0)
	    			chicken.setImagePath("images//chicken_run_short2.png"); 
	    		
	    		//Chicken moving up the boulder
	    		if(chicken.getX()>=220&&chicken.getX()<420&&chicken.getY()>393){
	    			chicken.setX(chicken.getX()+5);
	    			chicken.setY(chicken.getY()-5);
	    			System.out.println("x:"+chicken.getX()+"y:"+chicken.getY());
	    		}
	    		//Chicken moving down the boulder
	    		else if(chicken.getX()>=476&&chicken.getX()<555&&chicken.getY()<432){
	    			chicken.setX(chicken.getX()+5);
	    			chicken.setY(chicken.getY()+3);
	    			System.out.println("x:"+chicken.getX()+"y:"+chicken.getY());
	    		}
	    		//Making the chicken walk on the boulder
	    		else if(chicken.getY()==362&&chicken.getX()<400){
	    			chicken.setX(chicken.getX()+5);
	 	    		}
	    		//Restricting right/left movement while climbing
	    		else if(((chicken.getX()<=795)&&(chicken.getX()>=765)&&((chicken.getY()<422)&&chicken.getY()>133))||(chicken.getY()==362&&chicken.getX()>=400)){
	    				    				chicken.setX(chicken.getX());
	    			
	    		}
	    		else{
	    		chicken.setX(chicken.getX()+5);
	    		
	    		if(chicken.getX()>=939&&chicken.getY()==131){
	    			Chicken.end=true;
	    			}
	    		}
	    	
	    
	    		if(chicken.getX() ==950){
	    			
	    			bg1.setImagePath("images//background2.png");
	    			chicken.setX(0);
	    			chicken.setY(430);
	    			GameBoard.level++;
	    			System.out.println("ff4. x:"+chicken.getX()+"y:"+chicken.getY());
	    			System.out.println("Level Changed");
	    		}
	    }
	    
	    else if(e.getKeyCode()==e.VK_G){
	    	   chicken.setX(895);
	    	   chicken.setY(134);
	       }
	    
       if(e.getKeyCode()==e.VK_LEFT){
	
	    	if(chicken.getX()>0){
	    		if((chicken.getX()/4)%2==0)
	    			chicken.setImagePath("images//chicken_run_short_left.png"); 
	    		else if((chicken.getX()/4)%2!=0)
	    			chicken.setImagePath("images//chicken_run_short2_left.png");
	    		
	    		//Chicken walking up the boulder from left
	    		if(chicken.getX()<=560&&chicken.getX()>=485&&chicken.getY()>391){
	    			chicken.setX(chicken.getX()-5);
	    			chicken.setY(chicken.getY()-3);	
	    		}
	    		
	    		//Chicken walking down the boulder from left
	    		else if(chicken.getX()<=270&&chicken.getX()>=223&&chicken.getY()<427){
	    			chicken.setX(chicken.getX()-5);
	    			chicken.setY(chicken.getY()+5);
	    	     }
	    		
	    	else if((chicken.getX()<=765)&&(chicken.getX()>=735)&&(chicken.getY()<422)){
	    			    				chicken.setX(chicken.getX());
	   	    		}
	    		else
	    		chicken.setX(chicken.getX()-5);
	    		System.out.println("x:"+chicken.getX()+"y:"+chicken.getY());
	    	}
	    	
	    }
       if(e.getKeyCode()==e.VK_SPACE){
    	   
    	   chicken.setX(chicken.getX());
    	   chicken.setY(chicken.getY());
    	   gb.repaint();
    	   
    	   ChickenJump jump = new ChickenJump(chicken,gb);
		   jump.start();
	    	
	    }
       
       if(e.getKeyCode()==e.VK_UP){
  	   //Chicken climbs
    	   if((chicken.getY()>135&&(chicken.getX()<=795)&&(chicken.getX()>=765))){
    		   if((chicken.getY()/10)%2==0)
    	    	   chicken.setImagePath("images\\chickback1.png");
    	    	   else if((chicken.getY()/10)%2!=0)
    	        	   chicken.setImagePath("images\\chickback2.png");
    		   chicken.setY(chicken.getY()-10);
    		   //System.out.println(chicken.getY());
    	   }
       }
       
       //Chicken Climbs down
       if(e.getKeyCode()==e.VK_DOWN){
      	   
    	   if(chicken.getY()<429&&(chicken.getX()<=795)&&(chicken.getX()>=765)){
    		   if((chicken.getY()/10)%2==0)
    	    	   chicken.setImagePath("images\\chickback1.png");
    	    	   else if((chicken.getY()/10)%2!=0)
    	        	   chicken.setImagePath("images\\chickback2.png");
    		   chicken.setY(chicken.getY()+10);
    	   }
       }
	
	gb.repaint();	
	}
	
	
	
public void eatCoins(){
		
		Rectangle chickenRect = new Rectangle(chicken.getX(),chicken.getY(),45,47);
		
		for(int i = 0; i < 40; i++){
			
			Rectangle coinRect = new Rectangle(coins1[i].getX(),coins1[i].getY(),20,20);
			
			if(chickenRect.intersects( coinRect) == true && coins1[i].isAlive() == true){
				GameSound.eatEggSound();
				GameBoard.points++;
				coins1[i].setAlive(false);
			}
		}
		
		
	}
	
public void spikeCollision(){
		
		Rectangle chickenRect = new Rectangle(chicken.getX(),chicken.getY(),45,47);
		
		for(int i = 0; i < 3; i++){
			
			Rectangle spikeRect = new Rectangle(spikes[i].getX(),spikes[i].getY(),52,30);
			
			if(chickenRect.intersects( spikeRect) == true){ 
				
				chicken.isAlive=false;
			}
		}
		
		
	}

}
