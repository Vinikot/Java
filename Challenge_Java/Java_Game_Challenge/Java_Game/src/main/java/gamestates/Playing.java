package gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.Celular;
import entities.Player;
import levels.LevelManager;
import main.Game;

public class Playing extends State implements Statemethods{

	private Player player;
	private LevelManager levelManager;
	private Celular celular;
	private boolean inCel = false;

	public Playing(Game game) {
		super(game);

		initClasses();
	}

	private void initClasses() {
		player = new Player((int) (104 * Game.SCALE), (int) (96 * Game.SCALE), (int) (32 * Game.SCALE), (int) (32 * Game.SCALE));
		celular = new Celular((int) (48 * Game.SCALE), (int) (32 * Game.SCALE), (int) (160 * Game.SCALE), (int) (96 * Game.SCALE));
		levelManager = new LevelManager(game);
	}

	public boolean isInCel() {
		return inCel;
	}

	public void setInCel(boolean inCel) {
		this.inCel = inCel;
	}

	public Celular getCelular() {
		return celular;
	}

	public void setCelular(Celular celular) {
		this.celular = celular;
	}

	public void update() {
		levelManager.update();
		player.update();
	}

	public void draw(Graphics g) {
		levelManager.draw(g);
		player.render(g);
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void KeyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			GameState.state = GameState.MENU;
		
	}

	public void KeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public Player getPlayer() {
		return player;
	}

}
