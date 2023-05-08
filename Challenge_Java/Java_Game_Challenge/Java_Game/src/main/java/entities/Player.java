package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.Game;
import utilz.LoadSave;

import static utilz.Constants.PlayerConstants.*;

public class Player extends Entity {

	private BufferedImage[] animations;
	private int aniTick, aniIndex, aniSpeed = 60;
	private int playerAction = IDLE;
	
	private double saldo = PLAYER_SALDO_INICIAL;

	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);
		loadAnimations();

	}

	public void update() {
		updateHitbox();
		updateAnimationTick();
	}

	public void render(Graphics g) {
		g.drawImage(animations[aniIndex], (int) x, (int) y, width, height , null);
//		drawHitbox(g);
	}

	public void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(playerAction))
				aniIndex = 0;
		}
	}

	private void loadAnimations() {

		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
		animations = new BufferedImage[5];

		for (int i = 0; i < animations.length; i++) {
			animations[i] = img.getSubimage(i * 32, 0, 32, 32);

		}
	}

}
