package com.alevat.spaceinvaders.awt;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.*;

import com.alevat.spaceinvaders.game.Console;
import com.alevat.spaceinvaders.io.RenderingEngine;
import com.alevat.spaceinvaders.io.Sprite;

class JavaAWTRenderingEngine implements RenderingEngine {

    private static final int DISPLAY_MODE_HEIGHT = 300;
    private static final int DISPLAY_MODE_WIDTH = 400;
    private final Console console;
    private GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
    private Frame frame;
    private ScreenPanel screenPanel;

    JavaAWTRenderingEngine(Console console) {
        this.console = console;
    }

    @Override
    public void initializeScreen() {
        initializeFrame();
        initializeScreenPanel();
        displayScreen();
    }

    private void initializeFrame() {
        frame = new Frame();
        frame.setUndecorated(true);
        frame.setIgnoreRepaint(true);
    }

    private void initializeScreenPanel() {
        screenPanel = new ScreenPanel();
        screenPanel.initialize();
    }

    private void displayScreen() {
        graphicsDevice.setFullScreenWindow(frame);
        if (graphicsDevice.isDisplayChangeSupported()) {
            selectDisplayMode();
        }
        Rectangle bounds = frame.getBounds();
        frame.createBufferStrategy(3);
        BufferStrategy bufferStrategy = frame.getBufferStrategy();
        do {
            do {
                Graphics graphics = bufferStrategy.getDrawGraphics();
                screenPanel.renderScreenImage(graphics);
                graphics.dispose();
            } while (bufferStrategy.contentsRestored());
            bufferStrategy.show();
        } while (bufferStrategy.contentsLost());
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
        screenPanel.addSprite(sprite);
    }

    @Override
    public void removeSprite(Sprite sprite) {
        screenPanel.removeSprite(sprite);
    }

    @Override
    public void renderScreen() {
        screenPanel.renderScreen();
    }

    void registerKeyListener(JavaAWTKeyListener keyListener) {
        screenPanel.addKeyListener(keyListener);
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
