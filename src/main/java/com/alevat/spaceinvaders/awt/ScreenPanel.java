package com.alevat.spaceinvaders.awt;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.*;

import com.alevat.spaceinvaders.game.Screen;
import com.alevat.spaceinvaders.io.ImageResource;
import com.alevat.spaceinvaders.io.Sprite;

import static java.awt.Image.SCALE_SMOOTH;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

class ScreenPanel extends JPanel {

    private final static int SCREEN_SIZE_MULTIPLIER = 4;
    private final static int PANEL_WIDTH = SCREEN_SIZE_MULTIPLIER * Screen.WIDTH;
    private final static int PANEL_HEIGHT = SCREEN_SIZE_MULTIPLIER * Screen.HEIGHT;
    private final BufferedImage screenImage = new BufferedImage(PANEL_WIDTH, PANEL_HEIGHT, TYPE_INT_RGB);
    private final Graphics2D graphics2D = (Graphics2D) screenImage.getGraphics();
    private final Set<Sprite> sprites = new HashSet<>();
    private final Map<ImageResource, BufferedImage> resizedImageMap = new HashMap<>();

    void initialize() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
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
        renderScreenImage();
        repaint();
    }

    private void renderScreenImage() {
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        renderSprites(graphics2D);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(screenImage, 0, 0, null);
    }

    private void renderSprites(Graphics2D graphics2D) {
        for (Sprite sprite : sprites) {
            renderSprite(sprite, graphics2D);
        }
    }

    private void renderSprite(Sprite sprite, Graphics2D graphics2D) {
        BufferedImage bufferedImage = getBufferedImage(sprite);
        int x = getX(sprite);
        int y = getY(sprite);
        graphics2D.drawImage(bufferedImage, x, y, null);
    }

    private BufferedImage getBufferedImage(Sprite sprite) {
        ImageResource imageResource = sprite.getImageResource();
        BufferedImage resizedImage = resizedImageMap.get(imageResource);
        if (resizedImage == null) {
            resizedImage = getResizedBufferedImage(imageResource);
            resizedImageMap.put(imageResource, resizedImage);
        }
        return resizedImage;
    }

    private BufferedImage getResizedBufferedImage(ImageResource imageResource) {
        BufferedImage originalImage = imageResource.getBufferedImage();
        int desiredWidth = SCREEN_SIZE_MULTIPLIER * originalImage.getWidth();
        int desiredHeight = SCREEN_SIZE_MULTIPLIER * originalImage.getHeight();
        Image tempResizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = resizedImage.getGraphics();
        graphics.drawImage(tempResizedImage, 0, 0, null);
        return resizedImage;
    }

    private int getX(Sprite sprite) {
        return sprite.getX() * SCREEN_SIZE_MULTIPLIER;
    }

    private int getY(Sprite sprite) {
        return (Screen.HEIGHT - sprite.getY()) * SCREEN_SIZE_MULTIPLIER;
    }

}
