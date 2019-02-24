package codes;



import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;



public class Level2 implements Level{
	
	Platform[] platform=new Platform[6];
	Spikes[] spike=new Spikes[5];
	Door door,door2;
	Chicken chicken;
	Background bg1;
	GameBoard gb;
   
	Coins[] coin=new Coins[40];
	Rectangle platRect;

	private int loop=20,rainTime=5,rainTimer=0,tillRainTime=50,tillRainTimer=0;
	private boolean isAllowedToRain=true;
	
	public static boolean isRaining=false;
	Rectangle coinRect[]=new Rectangle[40];
	
	
	
	public Level2(GameBoard gb) {
		this.gb=gb;
	}
	
	
	
	@Override
	public void init() {
		bg1=new Background(0,0,"images\\background2.png");
		platform[0] = new Platform(-19,92,"images\\platform2.png");
		platform[1] = new Platform(739,252,"images\\platform3.png");
		platform[2]=new Platform(245,392,"images\\boulder2.png");
		platform[3]=new Platform(505,192,"images\\platform5.png");
		platform[4]=new Platform(405,292,"images\\platform6.png");
		platform[5]=new Platform(245,42,"images\\platform7.png");
		spike[0]=new Spikes(80,440,"images\\spike1.png");
		spike[1]=new Spikes(540,340,"images\\spike1.png");
		door=new Door(-6,47,"images\\door2.png");
		door2=new Door(915,247,"images\\door.png");
		chicken=new Chicken(0,72,"images\\chicken_run_short.png");
	
		
		int xCoins=60;
		String path=null;
		
		for(int i=0;i<40;i++){
			
				path="images\\coin.png";
				if(i==0)
					coin[i]=new Coins((xCoins)*(i+1),433,path,true);
				else	
			        coin[i]=new Coins((xCoins-30)*(i+1),433,path,true);
		}
		
		
		if(isAllowedToRain){
			
			if(new Random().nextInt(1000)<1000){
				isRaining=true;
				rainTimer++;
				if(rainTimer>=rainTime){
					isRaining=false;
					rainTimer=0;
					isAllowedToRain=false;
					
				}
			}
		}else if(!isRaining){
			if(new Random().nextInt(1000)<40){
				tillRainTimer++;
				if(tillRainTimer>=tillRainTime){
					isAllowedToRain=true;
					tillRainTimer=0;
				}
			}
			
		}
		
		
	}
	
	
	
	@Override
	public void move(KeyEvent e) {
if(e.getKeyCode()==e.VK_RIGHT){
	
	 		if((chicken.getX()/4)%2==0)
	    			chicken.setImagePath("images//chicken_run_short.png"); 
	    		else if((chicken.getX()/4)%2!=0)
	    			chicken.setImagePath("images//chicken_run_short2.png"); 
	 		
	 		if((chicken.getX()>=120&&chicken.getY()==72)
	 			||(chicken.getX()>=840&&chicken.getX()<=860&&chicken.getY()<=362&&chicken.getY()>=272))
	 			chicken.setX(chicken.getX());
	 		
	 		else if(chicken.getX()>=255&&chicken.getX()<=304){
	 			chicken.setX(chicken.getX()+5);
	 			chicken.setY(chicken.getY()-5);
	 			System.out.println("x:"+chicken.getX()+" y:"+chicken.getY());
	 		}
	 		else if((chicken.getX()>=120&&chicken.getX()<=140&&chicken.getY()<=392)){
	 			chicken.setX(chicken.getX());
	 		}
	 		
	 		else if(chicken.getX()>=440&&chicken.getX()<=489){
	 			chicken.setX(chicken.getX()+5);
	 			chicken.setY(chicken.getY()+5);
	 			System.out.println("x:"+chicken.getX()+" y:"+chicken.getY());
	 		}
	    		
	 		else{
	    		chicken.setX(chicken.getX()+5);
	    		System.out.println("x:"+chicken.getX()+" y:"+chicken.getY());
	 		}
	 		
	if(chicken.getX() ==950){
    			
    			bg1.setImagePath("images//background3.png");
    			chicken.setX(0);
    			chicken.setY(260);
    			GameBoard.level++;
    			System.out.println("ff4. x:"+chicken.getX()+"y:"+chicken.getY());
    			System.out.println("Level Changed");
    		}
	    		
	}//right ends
		
if(e.getKeyCode()==e.VK_LEFT){
			
	if((chicken.getX()/4)%2==0)
		chicken.setImagePath("images//chicken_run_short_left.png"); 
	else if((chicken.getX()/4)%2!=0)
		chicken.setImagePath("images//chicken_run_short2_left.png");
	 		
	 		if(chicken.getX()>=120&&chicken.getY()==72
	 				||(chicken.getX()>=840&&chicken.getX()<=860&&chicken.getY()<=362&&chicken.getY()>=272)
	 				||(chicken.getX()<=845&&chicken.getY()<272)){
	 			chicken.setX(chicken.getX());
	 			
	 		}
	 		else if(chicken.getX()>=255&&chicken.getX()<=304){
	 			chicken.setX(chicken.getX()-5);
	 			chicken.setY(chicken.getY()+5);
	 			System.out.println("x:"+chicken.getX()+" y:"+chicken.getY());
	 		}
	 		
	 		else if(chicken.getX()>=440&&chicken.getX()<=489){
	 			chicken.setX(chicken.getX()-5);
	 			chicken.setY(chicken.getY()-5);
	 			System.out.println("x:"+chicken.getX()+" y:"+chicken.getY());
	 		}
	    		
	 		else{
	    		chicken.setX(chicken.getX()-5);
	    		System.out.println("x:"+chicken.getX()+" y:"+chicken.getY());
	 		}
	    		
	}//left ends
		
		//Chicken Climbs down
	       if(e.getKeyCode()==e.VK_DOWN){
	    	   if((chicken.getY()/10)%2==0)
    	    	   chicken.setImagePath("images\\chickback1.png");
    	    	   else if((chicken.getY()/10)%2!=0)
    	        	   chicken.setImagePath("images\\chickback2.png");
	    	   
	    	   if((chicken.getX()>=100&&chicken.getX()<=120&&chicken.getY()<=392)
	    		  ||(chicken.getX()>=840&&chicken.getX()<=860&&chicken.getY()<=392&&chicken.getY()>=262)){
	    		   chicken.setY(chicken.getY()+10);
	    		   System.out.println("x:"+chicken.getX()+" y:"+chicken.getY());
	    	   }
	       }
	       
	     //Chicken Climbs up
	       if(e.getKeyCode()==e.VK_UP){
	    	   if((chicken.getY()/10)%2==0)
    	    	   chicken.setImagePath("images\\chickback1.png");
    	    	   else if((chicken.getY()/10)%2!=0)
    	        	   chicken.setImagePath("images\\chickback2.png");
	    	   
	    	   if((chicken.getX()>=100&&chicken.getX()<=120&&chicken.getY()<=408&&chicken.getY()>=72)
	 	    		  ||(chicken.getX()>=840&&chicken.getX()<=860&&chicken.getY()<=408&&chicken.getY()>=272)){
	    		   chicken.setY(chicken.getY()-10);
	    		   System.out.println("x:"+chicken.getX()+" y:"+chicken.getY());
	    	   }
	       }
	       if(e.getKeyCode()==e.VK_G){
	    	   chicken.setX(900);
	    	   chicken.setY(262);
	    	   
	       }

		gb.repaint();		
		
	}



