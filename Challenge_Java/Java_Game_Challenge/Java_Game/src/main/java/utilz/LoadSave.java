package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static final String PLAYER_ATLAS = "Player_Sprite.png";
	public static final String QUARTO_ATLAS = "Quarto2.0.png";
	public static final String CEL_ICON_ATLAS = "Challenge_Game_Art_Cel_Ani.png";
	public static final String CEL_INTERFACE_ATLAS = "CEL_INTERFACE.png";
	public static final String MENU_BUTTON_ATLAS = "Menu_Buttons.png";
	public static final String MENU_BUTTON_BACKGROUND_BORDER= "Menu_Background_Border.png";

	public static BufferedImage GetSpriteAtlas(String fileName) {
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);

		BufferedImage img = null;
		try {
			img = ImageIO.read(is);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return img;
	}

}
