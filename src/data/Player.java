package data;

import static helpers.Artist.DrawQuadTex;
import static helpers.Clock.*;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

public class Player {

	private int width, height;
	private float x, y, speed;
	private Texture texture;
	private boolean alive;
	private Bullet bullet;
	public boolean isShooting = false;
	
	public Player(Texture texture, Bullet bullet, float x, float y, int width, int height) {
		this.texture = texture;
		this.bullet = bullet;
		this.x = x * 64;
		this.y = y * 64;
		this.width = width;
		this.height = height;
		bullet.x = getX() + 23;
		bullet.y = getY() - 50;
	}
	//hi
	public void Draw() {
		DrawQuadTex(texture, x, y, width, height);
	}
	
	public void Update() {
		/*if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			isShooting = true;
			//isShooting = !isShooting;
		} */
		if (paused == false) {
			/*if (isShooting == false) {
				bullet.x = getX() + 23;
				bullet.y = getY() - 50;
			}
			else  {
				Shoot(); 
			} */
			
			if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && isShooting == false) {
				Shoot();
			}
				
			if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				if (y > 100)
					y = y - 2;
				else
					System.out.println("TOO HIGH");
			}
			else if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				if (x > 0)
					x -= 2;
				else
					System.out.println("TOO HIGH");
			}
			else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				if (y < 900)
					y += 2;
				else
					System.out.println("TOO HIGH");
			}
			else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				if (x < 1200)
					x += 2;
				else
					System.out.println("TOO HIGH");
			}	
			if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
				if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
					if (y > 100)
						y = y - 20;
					else
						System.out.println("TOO HIGH");
				}
				else if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
					if (x > 0)
						x = x -20;
					else
						System.out.println("TOO HIGH");
				}
				else if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
					if (y < 900)
						y = y + 20;
					else
						System.out.println("TOO HIGH");
				}
				else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
					if (x < 1200)
						x = x + 20;
					else
						System.out.println("TOO HIGH");
				}
			}		
		}
	}
	
	public void Shoot() {
		isShooting = true;	
		bullet.Draw();
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) { //Fix this to make it so you press space once and bullet goes through full cycle
			bullet.y -= 20;
			System.out.println(bullet.y);
		}
		
		if (bullet.y < 0) {
			bullet.x = getX() + 23;
			bullet.y = getY() - 50; //
		}
		isShooting = false;
	}

	public boolean isShooting() {
		return isShooting;
	}

	public void setShooting(boolean isShooting) {
		this.isShooting = isShooting;
	}

	public Bullet getBullet() {
		return bullet;
	}

	public void setBullet(Bullet bullet) {
		this.bullet = bullet;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}

