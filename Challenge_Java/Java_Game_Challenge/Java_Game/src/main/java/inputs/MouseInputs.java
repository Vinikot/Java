package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gamestates.GameState;
import main.GamePanel;

public class MouseInputs implements MouseListener, MouseMotionListener {

	private GamePanel gamePanel;

	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public void mouseClicked(MouseEvent e) {
		switch (GameState.state) {
		case CELULAR:
			this.gamePanel.getGame().getCelular().mouseClicked(e);
			break;
		case MENU:
			this.gamePanel.getGame().getMenu().mouseClicked(e);
			break;
		case PLAYING:
			this.gamePanel.getGame().getPlaying().mouseClicked(e);
			break;
		default:
			break;

		}

	}

	public void mousePressed(MouseEvent e) {
		switch (GameState.state) {
		case CELULAR:
			this.gamePanel.getGame().getCelular().mousePressed(e);
			break;
		case MENU:
			this.gamePanel.getGame().getMenu().mousePressed(e);
			break;
		case PLAYING:
			this.gamePanel.getGame().getPlaying().mousePressed(e);
			break;
		default:
			break;

		}

	}

	public void mouseReleased(MouseEvent e) {
		switch (GameState.state) {
		case CELULAR:
			this.gamePanel.getGame().getCelular().mouseReleased(e);
			break;
		case MENU:
			this.gamePanel.getGame().getMenu().mouseReleased(e);
			break;
		case PLAYING:
			this.gamePanel.getGame().getPlaying().mouseReleased(e);
			break;
		default:
			break;

		}

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		switch (GameState.state) {
		case CELULAR:
			this.gamePanel.getGame().getCelular().mouseMoved(e);
			break;
		case MENU:
			this.gamePanel.getGame().getMenu().mouseMoved(e);
			break;
		case PLAYING:
			this.gamePanel.getGame().getPlaying().mouseMoved(e);
			break;
		default:
			break;

		}

	}

}
