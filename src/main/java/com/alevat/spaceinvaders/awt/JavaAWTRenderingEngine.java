package com.alevat.spaceinvaders.awt;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.*;

import com.alevat.spaceinvaders.game.Console;
import com.alevat.spaceinvaders.game.Screen;
import com.alevat.spaceinvaders.io.ImageResource;
import com.alevat.spaceinvaders.io.RenderingEngine;
import com.alevat.spaceinvaders.io.Sprite;

import static java.awt.Image.SCALE_SMOOTH;

class JavaAWTRenderingEngine implements RenderingEngine {

    private static final int DISPLAY_MODE_HEIGHT = 300;
    private static final int DISPLAY_MODE_WIDTH = 400;
    private final static int SCREEN_SIZE_MULTIPLIER = 4;

    private final Console console;
    private GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
    private Frame frame;
    private final Set<Sprite> sprites = new HashSet<>();
    private final Map<ImageResource, BufferedImage> resizedImageMap = new HashMap<>();
    private BufferStrategy bufferStrategy;
    private Rectangle frameBounds;

    JavaAWTRenderingEngine(Console console) {
        this.console = console;
    }

    @Override
    public void initializeScreen() {
        initializeFrame();
        displayScreen();
    }

    private void initializeFrame() {
        frame = new Frame(graphicsDevice.getDefaultConfiguration());
        frame.setUndecorated(true);
        frame.setIgnoreRepaint(true);
    }

    private void displayScreen() {
        frame.requestFocus();
        graphicsDevice.setFullScreenWindow(frame);
        if (graphicsDevice.isDisplayChangeSupported()) {
            selectDisplayMode();
        }
        frameBounds = frame.getBounds();
        frame.createBufferStrategy(2);
        bufferStrategy = frame.getBufferStrategy();
    }

    private void selectDisplayMode() {
        for (DisplayMode mode : graphicsDevice.getDisplayModes()) {
            if (mode.getHeight() == DISPLAY_MODE_HEIGHT && mode.getWidth() == DISPLAY_MODE_WIDTH) {
                graphicsDevice.setDisplayMode(mode);
            }
            return;
        }
        throw new IllegalStateException("Couldn't find required display mode");
    }

    @Override
    public void addSprite(Sprite sprite) {
        sprites.add(sprite);
    }

    @Override
    public void removeSprite(Sprite sprite) {
        sprites.remove(sprite);
    }

    @Override
    public void renderScreen() {
        do {
            do {
                Graphics graphics = bufferStrategy.getDrawGraphics();
                graphics.setColor(Color.black);
                graphics.fillRect(0, 0, (int) frameBounds.getWidth(), (int) frameBounds.getHeight());
                renderScreenImage(graphics);
                graphics.dispose();
            } while (bufferStrategy.contentsRestored());
            bufferStrategy.show();
        } while (bufferStrategy.contentsLost());
    }

    private void renderScreenImage(Graphics graphics) {
        renderSprites(graphics);
    }

    private void renderSprites(Graphics graphics) {
        for (Sprite sprite : sprites) {
            renderSprite(sprite, graphics);
        }
    }

    private void renderSprite(Sprite sprite, Graphics graphics) {
        BufferedImage bufferedImage = getBufferedImage(sprite);
        int x = getX(sprite);
        int y = getY(sprite);
        graphics.drawImage(bufferedImage, x, y, null);
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
    void registerKeyListener(JavaAWTKeyListener keyListener) {
        frame.addKeyListener(keyListener);
    }

    void close() {
        frame.setVisible(false);
        frame.dispose();
    }

//    // Create a general double-buffering strategy
// w.createBufferStrategy(2);
//    BufferStrategy strategy = w.getBufferStrategy();
//
//    // Main loop
// while (!done) {
//        // Prepare for rendering the next frame
//        // ...
//
//        // Render single frame
//        do {
//            // The following loop ensures that the contents of the drawing buffer
//            // are consistent in case the underlying surface was recreated
//            do {
//                // Get a new graphics context every time through the loop
//                // to make sure the strategy is validated
//                Graphics graphics = strategy.getDrawGraphics();
//
//                // Render to graphics
//                // ...
//
//                // Dispose the graphics
//                graphics.dispose();
//
//                // Repeat the rendering if the drawing buffer contents
//                // were restored
//            } while (strategy.contentsRestored());
//
//            // Display the buffer
//            strategy.show();
//
//            // Repeat the rendering if the drawing buffer was lost
//        } while (strategy.contentsLost());
//    }
//
//    // Dispose the window
// w.setVisible(false);
// w.dispose();

}
