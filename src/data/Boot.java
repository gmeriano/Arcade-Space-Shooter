package data;

import static helpers.Artist.*;
import helpers.Clock;
import static data.Enemy.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import java.util.Random;

public class Boot {
	
	int id = 0;
	
	public Boot() {
		
		BeginSession();	
		
		int[][] map = {
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
		};
		Random rn = new Random();
		int randXCoord = rn.nextInt(20);
		
		TileGrid grid = new TileGrid(map);
		
		Bullet bullet = new Bullet(10, 10, 15, 15);
		Player ship = new Player(QuickLoad("ship"), bullet, 9, 13, 64, 64);
		
		Enemy e = new Enemy(QuickLoad("enemy"), randXCoord, 0, 64, 64, 20);
		Wave wave = new Wave (5, e);
		
		int score = 0;
		while(!Display.isCloseRequested()) {     
			
			Clock.update();
			
			grid.Draw();
			ship.Draw();
			
			ship.Update();
			wave.Update(ship);
		
			Display.update();
			Display.sync(60);
			
			if (Clock.gameOver == true) {
				Clock.paused = true;
				break;
				}
			score++;
			}
		System.out.println("GAME OVER!    Your Score is: " + score + " Points!");
	}

	public static void main(String[] args) {
		new Boot();
	}
}

