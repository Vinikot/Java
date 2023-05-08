package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import gamestates.GameState;
import utilz.LoadSave;

import static utilz.Constants.UI.Buttons.*;

public class MenuButton {

	private int xPos, yPos, rowIndex, index;
	private int xOffSetCenter = B_WIDTH / 2;
	private GameState state;
	private BufferedImage[] imgs;
	private boolean mouseOver, mousePressed;
	private Rectangle bounds;
	
	public MenuButton(int xPos, int yPos, int rowIndex, GameState state) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rowIndex = rowIndex;
		this.state = state;
		initBounds();
		loadImgs();
	}

	private void initBounds() {
		bounds = new Rectangle(xPos - xOffSetCenter, yPos, B_WIDTH, B_HEIGHT);
		
	}

	private void loadImgs() {
		imgs = new BufferedImage[3];
		BufferedImage tempImg = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTON_ATLAS);
		for(int i = 0; i < imgs.length; i++)
			imgs[i] = tempImg.getSubimage(i * B_DEFAULT_WIDTH, rowIndex * B_DEFAULT_HEIGHT, B_DEFAULT_WIDTH, B_DEFAULT_HEIGHT);
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(imgs[index], xPos - xOffSetCenter, yPos, B_WIDTH, B_HEIGHT, null);
	}
	
	public void update() {
		index = 0;
		if(mouseOver)
			index = 1;
		if(mousePressed)
			index = 2;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}
	
	public void applyGameState() {
		GameState.state = state;
	}
	
	public void resetBools() {
		mouseOver = false;
		mousePressed = false;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
}
