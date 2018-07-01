package com.alevat.spaceinvaders.io;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public enum ImageResource {

    PLAYER_CANNON("player_cannon.png"),
    PLAYER_SHOT("player_shot.png"),
    PLAYER_SHOT_EXPLODING("player_shot_exploding.png"),
    SHIELD("shield.png");

    private final BufferedImage bufferedImage;

    private ImageResource(String imageName) {
        this.bufferedImage = loadImage(imageName);
    }

    private BufferedImage loadImage(String imageName) {
        URL url = getClass().getResource("/sprites/" + imageName);
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            throw new IllegalStateException("Image not found at URL: " + url);
        }
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public BufferedImage copyBufferedImage() {
        ColorModel cm = getBufferedImage().getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = getBufferedImage().copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null)
                .getSubimage(0, 0, getBufferedImage().getWidth(), getBufferedImage().getHeight());
    }

    public int getWidth() {
        return getBufferedImage().getWidth();
    }

    public int getHeight() {
        return getBufferedImage().getHeight();
    }
}
