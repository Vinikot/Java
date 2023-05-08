package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

	protected float x, y;
	protected int width, height;
	protected Rectangle hitbox;
	
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		initHitbox();
	}
	
	protected void drawHitbox(Graphics g) {
		//Para debugar o hitbox.
		g.setColor(Color.RED);
		g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
	}
	
	private void initHitbox() {
		hitbox = new Rectangle((int) x, (int) y, width, height);
		
	}
	
	protected void updateHitbox() {
		hitbox.x = (int) x;
		hitbox.y =(int) y;
		
	}
	
	public Rectangle getHitbox() {
		return hitbox;
	}

	public abstract void update();

	public abstract void render(Graphics g);
}
