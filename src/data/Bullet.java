package data;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;
import static helpers.Clock.paused;

public class Bullet {
	
	private int width, height;
	public float x, y;
	private Texture texture;
	
	public Bullet(float x, float y, int width, int height) {
		
		this.texture = QuickLoad("bullet"); 
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
}
