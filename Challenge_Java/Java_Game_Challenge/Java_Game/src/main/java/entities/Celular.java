package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

import static utilz.Constants.CelularInterface.*;

public class Celular extends Entity {

	private BufferedImage[] animations;
//	private int aniTick, aniIndex, aniSpeed = 60;
	private int celImgIndex = MAIN_SCREEN;

	public Celular(float x, float y, int width, int height) {
		super(x, y, width, height);
		loadAnimations();

	}

	public void update() {

	}

	public void render(Graphics g) {
		g.drawImage(animations[celImgIndex], (int) x, (int) y, width, height, null);
	}

	private void loadAnimations() {

		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.CEL_INTERFACE_ATLAS);
		animations = new BufferedImage[6];

		for (int i = 0; i < animations.length; i++) {
			animations[i] = img.getSubimage(160 * i, 0, 160, 96);

		}
	}

	public void setCelImgIndex(int celImgIndex) {
		this.celImgIndex = celImgIndex;
	}

	public int getCelImgIndex() {
		return celImgIndex;
	}

}