	@Override
	public void draw(Graphics g) {
		
		bg1.draw(g);
		
		
		for(int i=0;i<81;i++){
			if(GameBoard.points==i){
				String path="images\\"+i+".png";
				ImageIcon num= new ImageIcon(path);
				g.drawImage(num.getImage(), 443, 6, null);
			}
		}
		
		platform[1].draw(g);
		platform[0].draw(g);
		platform[2].draw(g);
		platform[3].draw(g);
		platform[4].draw(g);
		platform[5].draw(g);
		chicken.draw(g);
		spike[0].draw(g);
		spike[1].draw(g);
		door.draw(g);
		door2.draw(g);
		
		platRect = new Rectangle(platform[2].getX(),platform[2].getY(),300,100);
		
		for(int i=0;i<40;i++){
			coinRect[i]= new Rectangle(coin[i].getX(),coin[i].getY(),20,20);
			eatCoins();
			if(coin[i].isAlive()==true&&platRect.intersects(coinRect[i])==false){
				coin[i].draw(g);
				
			}
		}
		
	
		
		int randw;
		int randh;
		if(isRaining==true){
			for(int i=0;i<loop;i++){
				randw=new Random().nextInt(1000);
				randh=new Random().nextInt(600);
				
				if(randw<1000&&randh<600){
					
					ImageIcon drop=new ImageIcon("images//rain.png");
					g.drawImage(drop.getImage(), randw, randh, null);
				}
			}
		}
	}
	
public void eatCoins(){
		
		Rectangle chickenRect = new Rectangle(chicken.getX(),chicken.getY(),45,47);
		
		for(int i = 0; i < 40; i++){
			
			Rectangle coinRect = new Rectangle(coin[i].getX(),coin[i].getY(),20,20);
			
			if(chickenRect.intersects( coinRect) == true && coin[i].isAlive() == true && (i<7 ||i>=18)){ 
				GameSound.eatEggSound();
				GameBoard.points++;
				coin[i].setAlive(false);
			}
		}
		
		
	}
	
public void spikeCollision(){
		
		Rectangle chickenRect = new Rectangle(chicken.getX(),chicken.getY(),45,47);
		
		for(int i = 0; i < 3; i++){
			
			Rectangle spikeRect = new Rectangle(spike[i].getX(),spike[i].getY(),46,48);
			
			if(chickenRect.intersects( spikeRect) == true){ 
				
				chicken.isAlive=false;
			}
		}
		
		
	}	
	
	
}
