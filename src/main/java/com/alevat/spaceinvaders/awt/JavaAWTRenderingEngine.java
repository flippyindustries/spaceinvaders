package com.alevat.spaceinvaders.awt;

import java.awt.event.WindowEvent;
import javax.swing.*;

import com.alevat.spaceinvaders.game.Console;
import com.alevat.spaceinvaders.io.RenderingEngine;
import com.alevat.spaceinvaders.io.Sprite;

class JavaAWTRenderingEngine implements RenderingEngine {

    private final Console console;
    private JFrame jFrame;
    private ScreenPanel screenPanel;

    JavaAWTRenderingEngine(Console console) {
        this.console = console;
    }

    @Override
    public void initializeScreen() {
        initializeJFrame();
        initializeScreenPanel();
        displayScreen();
    }

    private void initializeJFrame() {
        jFrame = new JFrame();
        jFrame.setUndecorated(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initializeScreenPanel() {
        screenPanel = new ScreenPanel();
        screenPanel.initialize();
    }

    private void displayScreen() {
        jFrame.setContentPane(screenPanel);
        jFrame.pack();
        jFrame.setVisible(true);
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
        jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
    }
}
