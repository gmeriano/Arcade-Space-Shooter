package data;

import static helpers.Artist.DrawQuadTex;
import static helpers.Clock.*;

import java.util.Random;

import org.newdawn.slick.opengl.Texture;

public class Enemy {
	
	private int  width, height, health;
	private float speed, x, y;
	private Texture texture;
	private boolean first = true, alive = true;
	Random rn = new Random();
	int randXCoord = rn.nextInt(20 * 64);
	int randSpeed = rn.nextInt(5);
	Player p;
	public int id;

	int deaths = 0;

	public Enemy(Texture texture, float x, float y, int width, int height, float speed) {
		this.texture = texture;
		this.x = randXCoord;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	public void Update() {
		if (first)
			first = false;
		else
			y += Delta() * speed;
			x+= Delta() * randSpeed;
	}
	
	public void Die() {
		alive = false;
		deaths++;
	}
	
	public void Draw() {
		DrawQuadTex(texture, x, y, width, height);
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
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

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
	public boolean isAlive() {
		return alive;
	}	

}
