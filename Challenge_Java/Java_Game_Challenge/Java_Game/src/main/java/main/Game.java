package main;

import java.awt.Graphics;

import gamestates.Celular;
import gamestates.GameState;
import gamestates.Menu;
import gamestates.Playing;

public class Game implements Runnable {
	
	private Playing playing;
	private Menu menu;
	private Celular celular;

	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;

	public final static int DEFAULT_TILES_SIZE = 16;
	public final static float SCALE = 3.5f;
	public final static int TILES_IN_WIDTH = 14;
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int) (DEFAULT_TILES_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_IN_WIDTH * TILES_SIZE;
	public final static int GAME_HEIGHT = TILES_IN_HEIGHT * TILES_SIZE;

	public Game() {
		initClasses();

		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.setFocusable(true);
		gamePanel.requestFocus();

		startGameLoop();
	}

	private void initClasses() {
		menu = new Menu(this);
		playing = new Playing(this);
		celular = new Celular(this);
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void update() {
		switch (GameState.state) {
		case MENU:
			menu.update();
			break;
		case PLAYING:
			playing.update();
			break;
		case CELULAR:
			celular.update();
			break;
		case QUIT:
		default:
			System.exit(0);
			break;

		}
	}

	public void render(Graphics g) {
		switch (GameState.state) {
		case MENU:
			menu.draw(g);
			break;
		case PLAYING:
			playing.draw(g);
			
			break;
		case CELULAR:
			celular.draw(g);
			break;
		default:
			break;

		}

	}

	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long previousTime = System.nanoTime();

		int frame = 0;
		int update = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {

			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			// Confere o momento de fazer um novo Update.
			if (deltaU >= 1) {
				update();
				update++;
				deltaU--;
			}

			// Confere o momento de desenhar um novo Frame.
			if (deltaF >= 1) {
				gamePanel.repaint();
				frame++;
				deltaF--;
			}

			// Faz a contagem de Frames e Updates por segundo (FPS | UPS).
			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frame + " | UPS: " + update);
				update = 0;
				frame = 0;
			}

		}

	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public Playing getPlaying() {
		return playing;
	}
	
	public Celular getCelular() {
		return celular;
	}

}
