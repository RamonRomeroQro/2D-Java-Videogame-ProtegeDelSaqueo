//NF

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

    private static BufferedImage spriteSheet;
    private static final int TILE_SIZE_X = 27;
    private static final int TILE_SIZE_Y = 35;

    public static BufferedImage loadSprite(String file) {

        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File("res/" + file + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }

    public static BufferedImage getSprite(int xGrid, int yGrid) {

        if (spriteSheet == null) {
            spriteSheet = loadSprite("AnimationSpriteSheet");
        }

        return spriteSheet.getSubimage(xGrid * TILE_SIZE_X, yGrid * TILE_SIZE_Y, 18, 33);
    }

}
