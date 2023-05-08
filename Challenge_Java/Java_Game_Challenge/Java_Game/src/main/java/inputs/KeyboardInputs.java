package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.GamePanel;
import entities.Celular;
import gamestates.GameState;

import static utilz.Constants.CelularInterface.*;

public class KeyboardInputs implements KeyListener {

	private GamePanel gamePanel;
	private Celular celular;
	private Game game;

	public KeyboardInputs(GamePanel gamePanel, Celular celular, Game game) {
		this.gamePanel = gamePanel;
		this.celular = celular;
		this.game = game;
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyPressed(KeyEvent e) {
		switch (GameState.state) {
		case CELULAR:
			gamePanel.getGame().getCelular().KeyPressed(e);
			break;
		case MENU:
			gamePanel.getGame().getMenu().KeyPressed(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().KeyPressed(e);
			break;
		default:
			break;

		}
		
		switch (e.getKeyCode()) {

		case KeyEvent.VK_1:
			celular.setCelImgIndex(MAIN_SCREEN);
			game.getPlaying().setInCel(true);
			break;
		case KeyEvent.VK_2:
			celular.setCelImgIndex(IPO_SCREEN);
			game.getPlaying().setInCel(true);
			break;
		case KeyEvent.VK_3:
			celular.setCelImgIndex(IPO_XX_SCREEN);
			game.getPlaying().setInCel(true);
			break;
		case KeyEvent.VK_4:
			celular.setCelImgIndex(IPO_PROSP_SCREEN);
			game.getPlaying().setInCel(true);
			break;
		case KeyEvent.VK_5:
			celular.setCelImgIndex(MERC_DIGITAL_SCREEN);
			game.getPlaying().setInCel(true);
			break;
		case KeyEvent.VK_6:
			celular.setCelImgIndex(PLAYER_ITENS_SCREEN);
			game.getPlaying().setInCel(true);
			break;

		case KeyEvent.VK_ESCAPE:
			if (celular.getCelImgIndex() == PLAYER_ITENS_SCREEN)
				celular.setCelImgIndex(MERC_DIGITAL_SCREEN);
			else if (celular.getCelImgIndex() == MERC_DIGITAL_SCREEN)
				celular.setCelImgIndex(MAIN_SCREEN);
			else if (celular.getCelImgIndex() == IPO_PROSP_SCREEN)
				celular.setCelImgIndex(IPO_XX_SCREEN);
			else if (celular.getCelImgIndex() == IPO_XX_SCREEN)
				celular.setCelImgIndex(IPO_SCREEN);
			else if (celular.getCelImgIndex() == IPO_SCREEN)
				celular.setCelImgIndex(MAIN_SCREEN);
			else
				game.getPlaying().setInCel(false);
			break;
		}

	}

	public void keyReleased(KeyEvent e) {
		switch (GameState.state) {
		case CELULAR:
			gamePanel.getGame().getCelular().KeyReleased(e);
			break;
		case MENU:
			gamePanel.getGame().getMenu().KeyReleased(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().KeyReleased(e);
			break;
		default:
			break;

		}
	}

}
