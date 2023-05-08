package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class LevelManager {
	
	private Game game;
	private BufferedImage levelSprite;
	
	public LevelManager (Game game) {
		this.game = game;
		levelSprite = LoadSave.GetSpriteAtlas(LoadSave.QUARTO_ATLAS);
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(levelSprite.getSubimage(16, 16, 224, 224), 0, 0, (int) (224 * Game.SCALE), (int) (224 * Game.SCALE), null);
	}
	
	public void update() {
		
	}

}
