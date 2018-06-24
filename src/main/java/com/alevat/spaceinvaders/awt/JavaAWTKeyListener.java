package com.alevat.spaceinvaders.awt;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.alevat.spaceinvaders.game.Console;
import com.alevat.spaceinvaders.io.InputListener;

class JavaAWTKeyListener implements KeyListener {

    private final Console console;
    private InputListener inputListener;

    public JavaAWTKeyListener(Console console) {
        this.console = console;
    }

    @Override
    public void keyTyped(KeyEvent event) {
        console.info("keyTyped(): " + event);
            // ignore
    }

    @Override
    public void keyPressed(KeyEvent event) {
        console.info("keyPressed(): " + event);
        switch (event.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                inputListener.quit();
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                inputListener.leftPressed();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                inputListener.rightPressed();
                break;
            case KeyEvent.VK_SPACE:
                inputListener.firePressed();
                break;
            default:
                // ignore
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        console.info("keyReleased(): " + event);
        switch (event.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                inputListener.leftReleased();
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                inputListener.rightReleased();
                break;
            default:
                // ignore
        }
    }

    void setInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }
}
