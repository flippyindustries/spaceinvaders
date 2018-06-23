package com.alevat.spaceinvaders.awt;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;
import javax.swing.*;

import com.alevat.spaceinvaders.game.Screen;
import com.alevat.spaceinvaders.io.Sprite;

class ScreenPanel extends JPanel {

    private final Set<Sprite> sprites = new HashSet<>();

    void initialize() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Screen.WIDTH, Screen.HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    void addSprite(Sprite sprite) {
        sprites.add(sprite);
    }

    void removeSprite(Sprite sprite) {
        sprites.remove(sprite);
    }

    void renderScreen() {
        renderSprites();
        repaint();
    }

    private void renderSprites() {
        for (Sprite sprite : sprites) {
            renderSprite(sprite);
        }
    }

    private void renderSprite(Sprite sprite) {
        BufferedImage bufferedImage = sprite.getImageResource().getBufferedImage();
        int x = getX(sprite);
        int y = getY(sprite);
        getGraphics2D().drawImage(bufferedImage, x, y, null);
    }

    private int getX(Sprite sprite) {
        return sprite.getX();
    }

    private int getY(Sprite sprite) {
        return Screen.HEIGHT - sprite.getY();
    }

    private BufferedImage getBufferedImage(Sprite sprite) {
        return null;
    }

    private Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }
}
