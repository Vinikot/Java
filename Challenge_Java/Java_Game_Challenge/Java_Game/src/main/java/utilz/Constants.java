package utilz;

import main.Game;

public class Constants {
	
	public static class UI{
		public static class Buttons{
			public static final int B_DEFAULT_WIDTH = 32;
			public static final int B_DEFAULT_HEIGHT = 18;
			public static final int B_WIDTH = (int) (B_DEFAULT_WIDTH * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_DEFAULT_HEIGHT * Game.SCALE);
		}
	}

	public static class CelularIconConstants {
		public static final int IDLE = 0;
		public static final int PISCANDO = 1;

		public static int GetSpriteAmount(int celular_state) {
			switch (celular_state) {
			case IDLE:
				return 1;
			case PISCANDO:
				return 6;
			default:
				return 1;
			}
		}
	}

	public static class CelularInterface {
		public static final int MAIN_SCREEN = 0;
		public static final int IPO_SCREEN = 1;
		public static final int IPO_XX_SCREEN = 2;
		public static final int IPO_PROSP_SCREEN = 3;
		public static final int MERC_DIGITAL_SCREEN = 4;
		public static final int PLAYER_ITENS_SCREEN = 5;
		
	}

	public static class PlayerConstants {
		public static final int IDLE = 0;
		
		public static final double PLAYER_SALDO_INICIAL = 6700;

		public static int GetSpriteAmount(int playerAction) {
			switch (playerAction) {
			case IDLE:
				return 5;
			default:
				return 1;
			}
		}
	}
}
