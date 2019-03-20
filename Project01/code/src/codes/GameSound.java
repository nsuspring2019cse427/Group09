	
	package codes;

	import javax.sound.sampled.*;

import java.io.*;

	public class GameSound {

			public static void wildWest(){
				
				try{
					
					File sound = new File("sounds//Wild west.wav");
					AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
					Clip clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}
				catch(Exception e){
					
					
				}
			}
public static void tribal(){
				
				try{
					
					File sound = new File("sounds//tribal.wav");
					AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
					Clip clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}
				catch(Exception e){
					
					
				}
			}
		
public static void windy(){
	
	try{
		
		File sound = new File("sounds//Windy.wav");
		AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
		Clip clip = AudioSystem.getClip();
		clip.open(ais);
		clip.start();
	}
	catch(Exception e){
		
		
	}
}
		
			public static void eatEggSound(){
				
				try{
					
					File sound = new File("sounds//eatghost.wav");
					AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
					Clip clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}
				catch(Exception e){
					
					
				}
			}
			public static void gameOverSound(){
				
				try{
					
					File sound = new File("sounds//gameOver.wav");
					AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
					Clip clip = AudioSystem.getClip();
					clip.open(ais);
					clip.start();
				}
				catch(Exception e){
					
					
				}
			}
		
			
			
	}



